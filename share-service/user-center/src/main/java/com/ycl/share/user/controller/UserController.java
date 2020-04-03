package com.ycl.share.user.controller;


import com.ycl.share.common.Result;
import com.ycl.share.entity.user.req.UserReq;
import com.ycl.share.entity.user.resp.UserResp;
import com.ycl.share.user.service.UserService;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.Resource;
import java.util.List;

/**
 * 用户控制层
 */
@RestController
public class UserController {

    @Resource
    private UserService userService;

    @PostMapping("/user/queryList")
    public Result<List<UserResp>> queryList(@RequestBody UserReq req){
        return userService.queryList(req);
    }

}
