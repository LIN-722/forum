package com.lin.entity;

import lombok.Data;
import lombok.NonNull;

import java.util.Date;

/**
 * 登录
 */
@Data
public class LoginTicket {

    private int id;
    private int userId;
    private String ticket;
    private int status;
    private Date expired;
}
