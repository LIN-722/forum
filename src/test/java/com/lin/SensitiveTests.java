package com.lin;

import com.lin.uitl.SensitiveFilter;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.ContextConfiguration;

@SpringBootTest
public class SensitiveTests {

    @Autowired
    private SensitiveFilter sensitiveFilter;

    @Test
    void testFilter() {
        String text = "这里可以赌博，可以嫖✓娼，可以吸毒，也可以开×票，哈哈哈！";
        String filter = sensitiveFilter.filter(text);
        System.out.println(filter);
    }
}