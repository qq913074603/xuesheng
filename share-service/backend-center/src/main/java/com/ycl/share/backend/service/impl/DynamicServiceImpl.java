package com.ycl.share.backend.service.impl;

import com.ycl.share.backend.dao.CommentsDao;
import com.ycl.share.backend.dao.DynamicDao;
import com.ycl.share.backend.dao.PraiseDao;
import com.ycl.share.backend.feign.UserCenterFeign;
import com.ycl.share.backend.model.Comments;
import com.ycl.share.backend.model.Dynamic;
import com.ycl.share.backend.model.Praise;
import com.ycl.share.backend.service.DynamicService;
import com.ycl.share.common.Result;
import com.ycl.share.entity.backend.req.DynamicReq;
import com.ycl.share.entity.user.req.UserGzReq;
import com.ycl.share.entity.user.resp.UserGzResp;
import com.ycl.share.entity.user.resp.UserResp;
import com.ycl.share.utils.BeanUtil;
import org.apache.commons.lang3.StringUtils;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Optional;

@Service
public class DynamicServiceImpl implements DynamicService {

    @Resource
    private DynamicDao dynamicDao;
    @Resource
    private PraiseDao praiseDao;
    @Resource
    private CommentsDao commentsDao;
    @Resource
    private UserCenterFeign userCenterFeign;

    @Override
    public Result<Page<Dynamic>> pageDynamic(DynamicReq req, UserResp loginUser) {
        // spring boot 2.0推荐写法
        Pageable pageable = PageRequest.of(req.getPageNumber(), req.getPageSize(), new Sort(Sort.Direction.DESC,"id"));
        Page<Dynamic> pageDynamic = dynamicDao.findAll(pageable);

        // 获取关注
        for (Dynamic dynamic : pageDynamic.getContent()) {
            // 点赞处理
            List<Praise>  praiseList = praiseDao.findByDynamicId(dynamic.getId());
            if (!praiseList.isEmpty()) {
                // 数量
                dynamic.setPraiseNum(praiseList.size());
                // 点赞头像图片
                List<String> praiseImgs = new ArrayList<>();
                for (Praise praise : praiseList) {
                    praiseImgs.add(praise.getPhotoUrl());
                }
                dynamic.setPraiseUrl(praiseImgs);
            }


            // 评论处理
            List<Comments>  commentsList = commentsDao.findByDynamicId(dynamic.getId());
            if (!commentsList.isEmpty()) {
                dynamic.setCommentsList(commentsList);
            }
        }

        // 关注处理
        if (null != loginUser) {
            UserGzReq userGzReq = new UserGzReq();
            userGzReq.setUserId(loginUser.getId());
            Result<List<UserGzResp>> userGzByUserId = userCenterFeign.findUserGzByUserId(userGzReq);
            if (userGzByUserId.isSuccess() && !userGzByUserId.getData().isEmpty()) {
                // 查看当前数据的用户是否被关注
                for (Dynamic dynamic : pageDynamic.getContent()) {
                    for (UserGzResp datum : userGzByUserId.getData()) {
                        if (dynamic.getCreateBy().equals(datum.getGzLoginName())) {
                            dynamic.setGuanzhu(true);
                            break;
                        }
                    }
                }
            }
        }

        return Result.success(pageDynamic);
    }


    @Override
    public Result addDynamic(DynamicReq req, UserResp loginUser) {
        if (StringUtils.isBlank(req.getTitle())) {
            return Result.error("标题不能为空");
        }
        if (StringUtils.isBlank(req.getMessage())) {
            return Result.error("内容不能为空");
        }
        Dynamic dynamic = BeanUtil.copyBean(req, Dynamic.class);
        dynamic.setCreateBy(loginUser.getLoginName());
        dynamic.setCreateTime(new Date());
        Dynamic save = dynamicDao.save(dynamic);
        if (null == save || save.getId() == null) {
            return Result.error("保存失败");
        }
        return Result.success(save.getId());
    }

    @Override
    public Result addGuanZhu(DynamicReq req, UserResp loginUser) {
        if (null == req.getId()) {
            return Result.error("动态ID不能为空");
        }
        Optional<Dynamic> byId = dynamicDao.findById(req.getId());
        if (null == byId.get()) {
            return Result.error("好友动态已被删除");
        }
        UserGzReq userGzReq = new UserGzReq();
        userGzReq.setUserId(loginUser.getId());
        userGzReq.setLoginName(loginUser.getLoginName());
        userGzReq.setGzLoginName(byId.get().getCreateBy());
        return userCenterFeign.addUserGz(userGzReq);
    }

}
