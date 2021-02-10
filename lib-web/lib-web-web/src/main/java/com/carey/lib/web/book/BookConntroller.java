package com.carey.lib.web.book;

import com.carey.lib.api.constants.ResultDTO;
import com.carey.lib.api.eums.HttpCode;
import com.carey.lib.api.model.book.BookDTO;
import com.carey.lib.api.service.book.BookService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * 书籍访问层
 */
@RestController
@RequestMapping("/book")
public class BookConntroller {

    private Logger logger = LoggerFactory.getLogger(this.getClass());

    @Autowired
    private BookService bookService;

    /**
     * 根据名称查找分类信息
     * @param name 分类名
     */
    @RequestMapping("/findListByName")
    public ResultDTO findListByName(String name){
        try {
            return bookService.findListByName(name);
        }catch (Exception e){
            logger.error("系统异常："+e);
            return new ResultDTO(HttpCode.EXCEPTION.getCode(), "系统异常");
        }
    }

    /**
     * 根据id查找数据
     * @param id    数据主键
     */
    @RequestMapping("/findById")
    public ResultDTO findById(int id){
        try {
            return bookService.findById(id);
        }catch (Exception e){
            logger.error("系统异常："+e);
            return new ResultDTO(HttpCode.EXCEPTION.getCode(), "系统异常");
        }
    }

    /**
     * 新增
     * @param bookDTO 新增实体
     */
    @RequestMapping("/insert")
    public ResultDTO insert(BookDTO bookDTO){
        try {
            return bookService.insert(bookDTO);
        }catch (Exception e){
            logger.error("系统异常："+e);
            return new ResultDTO(HttpCode.EXCEPTION.getCode(), "系统异常");
        }
    }

    /**
     * 更新
     * @param bookDTO 更新实体
     * @return
     */
    @RequestMapping("/update")
    public ResultDTO update(BookDTO bookDTO){
        try {
            return bookService.update(bookDTO);
        }catch (Exception e){
            logger.error("系统异常："+e);
            return new ResultDTO(HttpCode.EXCEPTION.getCode(), "系统异常");
        }
    }

    /**
     * 根据id删除数据
     * @param id 数据主键
     * @return
     */
    @RequestMapping("/delete")
    public ResultDTO delete(int id){
        try {
            return bookService.delete(id);
        }catch (Exception e){
            logger.error("系统异常："+e);
            return new ResultDTO(HttpCode.EXCEPTION.getCode(), "系统异常");
        }
    }
}
