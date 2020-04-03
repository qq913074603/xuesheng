package com.ycl.share.user.service.impl;

import com.ycl.share.common.Result;
import com.ycl.share.entity.user.req.UserGzReq;
import com.ycl.share.entity.user.resp.UserGzResp;
import com.ycl.share.user.dao.UserDao;
import com.ycl.share.user.dao.UserGzDao;
import com.ycl.share.user.model.User;
import com.ycl.share.user.model.UserGz;
import com.ycl.share.user.service.UserGzService;
import com.ycl.share.utils.BeanUtil;
import org.apache.commons.lang3.StringUtils;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.List;

@Service
public class UserGzServiceImpl implements UserGzService {

    @Resource
    private UserDao userDao;
    @Resource
    private UserGzDao userGzDao;

    @Override
    public Result addUserGz(UserGzReq req) {
        if (null == req.getUserId()) {
            return Result.error("用户ID不能为空");
        }
        if (StringUtils.isBlank(req.getLoginName())) {
            return Result.error("用户登录名不能为空");
        }
        if (StringUtils.isBlank(req.getGzLoginName())) {
            return Result.error("需要关注的用户不能为空");
        }
        // 根据登录名获取用户对象
        User byLoginName = userDao.findByLoginName(req.getGzLoginName());
        if (null == byLoginName) {
            return Result.error("关注用户已被删除");
        }

        // 看用户是否已经关注
        UserGz userGzIsNull = userGzDao.findByUserIdAndGzUserId(req.getUserId(), byLoginName.getId());
        if (null != userGzIsNull) {
            // 已经关注成功不代表新增失败
            return Result.success(userGzIsNull.getId());
        }

        // 自己不能关注自己
        if (req.getUserId().compareTo(byLoginName.getId()) == 0) {
            return Result.error("不可以关注自己哦");
        }

        // 新增
        UserGz userGz = BeanUtil.copyBean(req, UserGz.class);
        userGz.setGzUserId(byLoginName.getId());
        UserGz save = userGzDao.save(userGz);
        if (null == save || null == save.getId()) {
            return Result.error("关注失败");
        }
        return Result.success(save.getId());
    }

    @Override
    public Result<List<UserGzResp>> findUserGzByUserId(UserGzReq req) {
        if (null == req.getUserId()) {
            return Result.error("用户ID不能为空");
        }
        List<UserGz> userGzList = userGzDao.findByUserId(req.getUserId());
        return Result.success(BeanUtil.copyBeanList(userGzList, UserGzResp.class));
    }
}
