package com.message.mail.smtp.config;

import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.context.annotation.Configuration;

import lombok.Data;

@Data
@Configuration
@ConfigurationProperties(prefix = "mail.smtp")
public class MailProperties {
    /**
     * 邮件服务器
     */
    private String host;
    /**
     * 邮件端口
     */
    private int port;
    /**
     * 用于登录到邮件服务器的用户名
     */
    private String username;
    /**
     * 用户登录到邮件服务器的密码，有些地方叫 token
     */
    private String password;
    /**
     * 发送人
     */
    private String from;
    /**
     * 是否调试，默认为不调试
     */
    private boolean debug = false;
}
