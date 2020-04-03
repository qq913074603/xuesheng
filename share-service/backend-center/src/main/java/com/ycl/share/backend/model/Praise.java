package com.ycl.share.backend.model;

import lombok.Data;

import javax.persistence.*;
import java.io.Serializable;
import java.util.Date;

/**
 *  t_praise 点赞
 * @author 杨晨露 2020-03-30
 */
@Data
@Entity
@Table(name = "t_praise")
public class Praise implements Serializable {

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
     * 头像
     */
    @Column(name = "photo_url")
    private String photoUrl;

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
