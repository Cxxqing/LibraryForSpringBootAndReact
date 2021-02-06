package com.carey.lib.api.model;


import com.carey.lib.api.eums.ValidFlagEnum;
import lombok.Data;

import java.util.Date;

/**
 * 实体类父类
 * @author Carey
 */
@Data
public class BaseDTO {

    /**
     * 数据ID
     */
    private int id;


    /**
     * 临时字段1
     */
    private String tmp1;

    /**
     * 临时字段2
     */
    private String tmp2;

    /**
     * 创建时间
     */
    private Date createDate;

    /**
     * 更新时间
     */
    private Date updateDate;

    /**
     * 数据有效性
     */
    private ValidFlagEnum validFlag;

}
