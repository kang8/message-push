package com.message.wechat;

import java.io.IOException;
import java.util.Objects;

import com.message.wechat.config.WeChatProperties;
import com.message.wechat.entity.TextMessage;
import com.message.wechat.entity.TokenResponse;
import com.message.wechat.service.WeChatService;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import retrofit2.Call;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

/**
 * @author kang
 */
@Component
public class WeChat {

    private static WeChatProperties weChatProperties;

    @Autowired
    private WeChat(WeChatProperties weChatProperties) {
        WeChat.weChatProperties = weChatProperties;
    }

    public static void sendTextMessage(String accessToken, TextMessage message) {

    }

    public static String getAccessToken(String cropId, String cropSecret) throws IOException {
        WeChatService weChatService = setUpWeChatService();

        Call<TokenResponse> tokenRes = weChatService.getAccessToken(weChatProperties.getCorpId(),
                weChatProperties.getCorpSecret());
        return Objects.requireNonNull(tokenRes.execute().body()).getAccess_token();
    }

    public static WeChatService setUpWeChatService() {

        Retrofit retrofit = new Retrofit.Builder().baseUrl(weChatProperties.getBaseUrl())
                .addConverterFactory(GsonConverterFactory.create()).build();

        return retrofit.create(WeChatService.class);

    }
}
