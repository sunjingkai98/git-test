package com.intouch.service;

import com.intouch.dao.CategoryMapper;
import com.intouch.dao.ProductMapper;
import com.intouch.domain.Product;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
@Transactional
public class ProductServiceImpl implements ProductService{
    @Autowired
    private ProductMapper productMapper;

    @Autowired
    private CategoryMapper categoryMapper;

    @Override
    @Transactional(propagation = Propagation.SUPPORTS,readOnly = true)
    public List<Product> selectAllProductsByParentId(Integer id, Integer page, Integer pageSize) {
        int beginIndex = (page - 1)*pageSize;
        return productMapper.selectAllProductsByParentId(id,beginIndex,pageSize);
    }

    @Override
    @Transactional(propagation = Propagation.SUPPORTS,readOnly = true)
    public int totalPages(Integer catId,Integer pageSize) {
        int amount = categoryMapper.getCatCountsById(catId);
        int totalPage = amount/pageSize;
        if(amount%pageSize != 0){
            totalPage++;
        }
        return totalPage;
    }

    @Override
    @Transactional(propagation = Propagation.SUPPORTS,readOnly = true)
    public List<Product> selectAllProductsByRelatedId(Integer relatedId, Integer page, Integer pageSize) {
        int beginIndex = (page - 1)*pageSize;
        return productMapper.selectAllProductsByRelatedId(relatedId,beginIndex,pageSize);
    }

    @Override
    @Transactional(propagation = Propagation.SUPPORTS,readOnly = true)
    public int totalRelatedPages(Integer catId, Integer pageSize) {
        int amount = productMapper.getRelatedCatCountsById(catId);
        int totalPage = amount/pageSize;
        if(amount%pageSize != 0){
            totalPage++;
        }
        return totalPage;
    }

    @Override
    @Transactional(propagation = Propagation.SUPPORTS,readOnly = true)
    public List<Product> selectProductsByPublishing(String publishing) {
        return productMapper.selectProductsByPublishing(publishing);
    }

    @Override
    @Transactional(propagation = Propagation.SUPPORTS,readOnly = true)
    public List<Product> selectTopSalesBooks(Integer amount) {
        return productMapper.selectTopSalesBooks(amount);
    }

    @Override
    @Transactional(propagation = Propagation.SUPPORTS,readOnly = true)
    public List<Product> sellectNewestBooks(Integer amount) {
        return productMapper.sellectNewestBooks(amount);
    }

    @Override
    @Transactional(propagation = Propagation.SUPPORTS,readOnly = true)
    public List<Product> selectBooksAccordingToUser(Integer userId) {
        return productMapper.selectBooksAccordingToUser(userId);
    }
}
