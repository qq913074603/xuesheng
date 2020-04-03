package com.ycl.share.backend.service;

import com.ycl.share.backend.model.Dynamic;
import com.ycl.share.common.Result;
import com.ycl.share.entity.backend.req.DynamicReq;
import com.ycl.share.entity.backend.resp.DynamicResp;
import com.ycl.share.entity.user.resp.UserResp;
import org.springframework.data.domain.Page;

/**
 * 发表动态service
 */
public interface DynamicService {

    /**
     * 分页查询
     * @param req
     * @return
     */
    Result<Page<Dynamic>> pageDynamic(DynamicReq req, UserResp loginUser);

    /**
     * 新增动态
     * @param req
     * @return
     */
    Result addDynamic(DynamicReq req, UserResp loginUser);

    /**
     * 新增关注
     * @param req
     * @return
     */
    Result addGuanZhu(DynamicReq req, UserResp loginUser);
}
