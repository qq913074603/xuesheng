package com.ycl.share.user.model;

import lombok.Data;

import javax.persistence.*;
import java.io.Serializable;

/**
 *  t_user_gz 关注的用户
 * @author 杨晨露 2020-03-30
 */
@Data
@Entity
@Table(name = "t_user_gz")
public class UserGz implements Serializable {

    private static final long serialVersionUID = -6585310792759528746L;

    /**
     * id
     */
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    /**
     * 用户id
     */
    @Column(name = "user_id")
    private Long userId;

    /**
     * 用户登录名
     */
    @Column(name = "login_name")
    private String loginName;

    /**
     * 关注id
     */
    @Column(name = "gz_user_id")
    private Long gzUserId;

    /**
     * 关注登录名
     */
    @Column(name = "gz_login_name")
    private String gzLoginName;
}
