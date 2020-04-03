package com.ycl.share.backend.service;

import com.ycl.share.common.Result;
import com.ycl.share.entity.backend.req.PraiseReq;
import com.ycl.share.entity.user.resp.UserResp;

/**
 * 点赞实体
 */
public interface PraiseService {

    /**
     * 用户点赞
     * @param req
     * @param loginUser
     * @return
     */
    Result addPraise(PraiseReq req, UserResp loginUser);
}
