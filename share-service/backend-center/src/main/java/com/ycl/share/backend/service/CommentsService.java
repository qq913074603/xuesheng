package com.ycl.share.backend.service;

import com.ycl.share.common.Result;
import com.ycl.share.entity.backend.req.CommentsReq;
import com.ycl.share.entity.user.resp.UserResp;

/**
 * 评论
 */
public interface CommentsService {

    /**
     * 新增评论薪资
     * @param req
     * @param loginUser
     * @return
     */
    Result addComments(CommentsReq req, UserResp loginUser);
}
