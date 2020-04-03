package com.ycl.share.user.service;

import com.ycl.share.common.Result;
import com.ycl.share.entity.user.req.UserGzReq;
import com.ycl.share.entity.user.resp.UserGzResp;

import java.util.List;

/**
 * 用户关注
 */
public interface UserGzService {

    /**
     * 新增关注对象
     * @param req
     * @return
     */
    Result addUserGz(UserGzReq req);

    /**
     * 获取用户关注对象
     * @param req
     * @return
     */
    Result<List<UserGzResp>> findUserGzByUserId(UserGzReq req);
}
