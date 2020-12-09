package com.intouch.service;

import com.intouch.dao.CategoryMapper;
import com.intouch.domain.Category;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
@Transactional
public class CategoryServiceImpl implements CategoryService{
    @Autowired
    private CategoryMapper mapper;

    @Override
    @Transactional(propagation = Propagation.SUPPORTS,readOnly = true)
    public Category selectCateAndRelatedByPrimaryKey(Integer id) {
        return mapper.selectCategoryAndRelatedByPrimaryKey(id);
    }

    @Override
    @Transactional(propagation = Propagation.SUPPORTS,readOnly = true)
    public List<Category> selectAllCatesAndRelated(Integer parentId) {
        List<Category> list = mapper.selectAllCatsAndRelated(parentId);
        return list;
    }

    @Override
    @Transactional(propagation = Propagation.SUPPORTS,readOnly = true)
    public int getBookCountsByCategory(Integer id) {
        return  mapper.getCountByCategory(id);
    }

    @Override
    @Transactional(propagation = Propagation.SUPPORTS,readOnly = true)
    public int getCatCountsById(Integer id) {
        return mapper.getCatCountsById(id);
    }
}
