package com.ycl.share.user.controller;

import com.alibaba.fastjson.JSON;
import com.ycl.share.entity.user.resp.UserResp;
import com.ycl.share.user.config.BaseController;
import com.ycl.share.user.config.RedisUtil;
import com.ycl.share.user.service.SendMailService;
import org.springframework.mail.SimpleMailMessage;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.Resource;

@RestController
public class TestController extends BaseController {

    @Resource
    private RedisUtil redisUtil;
    @Resource
    private SendMailService sendMailService;

    @GetMapping("/test/hello")
    public String helloWorld() {
        return "helloWorld";
    }

    @GetMapping("/test/redis")
    public String testRedis() {
        redisUtil.set("test:name", "谢楠", 60 * 3);
        String o = (String)redisUtil.get("test:name");
        UserResp loginUser = getLoginUser();
        System.out.println(JSON.toJSONString(loginUser));
        return o;
    }



    @GetMapping("/test/sendMail")
    public String sendMail(){
        sendMailService.sendMail("736713830@qq.com", "测试发送邮件", "撒的发生的发送到发士大夫撒旦");
        return "success";
    }

}
