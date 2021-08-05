package com.message.wechat.config;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

@SpringBootTest
public class WeChatPropertiesTest {
    @Autowired
    private WeChatProperties wechat;

    @Test
    public void testProperties() {
        System.out.println(wechat.getAgentId());
    }
}
