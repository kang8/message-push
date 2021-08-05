package com.message.wechat;

import com.message.wechat.entity.BaseMessage;
import com.message.wechat.entity.MessageResponse;
import com.message.wechat.entity.TextMessage;
import com.message.wechat.entity.TokenResponse;
import com.message.wechat.service.WeChatService;

import retrofit2.Call;

/**
 * @author kang
 */
public class WeChat {

    public void sendTextMessage(String accessToken, TextMessage message) {

    }

    public String getAccessToken(String cropId, String cropSrcret) {
        // TODO:
        return new String("");
    }

    public WeChatService setUpWeChatService() {
        return new WeChatService() {
            @Override
            public Call<TokenResponse> getAccessToken(String cropId, String cropSecret) {
                // TODO Auto-generated method stub
                return null;
            }

            @Override
            public Call<MessageResponse> sendMessage(String accessToken, BaseMessage message) {
                // TODO Auto-generated method stub
                return null;
            }
        };
    }
}
