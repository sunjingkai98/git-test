package com.intouch.dao;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import static org.junit.jupiter.api.Assertions.*;
@SpringBootTest
class CategoryMapperTest {
    @Autowired
    private CategoryMapper mapper;

    @Test
    void selectByPrimaryKey() {
        mapper.selectByPrimaryKey(1);
    }

    @Test
    void selectCategoryAndRelatedByPrimaryKey() {
        mapper.selectCategoryAndRelatedByPrimaryKey(2);
    }

    @Test
    void selectCategoryAndRelatedByPrimaryKey1() {
    }

    @Test
    void selectCategoryAndRelatedByPrimaryKey2() {
    }

    @Test
    void selectSubCatsByForeignKey() {
    }

    @Test
    void selectAllCatsAndRelated() {
    }

    @Test
    void selectAllCatsAndRelated1() {
    }

    @Test
    void getCountByCategory() {
    }

    @Test
    void getCatCountsById() {
    }
}