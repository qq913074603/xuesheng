package com.ycl.share.entity.user.resp;

import lombok.Data;

import java.io.Serializable;

/**
 *  t_user_gz 关注的用户
 * @author 杨晨露 2020-03-30
 */
@Data
public class UserGzResp implements Serializable {

    private static final long serialVersionUID = -6585310792759528746L;

    /**
     * id
     */
    private Long id;

    /**
     * 用户id
     */
    private Long userId;

    /**
     * 用户登录名
     */
    private String loginName;

    /**
     * 关注id
     */
    private Long gzUserId;

    /**
     * 关注登录名
     */
    private String gzLoginName;
}
