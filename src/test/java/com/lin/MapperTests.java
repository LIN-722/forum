package com.lin;

import com.lin.dao.DiscussPostMapper;
import com.lin.entity.DiscussPost;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.ContextConfiguration;

import java.util.List;

/**
 * @description TODO
 * @Author: wanglin
 * @DateTime: 2023/12/5
 **/
@SpringBootTest
@ContextConfiguration(classes = ForumApplication.class)
public class MapperTests {
    @Autowired
    private DiscussPostMapper discussPostMapper;

    @Test
    void testSelectPosts() {
        List<DiscussPost> list = discussPostMapper.selectDiscussPosts(149, 0, 10);
        list.forEach(System.out::println);
        int rows = discussPostMapper.selectDiscussPostRows(149);
        System.out.println("rows = " + rows);
    }
}
