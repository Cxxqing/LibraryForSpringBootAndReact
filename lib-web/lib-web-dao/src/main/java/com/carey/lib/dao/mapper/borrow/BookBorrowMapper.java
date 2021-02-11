package com.carey.lib.dao.mapper.borrow;

import com.carey.lib.api.model.borrow.BookBorrowDTO;
import org.apache.ibatis.annotations.Mapper;

/**
 * 借书数据层
 * @author Carey
 */
@Mapper
public interface BookBorrowMapper {

    /**
     * 新增借书信息
     * @param bookBorrowDTO 借书信息实体类
     */
    int insert(BookBorrowDTO bookBorrowDTO);

    /**
     * 根据数据主键查找数据
     * @param id
     * @return
     */
    BookBorrowDTO findById(int id);

    /**
     * 更新借书实体类信息
     * @param localBookBorrowDTO 借书信息实体类
     */
    int update(BookBorrowDTO localBookBorrowDTO);
}
