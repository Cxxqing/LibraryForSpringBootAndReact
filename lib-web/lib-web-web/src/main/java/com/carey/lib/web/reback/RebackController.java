package com.carey.lib.web.reback;

import com.carey.lib.api.constants.ResultDTO;
import com.carey.lib.api.eums.HttpCode;
import com.carey.lib.api.model.borrow.BookBorrowDTO;
import com.carey.lib.api.service.reback.RebackService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * @author Carey
 */
@RestController
@RequestMapping("/reback")
public class RebackController {

    private Logger logger = LoggerFactory.getLogger(this.getClass());

    @Autowired
    private RebackService rebackService;

    @RequestMapping("/doBack")
    public ResultDTO rebackBook(@RequestBody BookBorrowDTO bookBorrowDTO){
        try {
            return rebackService.updateBorrowInfo(bookBorrowDTO);
        }catch (Exception e){
            logger.error("系统异常："+e);
            return new ResultDTO(HttpCode.EXCEPTION.getCode(), "系统异常");
        }
    }
}
