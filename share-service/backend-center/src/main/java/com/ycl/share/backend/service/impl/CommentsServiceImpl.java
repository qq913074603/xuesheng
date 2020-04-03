package com.ycl.share.backend.service.impl;

import com.ycl.share.backend.dao.CommentsDao;
import com.ycl.share.backend.model.Comments;
import com.ycl.share.backend.model.Praise;
import com.ycl.share.backend.service.CommentsService;
import com.ycl.share.common.Result;
import com.ycl.share.entity.backend.req.CommentsReq;
import com.ycl.share.entity.user.resp.UserResp;
import com.ycl.share.utils.BeanUtil;
import org.apache.commons.lang3.StringUtils;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.Date;

/**
 * 评论service
 */
@Service
public class CommentsServiceImpl implements CommentsService {

    @Resource
    private CommentsDao commentsDao;

    @Override
    public Result addComments(CommentsReq req, UserResp loginUser) {
        if (null == req.getDynamicId()) {
            return Result.error("动态ID不能为空");
        }
        if (StringUtils.isBlank(req.getMessage())) {
            return Result.error("评论内容不能为空");
        }
        Comments comments = BeanUtil.copyBean(req, Comments.class);
        comments.setUserName(loginUser.getUserName());
        comments.setCreateBy(loginUser.getLoginName());
        comments.setPhotoUrl(loginUser.getPhotoUrl());
        comments.setCreateTime(new Date());
        Comments save = commentsDao.save(comments);
        if (null == save || save.getId() == null) {
            return Result.error("新增评论失败");
        }
        return Result.success(save.getId());
    }
}
