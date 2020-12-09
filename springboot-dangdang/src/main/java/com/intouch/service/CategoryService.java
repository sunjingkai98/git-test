package com.intouch.service;


import com.intouch.domain.Category;

import java.util.List;

public interface CategoryService {
    //需求①：已知目录的编号，构建已知目录及其子目录
    Category selectCateAndRelatedByPrimaryKey(Integer id);
    //需求②：已知的父目录编号，构建已知目录及其子目录
    List<Category> selectAllCatesAndRelated(Integer parentId);
    //需求③：已知三级目录编号，构建所属图书的数量
    int getBookCountsByCategory(Integer id);
    //需求④：根据二级目录编号，构建及所有图书数量
    int getCatCountsById(Integer id);
}
