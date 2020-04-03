package com.ycl.share.user.controller;

import com.alibaba.fastjson.JSON;
import com.ycl.share.common.Result;
import com.ycl.share.entity.user.req.UserReq;
import com.ycl.share.entity.user.resp.UserResp;
import com.ycl.share.user.config.BaseController;
import com.ycl.share.user.model.User;
import com.ycl.share.user.service.UserService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.Resource;
import java.util.Map;

/**
 * 用户控制层
 */
@Slf4j
@RestController
public class LonginController extends BaseController {


    @Resource
    private UserService userService;



    /**
     * 登录
     * @param userReq
     * @return
     */
    @PostMapping("login/login")
    public Result<Map<String, Object>> login(@RequestBody UserReq userReq) {
        try {
            return userService.login(userReq);
        } catch (Exception e) {
            log.error("\n 模块:{}, \n 方法:{}, \n 参数:{}, \n 错误:{} ", "LonginController", "login", JSON.toJSONString(userReq), e);
        }
        return Result.error("网络异常，联系管理员");
    }

    /**
     * 注册
     * @param userReq
     * @return
     */
    @PostMapping("login/register")
    public Result register(@RequestBody UserReq userReq) {
        try {
            return userService.register(userReq);
        } catch (Exception e) {
            log.error("\n 模块:{}, \n 方法:{}, \n 参数:{}, \n 错误:{} ", "LonginController", "register", JSON.toJSONString(userReq), e);
        }
        return Result.error("网络异常，联系管理员");
    }

    /**
     * 获取登录用户
     * @return
     */
    @GetMapping("login/user")
    public Result getUser() {
        try {
            UserResp loginUser = this.getLoginUser();
            if (null == loginUser) {
                return Result.error("用户未登录");
            }
            return Result.success(loginUser);
        } catch (Exception e) {
            log.error("\n 模块:{}, \n 方法:{}, \n 参数:{}, \n 错误:{} ", "LonginController", "getUser", JSON.toJSONString(null), e);
        }
        return Result.error("网络异常，联系管理员");
    }
}
