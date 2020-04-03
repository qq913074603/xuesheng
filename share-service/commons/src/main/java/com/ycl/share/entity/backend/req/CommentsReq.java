package com.ycl.share.entity.backend.req;

import lombok.Data;

import java.io.Serializable;
import java.util.Date;

/**
 *  t_comments 评论消息
 * @author 杨晨露 2020-03-30
 */
@Data
public class CommentsReq implements Serializable {

    private static final long serialVersionUID = 425407306134549430L;

    /**
     * id
     */
    private Long id;

    /**
     * 动态主键
     */
    private Long dynamicId;

    /**
     * 消息
     */
    private String message;

    /**
     * 头像
     */
    private String photoUrl;

    /**
     * 评论人名
     */
    private String userName;

    /**
     * 创建人
     */
    private String createBy;

    /**
     * 创建时间
     */
    private Date createTime;
}
