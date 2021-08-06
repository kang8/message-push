package com.message.wechat;

import java.io.IOException;
import java.util.Objects;
import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import com.google.gson.JsonSerializer;
import com.message.wechat.config.WeChatProperties;
import com.message.wechat.entity.BaseMessage;
import com.message.wechat.entity.MessageResponse;
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

    private static WeChatService weChatService;

    @Autowired
    private WeChat(WeChatProperties weChatProperties) {
        WeChat.weChatProperties = weChatProperties;
    }

    public static Call<MessageResponse> sendTextMessage(TextMessage message) throws IOException {
        WeChatService weChatService = setUpWeChatService();

        String accessToken =
                getAccessToken(weChatProperties.getCorpId(), weChatProperties.getCorpSecret());
        return weChatService.sendMessage(accessToken, message);
    }

    public static String getAccessToken(String cropId, String cropSecret) throws IOException {
        WeChatService weChatService = setUpWeChatService();

        Call<TokenResponse> tokenRes = weChatService.getAccessToken(weChatProperties.getCorpId(),
                weChatProperties.getCorpSecret());
        return Objects.requireNonNull(tokenRes.execute().body()).getAccess_token();
    }

    public static WeChatService setUpWeChatService() {
        if (weChatService == null) {
            // 对 BaseMapper 进行规定序列化的方式
            // 因为在 retrofit 中传入父类，传入一个子类，并不会解析子类中的元素
            // 下述的代码就是自定义父类的序列化方式，使其可以解析子类的元素
            Gson customizeAdapter = new GsonBuilder().registerTypeAdapter(BaseMessage.class,
                    (JsonSerializer<BaseMessage>) (src, typeOfSrc, context) -> context
                            .serialize(src, src.getClass()))
                    .create();

            Retrofit retrofit = new Retrofit.Builder()
                    .baseUrl(weChatProperties.getBaseUrl())
                    .addConverterFactory(
                            GsonConverterFactory.create(customizeAdapter))
                    .build();

            weChatService = retrofit.create(WeChatService.class);
        }
        return weChatService;

    }
}
