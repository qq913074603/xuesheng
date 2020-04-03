package com.ycl.share.backend.controller;

import com.alibaba.fastjson.JSON;
import com.ycl.share.backend.config.BaseController;
import com.ycl.share.backend.service.PraiseService;
import com.ycl.share.common.Result;
import com.ycl.share.entity.backend.req.PraiseReq;
import com.ycl.share.entity.user.resp.UserResp;
import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.Resource;

/**
 * 点赞控制层
 */
@Slf4j
@RestController
public class PraiseController extends BaseController {

    @Resource
    private PraiseService praiseService;


    /**
     * 点赞
     * @param req
     * @return
     */
    @PostMapping("praise/add")
    public Result addPraise(@RequestBody PraiseReq req) {
        try {
            UserResp loginUser = getLoginUser();
            if (null == loginUser) {
                return Result.error("用户未登录");
            }
            return praiseService.addPraise(req, loginUser);
        } catch (Exception e) {
            log.error("\n 模块:{}, \n 方法:{}, \n 参数:{}, \n 错误:{} ", "BaseController", "addPraise", JSON.toJSONString(req), e);
        }
        return Result.error("网络异常，联系管理员");
    }

}
