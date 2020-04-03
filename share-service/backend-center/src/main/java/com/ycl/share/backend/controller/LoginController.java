package com.ycl.share.backend.controller;

import com.alibaba.fastjson.JSON;
import com.ycl.share.backend.service.LoginService;
import com.ycl.share.common.Result;
import com.ycl.share.entity.user.req.UserReq;
import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.Resource;
import java.util.Map;

/**
 * 登录控制层
 */
@Slf4j
@RestController
public class LoginController {

    @Resource
    private LoginService loginService;

    /**
     * 发送验证码
     * @param userReq
     * @return
     */
    @PostMapping("login/sendLoginCode")
    public Result sendLoginCode(@RequestBody UserReq userReq) {
        return loginService.sendLoginCode(userReq);
    }

    /**
     * 注册
     * @param userReq
     * @return
     */
    @PostMapping("login/register")
    public Result register(@RequestBody UserReq userReq) {
        try {
            return loginService.register(userReq);
        } catch (Exception e) {
            log.error("\n 模块:{}, \n 方法:{}, \n 参数:{}, \n 错误:{} ", "LoginController", "register", JSON.toJSONString(userReq), e);
        }
        return Result.error("网络异常，联系管理员");
    }

    /**
     * 登录
     * @param userReq
     * @return
     */
    @PostMapping("login/login")
    public Result<Map<String, Object>> login(@RequestBody UserReq userReq) {
        try {
            return loginService.login(userReq);
        } catch (Exception e) {
            log.error("\n 模块:{}, \n 方法:{}, \n 参数:{}, \n 错误:{} ", "LoginController", "login", JSON.toJSONString(userReq), e);
        }
        return Result.error("网络异常，联系管理员");
    }
}
