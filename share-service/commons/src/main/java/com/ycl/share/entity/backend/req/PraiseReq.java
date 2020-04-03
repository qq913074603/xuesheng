package com.ycl.share.entity.backend.req;

import lombok.Data;

import java.io.Serializable;
import java.util.Date;

/**
 *  t_praise 点赞
 * @author 杨晨露 2020-03-30
 */
@Data
public class PraiseReq implements Serializable {

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
     * 头像
     */
    private String photoUrl;

    /**
     * 创建人
     */
    private String createBy;

    /**
     * 创建时间
     */
    private Date createTime;


}
