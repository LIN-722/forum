package com.lin.service;

import com.lin.dao.UserMapper;
import com.lin.entity.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * @Author: wanglin
 * @DateTime: 2023/12/5
 **/
@Service
public class UserService {
    @Autowired
    UserMapper userMapper;

    public User findUserById(int id) {
        return userMapper.selectById(id);
    }
}
