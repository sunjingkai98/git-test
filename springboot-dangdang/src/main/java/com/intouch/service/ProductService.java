package com.intouch.service;

import com.intouch.domain.Product;

import java.util.List;

public interface ProductService {
    //需求①：已知二级目录编号，分页显示所有图书信息
    List<Product> selectAllProductsByParentId(Integer id, Integer page, Integer pageSize);

    //需求②：已知二级目录编号，计算总页数=三级目录所有图书总和 除每页显示
    int totalPages(Integer catId, Integer pageSize);

    //需求③：已知三级目录编号，分页显示所有图书信息
    List<Product> selectAllProductsByRelatedId(Integer relatedId, Integer page, Integer pageSize);

    //需求④：已知三级目录编号，计算总页数=所有图书总和 除每页显示
    int totalRelatedPages(Integer catId, Integer pageSize);

    //需求⑤:已知出版社，查询图书只查两本
    List<Product> selectProductsByPublishing(String publishing);

    //需求⑥:构建销量前6的图书信息
    List<Product> selectTopSalesBooks(Integer amount);

    //需求⑦:构建前8本最新出版的图书信息
    List<Product> sellectNewestBooks(Integer amount);

    //需求⑧:根据用户构建出所属的购物车图书信息
    List<Product> selectBooksAccordingToUser(Integer userId);
}
