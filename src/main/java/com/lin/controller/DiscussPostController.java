package com.lin.controller;

import com.lin.entity.DiscussPost;
import com.lin.entity.Page;
import com.lin.entity.User;
import com.lin.service.DiscussPostService;
import com.lin.service.UserService;
import com.lin.uitl.CommunityUtil;
import com.lin.uitl.HostHolder;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

import java.util.*;

@Controller
@RequestMapping("/discuss")
public class DiscussPostController {
    @Autowired
    private DiscussPostService discussPostService;
    @Autowired
    private HostHolder hostHolder;
    @Autowired
    private UserService userService;


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

    /**
     * 查询帖子详情及其全部评论
     */
    @GetMapping("/detail/{discussPostId}")
    public String getDiscussPost(@PathVariable("discussPostId") int discussPostId, Model model) {
        // 查询帖子
        DiscussPost post = discussPostService.findDiscussPostById(discussPostId);
        model.addAttribute("post", post);
        // 查询作者
        User user = userService.findUserById(post.getUserId());
        model.addAttribute("user", user);

        return "site/discuss-detail";
    }
}
