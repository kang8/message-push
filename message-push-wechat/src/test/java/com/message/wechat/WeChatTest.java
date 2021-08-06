package com.message.wechat;

import static org.junit.jupiter.api.Assertions.assertFalse;

import java.io.IOException;

import com.message.IntegrationWeChatText;
import com.message.wechat.config.WeChatProperties;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;

public class WeChatTest extends IntegrationWeChatText {

    @Autowired
    private WeChatProperties wechatProperties;

    @Test
    void testGetAccessToken() throws IOException {
        String accessToken = WeChat.getAccessToken(wechatProperties.getCorpId(), wechatProperties.getCorpSecret());

        assertFalse(accessToken.isEmpty());
    }

    @Test
    void testSendTextMessage() {

    }
}
