package com.ycl.share.backend.feign;

import com.alibaba.fastjson.JSON;
import com.ycl.share.common.Result;
import com.ycl.share.entity.user.req.UserGzReq;
import com.ycl.share.entity.user.req.UserReq;
import com.ycl.share.entity.user.resp.UserGzResp;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;

import java.util.List;
import java.util.Map;

/**
 * 用户中心Feign
 */
@FeignClient("user-center")
public interface UserCenterFeign {

    /**
     * 测试
     * @return
     */
    @GetMapping("/test/hello")
    String helloWorld();

    /**
     * 新增关注用户
     * @param req
     * @return
     */
    @PostMapping("usergz/addUserGz")
    Result addUserGz(@RequestBody UserGzReq req);


    /**
     * 根据用户ID获取关注对象
     * @param req
     * @return
     */
    @PostMapping("usergz/findUserGzByUserId")
    Result<List<UserGzResp>> findUserGzByUserId(@RequestBody UserGzReq req);

    /**
     * 登录
     * @param userReq
     * @return
     */
    @PostMapping("login/login")
    Result<Map<String, Object>> login(@RequestBody UserReq userReq);

    /**
     * 注册
     * @param userReq
     * @return
     */
    @PostMapping("login/register")
    Result register(@RequestBody UserReq userReq);
}
