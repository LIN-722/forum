package com.lin.entity;

import lombok.Data;

/**
 * 封装分页信息
 * @Author: wanglin
 * @DateTime: 2023/12/5
 **/
@Data
public class Page {
    // 当前页码
    private int current = 1;

    // 显示上限
    private int limit = 10;

    // 数据总数（用于计算整数）
    private int rows;

    // 查询路径（用于复用分页链接）
    private String path;


    /**
     * 获取当前页的起始行
     */
    public int getOffset() {
        // current * limit - limit
        return (current - 1) * limit;
    }

    /**
     * 获取总页数
     */
    public int getTotal() {
        // rows / limit [+1]
        if ((rows % limit) == 0) {
            return rows / limit;
        } else {
            return rows / limit + 1;
        }
    }

    /**
     * 获取起始页码
     */
    public int getFrom() {
        int from = current - 2;
        return Math.max(from, 1);
    }

    /**
     * 获取终止页码
     */
    public int getTo() {
        int to = current + 2;
        int total = getTotal();
        return Math.min(to, total);
    }
}
