package com.ycl.share.entity.backend.resp;

import com.ycl.share.common.SettingPage;
import lombok.Data;

import java.io.Serializable;
import java.util.Date;


/**
 *  t_dynamic
 * @author 杨晨露 2020-03-30
 */
@Data
public class DynamicResp extends SettingPage implements Serializable {

    private static final long serialVersionUID = 425407306134549431L;

    /**
     * id
     */
    private Long id;

    /**
     * 标题
     */
    private String title;

    /**
     * 消息内容
     */
    private String message;

    /**
     * 图片
     */
    private String imgUrl;

    /**
     * 点赞人
     */
    private String praiseName;

    /**
     * 点赞数量
     */
    private Integer praiseNum;

    /**
     * 创建时间
     */
    private Date createTime;

    /**
     * 创建人
     */
    private String createBy;
}
