package com.message.wechat.service;

import com.message.wechat.entity.BaseMessage;
import com.message.wechat.entity.MessageResponse;
import com.message.wechat.entity.TokenResponse;

import retrofit2.Call;
import retrofit2.http.Body;
import retrofit2.http.GET;
import retrofit2.http.POST;
import retrofit2.http.Query;

public interface WeChatService {
        @GET("/cgi-bin/gettoken")
        Call<TokenResponse> getAccessToken(@Query("corpid") String cropId,
                        @Query("corpsecret") String cropSecret);

        @POST("/cgi-bin/message/send")
        Call<MessageResponse> sendMessage(@Query("access_token") String accessToken,
                        @Body BaseMessage message);
}
