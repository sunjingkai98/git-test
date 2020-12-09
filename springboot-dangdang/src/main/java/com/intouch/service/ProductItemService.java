package com.intouch.service;

import com.intouch.domain.ProductItem;

import java.util.List;

public interface ProductItemService {
    //需求①:通过用户id和书的id向购物车中增加一本图书信息
    int insertOneBookToItemByBookId(Integer userId, Integer bookId);

    //需求②:通过用户id和书的id查询书的总数量
    int selectBookAmountByBookId(Integer userId, Integer bookId);

    //需求③:通过用户Id和书的id删除某图书信息
    Integer deleteBookByBookId(Integer userId, Integer bookId);

    //需求④:通过用户Id和书的id集合批量删除图书信息
    int deleteBooksByBookIdList(Integer userId, String ids);

    //需求⑤:通过用户id和书的id查询图书信息
    ProductItem selectBookByBookId(Integer userId, Integer bookId);

    //需求⑥:通过id和商品id修改指定商品数量
    int updateBookInfoByBookId(Integer userId, Integer bookId, Integer amount);
}
