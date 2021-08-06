package com.message.wechat;

import static org.junit.jupiter.api.Assertions.assertEquals;

import org.junit.jupiter.api.Test;

public class WeChatTest {
    @Test
    void testGetAccessToken() {
        WeChat wechat = new WeChat();
        String accessToken = wechat.getAccessToken("cropId", "cropSecret");

        assertEquals("", accessToken);
    }

    @Test
    void testSendTextMessage() {

    }
}
