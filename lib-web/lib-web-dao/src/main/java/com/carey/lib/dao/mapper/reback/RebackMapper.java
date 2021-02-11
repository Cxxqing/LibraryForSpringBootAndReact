package com.carey.lib.dao.mapper.reback;

import com.carey.lib.api.model.borrow.BookBorrowDTO;
import org.apache.ibatis.annotations.Mapper;

/**
 * 还书接口类
 * @author Carey
 */
@Mapper
public interface RebackMapper {

    /**
     * 更新借书信息
     * @param bookBorrowDTO
     * @return
     */
    int updateBorrowInfo(BookBorrowDTO bookBorrowDTO);

}
