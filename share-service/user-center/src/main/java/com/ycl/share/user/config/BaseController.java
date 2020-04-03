package com.ycl.share.user.config;

import com.ycl.share.entity.user.resp.UserResp;
import com.ycl.share.user.model.User;
import com.ycl.share.utils.ServletUtils;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;

/**
 * 公共controller
 */
public class BaseController {

    @Resource
    private RedisUtil redisUtil;

    /**
     * 获取登录用户
     * @return
     */
    public UserResp getLoginUser() {
        HttpServletRequest request = ServletUtils.getRequest();
        String authorization = request.getHeader("Authorization");
        if (null == authorization) {
            return null;
        }
        UserResp user = (UserResp) redisUtil.get(authorization);
        return user;
    }
}
