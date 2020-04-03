package com.ycl.share.backend.service.impl;

import com.ycl.share.backend.dao.PraiseDao;
import com.ycl.share.backend.model.Praise;
import com.ycl.share.backend.service.PraiseService;
import com.ycl.share.common.Result;
import com.ycl.share.entity.backend.req.PraiseReq;
import com.ycl.share.entity.user.resp.UserResp;
import com.ycl.share.utils.BeanUtil;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.Date;

/**
 * 点赞service
 */
@Service
public class PraiseServiceImpl implements PraiseService {

    @Resource
    private PraiseDao praiseDao;

    @Override
    public Result addPraise(PraiseReq req, UserResp loginUser) {
        if (null == req.getDynamicId()) {
            return Result.error("动态ID不能为空");
        }
        // 查看是否已经点赞
        Praise praiseIsNull = praiseDao.findByDynamicIdAndCreateBy(req.getDynamicId(), loginUser.getLoginName());
        if (null != praiseIsNull) {
            return Result.success(praiseIsNull.getId());
        }
        Praise praise = BeanUtil.copyBean(req, Praise.class);
        praise.setCreateBy(loginUser.getLoginName());
        praise.setPhotoUrl(loginUser.getPhotoUrl());
        praise.setCreateTime(new Date());
        Praise save = praiseDao.save(praise);
        if (null == save || save.getId() == null) {
            return Result.error("点赞失败");
        }
        return Result.success(save.getId());
    }
}
