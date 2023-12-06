package com.lin;

import com.lin.uitl.MailClient;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.ContextConfiguration;
import org.thymeleaf.TemplateEngine;
import org.thymeleaf.context.Context;

/**
 * @Author: wanglin
 * @DateTime: 2023/12/6
 **/
@SpringBootTest
@ContextConfiguration(classes = ForumApplication.class)
public class MailTest {
    @Autowired
    private MailClient mailClient;

    @Autowired
    private TemplateEngine templateEngine;

    @Test
    void testTextMail() {
        mailClient.sendMail("3022964117@qq.com", "TEST", "Welcome.");
    }

    @Test
    void testHtmlMail() {
        Context context = new Context();
        context.setVariable("username", "DJWILL");

        String content = templateEngine.process("/mail/demo", context);
        System.out.println(content);

        mailClient.sendMail("3022964117@qq.com", "HTML", content);
    }
}


