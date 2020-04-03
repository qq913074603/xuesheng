package com.ycl.share.backend.model;

import lombok.Data;

import javax.persistence.*;
import java.io.Serializable;
import java.util.Date;
import java.util.List;


/**
 *  t_dynamic
 * @author 杨晨露 2020-03-30
 */
@Data
@Entity
@Table(name = "t_dynamic")
public class Dynamic implements Serializable {

    private static final long serialVersionUID = 425407306134549430L;

    /**
     * id
     */
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    /**
     * 标题
     */
    @Column(name = "title")
    private String title;

    /**
     * 消息内容
     */
    @Column(name = "message")
    private String message;

    /**
     * 图片
     */
    @Column(name = "img_url")
    private String imgUrl;

    /**
     * 点赞人
     */
    @Column(name = "praise_name")
    private String praiseName;

    /**
     * 点赞数量
     */
    @Column(name = "praise_num")
    private Integer praiseNum;

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

    /***以下不是数据库字段**/

    /**
     * 点赞图片url
     */
    @Transient
    private List<String> praiseUrl;

    /**
     * 评论列表
     */
    @Transient
    private List<Comments> commentsList;

    /**
     * 是否关注 false 未关注 true 关注
     */
    @Transient
    private Boolean guanzhu = false;
}
