package com.message.sms.config;

import lombok.Data;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.context.annotation.Configuration;

/**
 * @author kang
 * @date 2021/8/10 15:39
 */
@Data
@Configuration
@ConfigurationProperties(prefix = "sms")
public class SmsProperties {
    /**
     * 访问值
     */
    private String accessKeyId;
    /**
     * 访问密钥
     */
    private String accessKeySecret;
    /**
     * 访问的域名
     */
    private String endpoint = "dysmsapi.aliyuncs.com";
    /**
     * 签名名称
     */
    private String signName;
    /**
     * 模板 Code
     */
    private String templateCode;
    /**
     * 手机号 1
     */
    private String phone1;
    /**
     * 手机号 2
     */
    private String phone2;
}
