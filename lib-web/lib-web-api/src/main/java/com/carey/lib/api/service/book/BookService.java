package com.carey.lib.api.service.book;

import com.carey.lib.api.constants.ResultDTO;
import com.carey.lib.api.model.book.BookDTO;

/**
 * 书籍service
 * @author Carey
 */
public interface BookService {
    /**
     * 根据名称模糊查询全部书籍信息
     * @param name 分类名称
     * @return 匹配的数据集
     */
    ResultDTO findListByName(String name);

    /**
     * 根据ID查找数据
     * @param id 数据id
     * @return 查找的数据集
     */
    ResultDTO findById(int id);

    /**
     * 新增
     * @param entity 实体类（不含ID）
     * @return 影响行数
     */
    ResultDTO insert(BookDTO entity);

    /**
     * 更新
     * @param entity 实体类（包含ID）
     * @return 影响行数
     */
    ResultDTO update(BookDTO entity);

    /**
     * 删除
     * @param id 数据主键
     * @return 影响行数
     */
    ResultDTO delete(int id);
}
