package com.ycl.share.backend.controller;

import com.alibaba.fastjson.JSON;
import com.ycl.share.backend.config.BaseController;
import com.ycl.share.backend.service.CommentsService;
import com.ycl.share.common.Result;
import com.ycl.share.entity.backend.req.CommentsReq;
import com.ycl.share.entity.backend.req.DynamicReq;
import com.ycl.share.entity.user.resp.UserResp;
import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.Resource;

/**
 * 评论控制层
 */
@Slf4j
@RestController
public class CommentsController extends BaseController {

    @Resource
    private CommentsService commentsService;


    /**
     * 新增动态
     * @param req
     * @return
     */
    @PostMapping("comments/add")
    public Result addComments(@RequestBody CommentsReq req) {
        try {
            UserResp loginUser = getLoginUser();
            if (null == loginUser) {
                return Result.error("用户未登录");
            }
            return commentsService.addComments(req, loginUser);
        } catch (Exception e) {
            log.error("\n 模块:{}, \n 方法:{}, \n 参数:{}, \n 错误:{} ", "CommentsController", "addComments", JSON.toJSONString(req), e);
        }
        return Result.error("网络异常，联系管理员");
    }

}
