package com.message.wechat.config;

import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.context.annotation.Configuration;

import lombok.Data;

@Data
@Configuration
@ConfigurationProperties(prefix = "wechat")
public class WeChatProperties {
    /**
     * 企业微信 base-URL
     */
    private String baseUrl = "https://qyapi.weixin.qq.com/";
    /**
     * 企业 ID
     */
    private String corpId;
    /**
     * 应用密钥
     */
    private String corpSecret;
    /**
     * 应用 Id
     */
    private int agentId;
}
