package com.carey.lib.service.borrow;

import com.carey.lib.api.constants.ResultDTO;
import com.carey.lib.api.eums.HttpCode;
import com.carey.lib.api.eums.ValidFlagEnum;
import com.carey.lib.api.model.book.BookDTO;
import com.carey.lib.api.model.borrow.BookBorrowDTO;
import com.carey.lib.api.service.borrow.BookBorrowService;
import com.carey.lib.dao.mapper.book.BookMapper;
import com.carey.lib.dao.mapper.borrow.BookBorrowMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.math.BigDecimal;
import java.util.Date;

/**
 * 借书Service实现类
 * @author Carey
 */
@Service
public class BookBorrowServiceImpl implements BookBorrowService {

    @Autowired
    private BookBorrowMapper bookBorrowMapper;

    @Autowired
    private BookMapper bookMapper;

    @Override
    public ResultDTO doBookBorrow(int bookId, Date startDate, Date endDate, int borrowCount, int userId, String userName, boolean vipFlag) {
        // step1：非法校验
        // 要借的书的编号
        if (0 >= bookId){
            return new ResultDTO(HttpCode.FAIL.getCode(), "书籍编号不合法，请确认所选书籍是否存在");
        }

        // 租借起始截止日期（日期前后的非法校验交给前端来做）
        if (startDate.after(endDate)){
            return new ResultDTO(HttpCode.FAIL.getCode(), "起始日期不能晚于归还日期");
        }

        // step2：获取书籍
        if (borrowCount <= 0){
            return new ResultDTO(HttpCode.FAIL.getCode(), "借阅数量需要大于0");
        }
        BookDTO bookDTO = bookMapper.findById(bookId);
        // 2.1 书籍存在性判断
        if (null == bookDTO){
            return new ResultDTO(HttpCode.FAIL.getCode(), "书籍不存在");
        }

        // 2.2数量是否足够的校验
        int bookCount = bookDTO.getBookCount();
        if (bookCount <= 0){
            // TODO 在查找书籍的时候如果返回的书籍数量为0，前端直接禁用租借按钮，同时加一个效果：当前书籍已租借光了~
            return new ResultDTO(HttpCode.FAIL.getCode(), "当前书籍已被租借光了，请看看别的书吧！");
        }

        if (borrowCount > bookCount){
            return new ResultDTO(HttpCode.FAIL.getCode(), "借阅数量超过书籍数量，当前剩余数量："+bookCount);
        }

        // step 3：真正的借书操作
        int result = doInsertBookBorrowRecord( bookId, bookDTO, borrowCount, startDate, endDate, userId, userName, vipFlag);
        if (result<=0){
            // 新增失败
            return new ResultDTO(HttpCode.FAIL.getCode(), "借书失败，您可以尝试重新借书，或联系图书管理员处理");
        }

        // Step4：减少书籍数量
        bookDTO.setBookCount(bookCount-borrowCount);
        bookDTO.setUpdateDate(new Date());
        bookMapper.update(bookDTO);
        return new ResultDTO(HttpCode.SUCCESS.getCode(), "借书成功");
    }

    private int doInsertBookBorrowRecord(int bookId,BookDTO bookDTO,int borrowCount,Date startDate,Date endDate,int userId,String userName,boolean vipFlag) {
        BookBorrowDTO bookBorrowDTO = new BookBorrowDTO();
        bookBorrowDTO.setBookId(bookId);
        bookBorrowDTO.setBookName(bookDTO.getBookName());
        bookBorrowDTO.setCount(borrowCount);
        bookBorrowDTO.setStartDate(startDate);
        bookBorrowDTO.setEndDate(endDate);
        // 也可以从session获取
        bookBorrowDTO.setUserId(userId);
        bookBorrowDTO.setUserName(userName);
        // 设置书籍价格
        BigDecimal bookPrice = bookDTO.getBookPrice();
        long day = (endDate.getTime() - startDate.getTime()) / (24 * 60 * 60 * 1000);
        long totalPrice = bookPrice.intValue() * day;
        bookBorrowDTO.setPrice(new BigDecimal(totalPrice));
        bookBorrowDTO.setTradeFee(new BigDecimal(totalPrice));
        if (vipFlag){
            bookBorrowDTO.setTradeFee(new BigDecimal(0.0));
        }
        bookBorrowDTO.setCreateDate(new Date());
        bookBorrowDTO.setValidFlag(ValidFlagEnum.ENABLE);
        // 新增
        int result = bookBorrowMapper.insert(bookBorrowDTO);
        return result;
    }
}
