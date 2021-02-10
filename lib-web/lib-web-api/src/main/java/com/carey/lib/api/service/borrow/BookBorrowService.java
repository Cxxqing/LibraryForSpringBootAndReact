package com.carey.lib.api.service.borrow;

import com.carey.lib.api.constants.ResultDTO;

import java.util.Date;

/**
 * 借书Service
 * @author Carey
 */
public interface BookBorrowService {
    ResultDTO doBookBorrow(int bookId, Date startDate, Date endDate, int borrowCount, int userId, String userName, boolean vipFlag);
}
