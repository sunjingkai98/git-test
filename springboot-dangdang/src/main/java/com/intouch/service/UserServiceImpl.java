package com.intouch.service;


import com.intouch.dao.UserMapper;
import com.intouch.domain.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

@Service
@Transactional
public class UserServiceImpl implements UserService{

    @Autowired
    private UserMapper mapper;


    @Override
    @Transactional(propagation = Propagation.SUPPORTS,readOnly = true)
    public User selectInfoByEmail(String email) {
        return mapper.selectInfoByEmail(email);

    }

    @Override
    @Transactional(propagation = Propagation.REQUIRED)
    public int updataInfoByUser(User user) {
        return mapper.updateByPrimaryKeySelective(user);
    }
}
