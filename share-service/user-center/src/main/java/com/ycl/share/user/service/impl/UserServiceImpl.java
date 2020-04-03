package com.ycl.share.user.service.impl;

import com.ycl.share.common.Result;
import com.ycl.share.entity.user.req.UserReq;
import com.ycl.share.entity.user.resp.UserResp;
import com.ycl.share.user.config.RedisUtil;
import com.ycl.share.user.dao.UserDao;
import com.ycl.share.user.model.User;
import com.ycl.share.user.service.UserService;
import com.ycl.share.utils.BeanUtil;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.*;

/**
 * 用户业务层
 */
@Service
public class UserServiceImpl implements UserService {

    @Resource
    private UserDao userDao;
    @Resource
    private RedisUtil redisUtil;

    @Override
    public Result<List<UserResp>> queryList(UserReq req) {
        List<User> list = userDao.findAll();
        return Result.success(BeanUtil.copyBeanList(list, UserResp.class));
    }

    @Override
    public Result<Map<String, Object>> login(UserReq userReq) {
        User user = userDao.findByLoginNameAndPassword(userReq.getLoginName(), userReq.getPassword());
        if (null == user) {
            return Result.error("用户名密码错误");
        }
        // 用户唯一key
        String uuid = UUID.randomUUID().toString();
        Map<String, Object> map = new HashMap<>();
        map.put("login_uuid", uuid);
        map.put("login_time", 60 * 60 * 8);
        redisUtil.set(uuid, BeanUtil.copyBean(user, UserResp.class), 60 * 60 * 8);
        return Result.success(map);
    }

    @Override
    public Result register(UserReq userReq) {
        if (null == userReq.getLoginName()) {
            return Result.error("账号不能为空");
        }
        if (null == userReq.getPassword()) {
            return Result.error("密码不能为空");
        }
        // 判断用户是否存在
        User user = userDao.findByLoginName(userReq.getLoginName());
        if (null != user) {
            return Result.error("账号已注册");
        }
        user = BeanUtil.copyBean(userReq, User.class);
        user.setUserName(userReq.getLoginName());
        user.setCreateBy(userReq.getLoginName());
        user.setCreateTime(new Date());
        User save = userDao.save(user);
        return Result.success(save.getId());
    }
}
