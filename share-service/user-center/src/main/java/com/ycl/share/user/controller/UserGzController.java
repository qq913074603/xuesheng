package com.ycl.share.user.controller;

import com.alibaba.fastjson.JSON;
import com.ycl.share.common.Result;
import com.ycl.share.entity.user.req.UserGzReq;
import com.ycl.share.entity.user.req.UserReq;
import com.ycl.share.entity.user.resp.UserGzResp;
import com.ycl.share.entity.user.resp.UserResp;
import com.ycl.share.user.config.BaseController;
import com.ycl.share.user.service.UserGzService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.Resource;
import java.util.List;

/**
 * 用户关注
 */
@Slf4j
@RestController
public class UserGzController extends BaseController {


    @Resource
    private UserGzService userGzService;


    /**
     * 关注用户
     * @param req
     * @return
     */
    @PostMapping("usergz/addUserGz")
    public Result addUserGz(@RequestBody UserGzReq req) {
        try {
            return userGzService.addUserGz(req);
        } catch (Exception e) {
            log.error("\n 模块:{}, \n 方法:{}, \n 参数:{}, \n 错误:{} ", "UserGzController", "addUserGz", JSON.toJSONString(req), e);
        }
        return Result.error("网络异常，联系管理员");
    }


    /**
     * 根据用户ID获取
     * @param req
     * @return
     */
    @PostMapping("usergz/findUserGzByUserId")
    public Result<List<UserGzResp>> findUserGzByUserId(@RequestBody UserGzReq req) {
        try {
            return userGzService.findUserGzByUserId(req);
        } catch (Exception e) {
            log.error("\n 模块:{}, \n 方法:{}, \n 参数:{}, \n 错误:{} ", "UserGzController", "findUserGzByUserId", JSON.toJSONString(req), e);
        }
        return Result.error("网络异常，联系管理员");
    }
}
