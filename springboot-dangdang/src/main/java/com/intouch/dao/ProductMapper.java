package com.intouch.dao;

import com.intouch.domain.Product;
import org.apache.ibatis.annotations.Param;
import org.springframework.stereotype.Repository;

import java.util.List;
@Repository
public interface ProductMapper {
    int insert(Product record);
    int insertSelective(Product record);

    int deleteByPrimaryKey(Integer id);

    int updateByPrimaryKeySelective(Product record);
    int updateByPrimaryKey(Product record);

    Product selectByPrimaryKey(Integer id);

    /*根据二级目录编号分页查询所有图书详情*/
    List<Product> selectAllProductsByParentId(@Param("parentId") Integer parentId, @Param("beginIndex") Integer beginIndex,
                                              @Param("pageSize") Integer pageSize);

    /*根据三级目录编号分页查询所有图书详情*/
    List<Product> selectAllProductsByRelatedId(@Param("relatedId") Integer relatedId,@Param("beginIndex") Integer beginIndex,
                                               @Param("pageSize") Integer pageSize);
    /*根据三级目录编号 求出所有图书数量*/
    int getRelatedCatCountsById(Integer relatedId);

    /*根据出版社查询图书*/
    List<Product> selectProductsByPublishing(String publishing);

    /*根据销量选出前6本图书*/
    List<Product> selectTopSalesBooks(Integer amount);

    /*根据最新出版时间选出前8本图书*/
    List<Product> sellectNewestBooks(Integer amount);

    /*根据用户id查询所属的图书*/
    List<Product> selectBooksAccordingToUser(Integer userId);
}