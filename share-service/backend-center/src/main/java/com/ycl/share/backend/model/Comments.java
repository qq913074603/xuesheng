package com.ycl.share.backend.model;

import lombok.Data;

import javax.persistence.*;
import java.io.Serializable;
import java.util.Date;

/**
 *  t_comments 评论消息
 * @author 杨晨露 2020-03-30
 */
@Data
@Entity
@Table(name = "t_comments")
public class Comments implements Serializable {

    private static final long serialVersionUID = 425407306134549430L;

    /**
     * id
     */
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    /**
     * 动态主键
     */
    @Column(name = "dynamic_id")
    private Long dynamicId;

    /**
     * 消息
     */
    @Column(name = "message")
    private String message;

    /**
     * 头像
     */
    @Column(name = "photo_url")
    private String photoUrl;

    /**
     * 评论人名
     */
    @Column(name = "user_name")
    private String userName;

    /**
     * 创建人
     */
    @Column(name = "create_by")
    private String createBy;

    /**
     * 创建时间
     */
    @Column(name = "create_time")
    private Date createTime;
}
