package com.ycl.share.user.mqconsumer;

import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.JSONObject;
import com.ycl.share.common.RandomNumberUtils;
import com.ycl.share.entity.user.req.UserReq;
import com.ycl.share.user.config.RedisUtil;
import com.ycl.share.user.model.User;
import com.ycl.share.user.service.SendMailService;
import org.springframework.amqp.rabbit.annotation.RabbitHandler;
import org.springframework.amqp.rabbit.annotation.RabbitListener;
import org.springframework.stereotype.Component;

import javax.annotation.Resource;
import java.util.UUID;

/**
 * 登录消费者
 */
@Component
@RabbitListener(queues = "UserDirectQueue")//监听的队列名称 UserDirectQueue
public class UserDirectRoutingConsumer {

    @Resource
    private RedisUtil redisUtil;
    @Resource
    private SendMailService sendMailService;

    @RabbitHandler
    public void process(String message) {
        JSONObject json = JSON.parseObject(message);
        System.out.println("DirectReceiver消费者收到消息  : " + json.getString("loginName"));
        String num = RandomNumberUtils.randomCode(6);
        // 放入redis 过期时间5分钟
        redisUtil.set("loginCode:" + json.getString("loginName"), num, 60 * 5);
        sendMailService.sendMail(json.getString("loginName"), "您好，注册码通知", "您的注册码为；" + num + "，有效时间为五分钟");
    }
}
