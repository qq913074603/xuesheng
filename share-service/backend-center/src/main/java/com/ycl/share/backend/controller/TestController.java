package com.ycl.share.backend.controller;

import com.ycl.share.backend.feign.UserCenterFeign;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.Resource;

@RestController
public class TestController {

    @Resource
    private UserCenterFeign userCenterFeign;

    @GetMapping("/test/hello")
    public String helloWorld() {
        return userCenterFeign.helloWorld();
    }
}
