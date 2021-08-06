package com.message.wechat;

import static org.junit.jupiter.api.Assertions.assertEquals;
import com.message.IntegrationWeChatText;

import org.junit.jupiter.api.Test;
public class WeChatTest extends IntegrationWeChatText {

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
