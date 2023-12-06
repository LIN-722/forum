package com.lin.dao;


import com.lin.entity.User;
import org.apache.ibatis.annotations.Mapper;

/**
 * @Author: wanglin
 * @DateTime: 2023/12/5
 **/
@Mapper
public interface UserMapper {

    User selectById(int id);

    User selectByName(String username);

    User selectByEmail(String email);

    int insertUser(User user);

    int updateStatus(int id, int status);

    int updateHeader(int id, String headerUrl);

    int updatePassword(int id, String password);

}
