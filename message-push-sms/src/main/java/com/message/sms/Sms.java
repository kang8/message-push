package com.message.sms;

import com.aliyun.dysmsapi20170525.Client;
import com.aliyun.teaopenapi.models.Config;
import com.message.sms.config.SmsProperties;
import com.message.sms.except.AliyunException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

/**
 * @author kang
 * @date 2021/8/10 15:55
 */
@Component
public class Sms {
    private static SmsProperties smsProperties;

    @Autowired
    private Sms(SmsProperties smsProperties) {
        Sms.smsProperties = smsProperties;
    }

    public static Client createClient() {
        Config config = new Config()
                .setAccessKeyId(smsProperties.getAccessKeyId())
                .setAccessKeySecret(smsProperties.getAccessKeySecret());
        config.endpoint = smsProperties.getEndpoint();

        try {
            return new Client(config);
        } catch (Exception e) {
            throw new AliyunException("创建 SMS Client 失败");
        }
    }
}
