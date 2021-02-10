package com.carey.lib.dao.mapper.book;

import com.carey.lib.api.model.book.BookDTO;
import org.apache.ibatis.annotations.Mapper;

import java.util.List;

/**
 * 书籍实体信息接口
 */
@Mapper
public interface BookMapper {
    /**
     * 根据名称模糊查询全部书籍信息
     * @param name 分类名称
     * @return 匹配的数据集
     */
    List<BookDTO> findListByName(String name);

    /**
     * 根据ID查找数据
     * @param id 数据id
     * @return 查找的数据集
     */
    BookDTO findById(int id);

    /**
     * 新增
     * @param entity 实体类（不含ID）
     * @return 影响行数
     */
    int insert(BookDTO entity);

    /**
     * 更新
     * @param entity 实体类（包含ID）
     * @return 影响行数
     */
    int update(BookDTO entity);

    /**
     * 删除
     * @param id 数据主键
     * @return 影响行数
     */
    int delete(int id);
}
