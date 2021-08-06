package com.message.wechat;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertFalse;

import java.io.IOException;

import com.message.IntegrationWeChatText;
import com.message.wechat.config.WeChatProperties;
import com.message.wechat.entity.MessageResponse;
import com.message.wechat.entity.TextMessage;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;

import retrofit2.Call;
import retrofit2.Response;

public class WeChatTest extends IntegrationWeChatText {

    @Autowired
    private WeChatProperties wechatProperties;

    @Test
    void testGetAccessToken() throws IOException {
        String accessToken = WeChat.getAccessToken(wechatProperties.getCorpId(),
                wechatProperties.getCorpSecret());

        assertFalse(accessToken.isEmpty());
    }

    @Test
    void testSendTextMessage() throws IOException {
        TextMessage message = TextMessage.builder()
                .touser("@all")
                .msgtype("text")
                .agentid(wechatProperties.getAgentId())
                .text(TextMessage.Text.builder()
                        .content(String.valueOf(((int) (Math.random() * 100))))
                        .build())
                .build();

        Call<MessageResponse> messageRes = WeChat.sendTextMessage(message);
        Response<MessageResponse> execute = messageRes.execute();

        assertEquals(200, execute.code());
        assertFalse(execute.body().toString().isEmpty());
    }
}
