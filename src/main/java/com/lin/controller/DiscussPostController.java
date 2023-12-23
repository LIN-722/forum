package com.lin.controller;

import com.lin.entity.DiscussPost;
import com.lin.entity.User;
import com.lin.service.DiscussPostService;
import com.lin.service.UserService;
import com.lin.uitl.CommunityUtil;
import com.lin.uitl.HostHolder;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.Date;

@Controller
@RequestMapping("/discuss")
public class DiscussPostController {
    @Autowired
    private DiscussPostService discussPostService;
    @Autowired
    private HostHolder hostHolder;


    /**
     * 新增文章的业务
     */
    @PostMapping("/add")
    @ResponseBody
    public String addDiscussPost(@RequestParam String title, @RequestParam String content) {
        User user = hostHolder.getUser();
        if (user == null) {
            return CommunityUtil.getJSONString(403, "你还没有登陆哦！");
        }
        DiscussPost post = new DiscussPost();
        post.setUserId(user.getId());
        post.setTitle(title);
        post.setContent(content);
        post.setCreateTime(new Date());
        discussPostService.addDisscussPost(post);
        // 报错的情况，将来统一处理
        return CommunityUtil.getJSONString(0, "发布成功！");
    }
}
