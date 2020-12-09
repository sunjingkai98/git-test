package com.intouch.service;


import com.intouch.domain.User;

public interface UserService {
    //需求①:根据email查询用户信息
    User selectInfoByEmail(String email);

    //需求②:修改用户信息
    int updataInfoByUser(User user);
}
