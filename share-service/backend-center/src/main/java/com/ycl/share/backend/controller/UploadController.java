package com.ycl.share.backend.controller;

import com.alibaba.fastjson.JSONObject;
import com.ycl.share.common.Result;
import com.ycl.share.utils.DateUtils;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;

import javax.servlet.http.HttpServletRequest;
import java.io.*;
import java.util.Date;

/**
 * <p>Description: [上传信息]</p>
 * Created on 2020/1/19
 *
 *
 * @version 1.0
 * Copyright (c) 2020 北京柯莱特科技有限公司
 */
@Slf4j
@RestController
public class UploadController{

    // 设置上传文件夹
    File uploadPath = null;

    // IP
    private String fileIp = "http://127.0.0.1:8200";

    // 单文件上传
    @PostMapping("/file/upload")
    public Result<JSONObject> upload(@RequestParam(value = "file", required = false) MultipartFile file, HttpServletRequest request) throws Exception{
        System.out.println(file.getSize());
        // 校验文件的大小
        if (file.getSize() > 1024 * 1024 * 10) {
            return Result.error("文件大小不能超过10MB");
        }
        // 定义返回客户端json对象
        JSONObject returnData = new JSONObject();
        // 定义处理流对象
        BufferedOutputStream out = null;
        // win 基础文件上传路径
        String basePath = "D:\\images\\";
        // linux 基础文件上传路径
        // String basePath = "/data/file";
        File uploadPath = new File(basePath);
        //判断上传文件夹是否存在
        if(!uploadPath.exists()){
            uploadPath.mkdirs();
        }
        // 判断上传的文件是否为空
        if (file!=null) {
            // 获取上传文件后缀
            String houzhui = file.getOriginalFilename().split("\\.")[1];
            // 拼接上传文件保存路径(当前用户id+设备id+时间戳.后缀名)
            File fil = new File(uploadPath+"/" + new Date().getTime() + "." + houzhui);
            try {
                // 将上传文件保存到服务器上传文件夹目录下
                out = new BufferedOutputStream(new FileOutputStream(fil));
                out.write(file.getBytes());
                out.flush();
                out.close();
                returnData.put("message", fileIp + "/images/" + fil.getName());
            } catch (FileNotFoundException e) {
                e.printStackTrace();
                returnData.put("message", "文件上传失败:" + e.getMessage());
            } catch (IOException e) {
                e.printStackTrace();
                returnData.put("message", "文件上传失败:" + e.getMessage());
            }finally {
                //关闭处理流
                if(out!=null){out.close();}
            }
        } else {
            returnData.put("message", "文件上传失败,文件为空");
        }
        return Result.success(returnData);
    }

}
