package com.ycl.share.entity.user.req;

import lombok.Data;

import java.io.Serializable;
import java.util.Date;


/**
 *  t_user
 * @author 杨晨露 2020-03-30
 */
@Data
public class UserReq implements Serializable {

    private static final long serialVersionUID = -6585310791759528745L;

    /**
     * id
     */
    private Long id;

    /**
     * 用户名
     */
    private String userName;

    /**
     * 登录名
     */
    private String loginName;

    /**
     * 密码
     */
    private String password;

    /**
     * 头像url
     */
    private String photoUrl;

    /**
     * 性别
     */
    private String sex;

    /**
     * 年龄
     */
    private Integer age;

    /**
     * 手机号
     */
    private String phone;

    /**
     * 创建时间
     */
    private Date createTime;

    /**
     * 创建人
     */
    private String createBy;

    /**
     * 邮箱验证码
     */
    private String code;
}
