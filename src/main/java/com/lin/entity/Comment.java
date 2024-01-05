package com.lin.entity;

import lombok.Data;

import java.util.Date;

@Data
public class Comment {
    private int id;
    private Integer userId;

    private Integer entityType;

    private Integer entityId;
    private Integer targetId;

    private String content;
    private Integer status;
    private Date createTime;
}
