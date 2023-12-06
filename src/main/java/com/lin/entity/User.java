package com.lin.entity;

import lombok.Data;

import java.util.Date;

/**
 * @description 用户表
 * @Author: wanglin
 * @DateTime: 2023/12/5
 **/
@Data
public class User {
    private int id;
    private String username;
    private String password;
    private String salt;
    private String email;
    private int type;
    private int status;
    private String activationCode;
    private String headerUrl;
    private Date createTime;

}

