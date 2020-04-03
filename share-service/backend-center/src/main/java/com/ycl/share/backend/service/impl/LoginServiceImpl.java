package com.ycl.share.backend.service.impl;

import com.alibaba.fastjson.JSON;
import com.ycl.share.backend.config.RedisUtil;
import com.ycl.share.backend.feign.UserCenterFeign;
import com.ycl.share.backend.service.LoginService;
import com.ycl.share.common.Result;
import com.ycl.share.entity.user.req.UserReq;
import lombok.extern.slf4j.Slf4j;
import org.springframework.amqp.rabbit.core.RabbitTemplate;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.Map;

/**
 * 登录业务
 */
@Slf4j
@Service
public class LoginServiceImpl implements LoginService {

    @Resource
    private RabbitTemplate rabbitTemplate;  //使用RabbitTemplate,这提供了接收/发送等等方法
    @Resource
    private RedisUtil redisUtil;
    @Resource
    private UserCenterFeign userCenterFeign;

    @Override
    public Result sendLoginCode(UserReq userReq) {
        if (null == userReq.getLoginName()) {
            return Result.error("邮箱不能为空");
        }
        // 消息创建
        // 消费在 user-center模块
        rabbitTemplate.convertAndSend("UserDirectExchange", "UserDirectRouting", JSON.toJSONString(userReq));
        return Result.success();
    }

    @Override
    public Result register(UserReq userReq) {
        if (null == userReq.getLoginName()) {
            return Result.error("账号不能为空");
        }
        if (null == userReq.getPassword()) {
            return Result.error("密码不能为空");
        }
        if (null == userReq.getCode()) {
            return Result.error("验证码不能为空");
        }
        // 校验验证码是否正确
        String code = (String)redisUtil.get("loginCode:" + userReq.getLoginName());
        if (null == code) {
            return Result.error("验证码过期");
        }
        if (!code.equals(userReq.getCode())) {
            return Result.error("验证码错误");
        }
        // 删除验证码
        redisUtil.del("loginCode:" + userReq.getLoginName());
        return userCenterFeign.register(userReq);
    }

    @Override
    public Result<Map<String, Object>> login(UserReq userReq) {
        return userCenterFeign.login(userReq);
    }
}
