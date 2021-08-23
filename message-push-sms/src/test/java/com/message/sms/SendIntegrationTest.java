package com.message.sms;

import com.aliyun.dysmsapi20170525.models.SendSmsResponse;
import com.message.IntegrationSmsTest;
import com.message.sms.config.SmsProperties;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.Collections;
import java.util.Map;
import java.util.Random;

class SendIntegrationTest extends IntegrationSmsTest {
    @Autowired
    private SmsProperties smsProperties;

    @Test
    void sendSms() {
        int random = new Random().nextInt(10000);
        Map<String, String> templateParamJson = Collections.singletonMap("code", Integer.toString(random));

        SendSmsResponse sendSmsResponse = Send.sendSms(smsProperties.getPhone2(), smsProperties.getSignName(),
                smsProperties.getTemplateCode(), templateParamJson);

        System.out.println(sendSmsResponse.body.code);
        System.out.println(sendSmsResponse.body.message);
        System.out.println(sendSmsResponse.body.bizId);
        System.out.println(sendSmsResponse.body.requestId);
    }
}