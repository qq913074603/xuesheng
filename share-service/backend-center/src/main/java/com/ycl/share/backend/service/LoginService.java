package com.ycl.share.backend.service;

import com.ycl.share.common.Result;
import com.ycl.share.entity.user.req.UserReq;

import java.util.Map;

public interface LoginService {

    /**
     * 通过MQ发送邮箱验证码
     * @param userReq
     * @return
     */
    Result sendLoginCode(UserReq userReq);

    /**
     * 注册新的用户
     * @param userReq
     * @return
     */
    Result register(UserReq userReq);

    /**
     * 登录
     * @param userReq
     * @return
     */
    Result<Map<String, Object>> login(UserReq userReq);
}
