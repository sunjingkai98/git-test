package com.intouch.dao;

import com.intouch.domain.ProductItem;
import org.apache.ibatis.annotations.Param;
import org.springframework.stereotype.Repository;

import java.util.List;
@Repository
public interface ProductItemMapper {

    int insert(ProductItem record);
    int insertSelective(ProductItem record);

    int deleteByPrimaryKey(Integer id);

    int updateByPrimaryKeySelective(ProductItem record);
    int updateByPrimaryKey(ProductItem record);

    ProductItem selectByPrimaryKey(Integer id);

    /*根据bookID向购物车中增加一条记录*/
    int insertToItemByBookId(@Param("uId") Integer userId, @Param("bId") Integer bookId);

    /*根据bookId查询图书信息*/
    ProductItem selectBookByBookId(@Param("uId") Integer userId,@Param("bId") Integer bookId);

    /*根据bookid和用户id修改指定图书信息数量*/
    int updateBookInfoByBookId(@Param("uId") Integer userId,@Param("bId") Integer bookId,@Param("amount") Integer amount);

    /*根据用户ID和bookId 查询书的数量*/
    int selectBookAmountByBookId(@Param("uId") Integer userId,@Param("bId") Integer bookId);

    /*根据指定用户Id和 bookID删除图书信息*/
    Integer deleteBookByBookId(@Param("uId") Integer userId,@Param("bId") Integer bookId);

    /*根据指定用户Id和book集合 批量删除图书信息*/
    int deleteBooksByBookIdList(@Param("uId") Integer userId, @Param("list") List<Integer> list);
}