package com.ycl.share.user.service;

import com.ycl.share.common.Result;
import com.ycl.share.entity.user.req.UserReq;
import com.ycl.share.entity.user.resp.UserResp;

import java.util.List;
import java.util.Map;

/**
 * 用户中心
 */
public interface UserService {

    Result<List<UserResp>> queryList(UserReq req);

    /**
     * 用户密码登录
     * @param userReq
     * @return
     */
    Result<Map<String, Object>> login(UserReq userReq);

    Result register(UserReq userReq);
}
