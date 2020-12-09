package com.intouch.service;

import com.intouch.dao.ProductItemMapper;
import com.intouch.domain.ProductItem;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

@Service
@Transactional
public class ProductItemServiceImpl implements ProductItemService{
    @Autowired
    private ProductItemMapper mapper;

    @Override
    @Transactional(propagation = Propagation.REQUIRED)
    public int insertOneBookToItemByBookId(Integer userId, Integer bookId) {
        return mapper.insertToItemByBookId(userId,bookId);
    }

    @Override
    @Transactional(propagation = Propagation.SUPPORTS,readOnly = true)
    public int selectBookAmountByBookId(Integer userId, Integer bookId) {
        return mapper.selectBookAmountByBookId(userId,bookId);
    }

    @Override
    @Transactional(propagation = Propagation.REQUIRED)
    public Integer deleteBookByBookId(Integer userId, Integer bookId) {
        return mapper.deleteBookByBookId(userId,bookId);
    }

    @Override
    @Transactional(propagation = Propagation.REQUIRED)
    public int deleteBooksByBookIdList(Integer userId,String ids) {
        String[] str = ids.split(",");
        int[] arr = Arrays.stream(str).mapToInt(Integer::parseInt).toArray();
        List<Integer> list = Arrays.stream(arr).boxed().collect(Collectors.toList());
        return mapper.deleteBooksByBookIdList(userId,list);
    }

    @Override
    @Transactional(propagation = Propagation.SUPPORTS,readOnly = true)
    public ProductItem selectBookByBookId(Integer userId, Integer bookId) {
        return mapper.selectBookByBookId(userId,bookId);
    }

    @Override
    @Transactional(propagation = Propagation.REQUIRED)
    public int updateBookInfoByBookId(Integer userId, Integer bookId, Integer amount) {
        return mapper.updateBookInfoByBookId(userId,bookId,amount);
    }
}
