package com.carey.lib.api.service.reback;

import com.carey.lib.api.constants.ResultDTO;
import com.carey.lib.api.model.borrow.BookBorrowDTO;

/**
 * @author Carey
 */
public interface RebackService {

    /**
     * 更新借书信息
     * @param bookBorrowDTO
     */
    ResultDTO updateBorrowInfo(BookBorrowDTO bookBorrowDTO);
}
