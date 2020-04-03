package com.ycl.share.backend.controller;

import com.alibaba.fastjson.JSON;
import com.ycl.share.backend.config.BaseController;
import com.ycl.share.backend.model.Dynamic;
import com.ycl.share.backend.service.DynamicService;
import com.ycl.share.common.Result;
import com.ycl.share.entity.backend.req.DynamicReq;
import com.ycl.share.entity.backend.resp.DynamicResp;
import com.ycl.share.entity.user.resp.UserResp;
import lombok.extern.slf4j.Slf4j;
import org.springframework.data.domain.Page;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.Resource;

/**
 * 发表动态控制层
 */
@Slf4j
@RestController
public class DynamicController extends BaseController {

    @Resource
    private DynamicService dynamicService;

    /**
     * 分页查询
     * @param req
     * @return
     */
    @PostMapping("dynamic/page")
    public Result<Page<Dynamic>> pageDynamic(@RequestBody DynamicReq req) {
        try {
            return dynamicService.pageDynamic(req, getLoginUser());
        } catch (Exception e) {
            log.error("\n 模块:{}, \n 方法:{}, \n 参数:{}, \n 错误:{} ", "DynamicController", "pageDynamic", JSON.toJSONString(req), e);
        }
        return Result.error("网络异常，联系管理员");
    }

    /**
     * 新增动态
     * @param req
     * @return
     */
    @PostMapping("dynamic/add")
    public Result addDynamic(@RequestBody DynamicReq req) {
        try {
            UserResp loginUser = getLoginUser();
            if (null == loginUser) {
                return Result.error("用户未登录");
            }
            return dynamicService.addDynamic(req, loginUser);
        } catch (Exception e) {
            log.error("\n 模块:{}, \n 方法:{}, \n 参数:{}, \n 错误:{} ", "DynamicController", "addDynamic", JSON.toJSONString(req), e);
        }
        return Result.error("网络异常，联系管理员");
    }

    /**
     * 新增关注用户
     * @param req
     * @return
     */
    @PostMapping("dynamic/addGuanZhu")
    public Result addGuanZhu(@RequestBody DynamicReq req) {
        try {
            UserResp loginUser = getLoginUser();
            if (null == loginUser) {
                return Result.error("用户未登录");
            }
            return dynamicService.addGuanZhu(req, loginUser);
        } catch (Exception e) {
            log.error("\n 模块:{}, \n 方法:{}, \n 参数:{}, \n 错误:{} ", "DynamicController", "addGuanZhu", JSON.toJSONString(req), e);
        }
        return Result.error("网络异常，联系管理员");
    }
}
