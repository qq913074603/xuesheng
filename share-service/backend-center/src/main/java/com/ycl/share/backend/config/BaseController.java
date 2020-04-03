package com.ycl.share.backend.config;

import com.ycl.share.entity.user.resp.UserResp;
import com.ycl.share.utils.ServletUtils;
import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;

/**
 * 公共controller
 */
@Slf4j
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
