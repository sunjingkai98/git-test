package com.intouch.dao;

import com.intouch.domain.Category;
import org.springframework.stereotype.Repository;

import java.util.List;
@Repository
public interface CategoryMapper {
    int insert(Category record);
    int insertSelective(Category record);

    int deleteByPrimaryKey(Integer id);

    int updateByPrimaryKeySelective(Category record);
    int updateByPrimaryKey(Category record);


    /*查询当前目录但不包含子目录*/
    Category selectByPrimaryKey(Integer id);
    /*查询指定目录及其子目录*/
    Category selectCategoryAndRelatedByPrimaryKey(Integer id);
    Category selectCategoryAndRelatedByPrimaryKey1(Integer id);
    Category selectCategoryAndRelatedByPrimaryKey2(Integer id);
    /*只查询子目录*/
    List<Category> selectSubCatsByForeignKey(Integer parentId);

    /*根据父目录，查询所有的同级目录及其子目录*/
    List<Category> selectAllCatsAndRelated(Integer parentId);
    List<Category> selectAllCatsAndRelated1();

    /*获取三级目录获取所属图书数量*/
    int getCountByCategory(Integer id);

    /*查询所有二级目录的总图书数量*/
    int getCatCountsById(Integer Id);

}