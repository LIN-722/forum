package com.lin.entity;

import lombok.Data;

import java.util.Date;

/**
 * @description 帖子表
 * @Author: wanglin
 * @DateTime: 2023/12/5
 **/
@Data
public class DiscussPost {

    private int id;

    private int userId;

    private String title;

    private String content;

    private int type;

    private int status;

    private Date createTime;
    private int commentCount;

    private double score;
}

