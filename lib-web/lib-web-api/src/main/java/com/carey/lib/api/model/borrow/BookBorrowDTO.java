package com.carey.lib.api.model.borrow;

import com.carey.lib.api.model.BaseDTO;
import lombok.Data;

import java.math.BigDecimal;
import java.util.Date;

/**
 * 借书实体类
 * @author Carey
 */
@Data
public class BookBorrowDTO extends BaseDTO {

    /**
     * 用户id
     */
    private Integer userId;

    /**
     * 用户名称
     */
    private String userName;

    /**
     * 书籍ID
     */
    private Integer bookId;

    /**
     * 书籍名称
     */
    private String bookName;

    /**
     * 书籍数量
     */
    private Integer count;

    /**
     * 借书时间
     */
    private Date startDate;

    /**
     * 还书时间
     */
    private Date endDate;

    /**
     * 借书费用
     */
    private BigDecimal price;

    /**
     * 实际借书费用
     */
    private BigDecimal tradeFee;
}
