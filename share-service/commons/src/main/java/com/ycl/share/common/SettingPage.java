package com.ycl.share.common;

import lombok.Data;

@Data
public class SettingPage {

    /**
     * 起始页
     */
    private Integer pageNumber = 0;

    /**
     * 每页条数
     */
    private Integer pageSize = 10;


}
