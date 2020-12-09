package com.intouch.dao;

import com.intouch.domain.Book;
import com.intouch.domain.BookWithBLOBs;
import org.springframework.stereotype.Repository;

@Repository
public interface BookMapper {
    int deleteByPrimaryKey(Integer id);

    int insert(BookWithBLOBs record);

    int insertSelective(BookWithBLOBs record);

    BookWithBLOBs selectByPrimaryKey(Integer id);

    int updateByPrimaryKeySelective(BookWithBLOBs record);

    int updateByPrimaryKeyWithBLOBs(BookWithBLOBs record);

    int updateByPrimaryKey(Book record);
}