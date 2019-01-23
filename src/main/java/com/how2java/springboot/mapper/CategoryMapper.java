package com.how2java.springboot.mapper;

import com.how2java.springboot.pojo.Category;
import org.apache.ibatis.annotations.*;

import java.util.List;

/**
 * Created by LXX on 2019/1/23.
 */
@Mapper
public interface CategoryMapper {
    @Select("select * from category_")
    List<Category> findAll();

    @Insert("insert into category_ (name) values (#{name})")
    int save(Category category);

    @Delete("delete from category_ where id=#{id}")
    void delete(int id);

    @Select("select * from category_ where id = #{id}")
    Category get(int id);

    @Update("update category_ set name = #{name} where id = #{id}")
    int update(Category category);
}
