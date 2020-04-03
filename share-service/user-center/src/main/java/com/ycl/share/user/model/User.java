package com.ycl.share.user.model;

import lombok.Data;

import javax.persistence.*;
import java.io.Serializable;
import java.util.Date;


/**
 *  t_user
 * @author 杨晨露 2020-03-30
 */
@Data
@Entity
@Table(name = "t_user")
public class User implements Serializable {

    private static final long serialVersionUID = -6585310791759528746L;

    /**
     * id
     */
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    /**
     * 用户名
     */
    @Column(name = "user_name")
    private String userName;

    /**
     * 登录名
     */
    @Column(name = "login_name")
    private String loginName;

    /**
     * 密码
     */
    @Column(name = "password")
    private String password;

    /**
     * 头像url
     */
    @Column(name = "photo_url")
    private String photoUrl;

    /**
     * 性别
     */
    @Column(name = "sex")
    private String sex;


    /**
     * 年龄
     */
    @Column(name = "age")
    private Integer age;

    /**
     * 手机号
     */
    @Column(name = "phone")
    private String phone;

    /**
     * 创建时间
     */
    @Column(name = "create_time")
    private Date createTime;

    /**
     * 创建人
     */
    @Column(name = "create_by")
    private String createBy;
}
