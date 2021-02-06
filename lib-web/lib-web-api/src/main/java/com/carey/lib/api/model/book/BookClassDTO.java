package com.carey.lib.api.model.book;


import com.carey.lib.api.model.BaseDTO;
import lombok.Data;

import java.io.Serializable;

/**
 * 书籍分类实体类
 * @author Carey
 */
@Data
public class BookClassDTO extends BaseDTO implements Serializable {

    private static final long serialVersionUID = -1016980329257126953L;
    /**
     * 分类名称
     */
    private String name;
}
