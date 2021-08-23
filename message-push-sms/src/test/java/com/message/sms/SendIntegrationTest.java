package com.message.sms;

import com.aliyun.dysmsapi20170525.models.SendBatchSmsResponse;
import com.aliyun.dysmsapi20170525.models.SendSmsResponse;
import com.message.IntegrationSmsTest;
import com.message.sms.config.SmsProperties;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.*;

class SendIntegrationTest extends IntegrationSmsTest {
    @Autowired
    private SmsProperties smsProperties;

    private final int random = new Random().nextInt(10000);

    @Test
    void sendSmsWithParam() {
        Map<String, String> templateParamJson = Collections.singletonMap("code", Integer.toString(random));

        SendSmsResponse sendSmsResponse = Send.sendSms(smsProperties.getPhone2(), smsProperties.getSignName(),
                smsProperties.getTemplateCode(), templateParamJson);

        System.out.println(sendSmsResponse.body.code);
        System.out.println(sendSmsResponse.body.message);
        System.out.println(sendSmsResponse.body.bizId);
        System.out.println(sendSmsResponse.body.requestId);
    }

    @Test
    void sendSms() {
        SendSmsResponse sendSmsResponse = Send.sendSms(smsProperties.getPhone2(), smsProperties.getSignName(),
                smsProperties.getTemplateCode());

        System.out.println(sendSmsResponse.body.code);
        System.out.println(sendSmsResponse.body.message);
        System.out.println(sendSmsResponse.body.bizId);
        System.out.println(sendSmsResponse.body.requestId);
    }

    @Test
    void testSendBatchSmsWithParam() {
        List<String> phoneNumbers = new ArrayList<>() {{
            add(smsProperties.getPhone2());
            add(smsProperties.getPhone1());
        }};

        SendBatchSmsResponse response = Send.sendBatchSms(phoneNumbers,
                smsProperties.getSignName(),
                smsProperties.getTemplateCode(),
                Collections.singletonMap("code", Integer.toString(random)));

        System.out.println(response.body.code);
        System.out.println(response.body.message);
        System.out.println(response.body.bizId);
        System.out.println(response.body.requestId);
    }

    @Test
    void testSendBatchSms() {
        List<String> phoneNumbers = new ArrayList<>() {{
            add("13083529161");
            add("13052854811");
            add("13092628877");
            add("13151152201");
            add("13063813990");
        }};

        Send.sendBatchSms(phoneNumbers,
                smsProperties.getSignName(),
                smsProperties.getTemplateCode());
    }
}