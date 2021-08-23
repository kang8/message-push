package com.message.sms;

import com.aliyun.dysmsapi20170525.models.QuerySmsSignResponse;
import com.message.IntegrationSmsTest;
import com.message.sms.config.SmsProperties;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;

import static org.junit.jupiter.api.Assertions.assertEquals;

class SignTest extends IntegrationSmsTest {

    @Autowired
    private SmsProperties smsProperties;

    @Test
    void querySmsSign() throws Exception {
        QuerySmsSignResponse query = Sign.querySmsSign(smsProperties.getSignName());

        System.out.println(query.body.requestId);
        System.out.println(query.body.signStatus);
        System.out.println(query.body.code);
        System.out.println(query.body.message);
        System.out.println(query.body.createDate);
        System.out.println(query.body.reason);
        System.out.println(query.body.signName);
        assertEquals("OK", query.body.message);
    }
}