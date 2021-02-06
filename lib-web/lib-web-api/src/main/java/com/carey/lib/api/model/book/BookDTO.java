package com.carey.lib.api.model.book;

import com.carey.lib.api.model.BaseDTO;
import lombok.Data;

import java.io.Serializable;
import java.math.BigDecimal;
import java.util.Date;

/**
 * 书籍分类实体类
 * @author Carey
 */
@Data
public class BookDTO extends BaseDTO implements Serializable {

    private static final long serialVersionUID = 2341957180538733716L;
    /**
     * 书籍名称
     */
    private String bookName;

    /**
     * 书籍分类名称
     */
    private int bookClassId;

    /**
     * 书籍价格
     */
    private BigDecimal bookPrice;

    /**
     * 书籍出版社
     */
    private String bookPublish;

    /**
     * 书籍作者
     */
    private String bookAuthor;

    /**
     * 书籍图片（多个用分号隔开）
     */
    private String bookImg;

    /**
     * 书籍出版时间
     */
    private Date publishDate;
}
