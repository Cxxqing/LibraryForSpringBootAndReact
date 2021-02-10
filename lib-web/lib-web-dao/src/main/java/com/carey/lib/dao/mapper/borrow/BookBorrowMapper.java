package com.carey.lib.dao.mapper.borrow;

import com.carey.lib.api.model.borrow.BookBorrowDTO;
import org.apache.ibatis.annotations.Mapper;

/**
 * 借书数据层
 * @author Carey
 */
@Mapper
public interface BookBorrowMapper {

    int insert(BookBorrowDTO bookBorrowDTO);
}
