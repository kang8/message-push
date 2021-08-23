package com.message.sms;

import com.aliyun.dysmsapi20170525.models.QuerySmsTemplateResponse;
import com.message.IntegrationSmsTest;
import com.message.sms.config.SmsProperties;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;

class TemplateTest extends IntegrationSmsTest {
    @Autowired
    private SmsProperties smsProperties;

    @Test
    void querySmsTemplate() {
        String templateCode = smsProperties.getTemplateCode();
        QuerySmsTemplateResponse response = Template.querySmsTemplate(templateCode);

        System.out.println(response.body.templateContent);
        System.out.println(response.body.requestId);
        System.out.println(response.body.templateCode);
        System.out.println(response.body.templateStatus);
        System.out.println(response.body.code);
        System.out.println(response.body.templateType);
        System.out.println(response.body.message);
        System.out.println(response.body.templateName);
        System.out.println(response.body.createDate);
        System.out.println(response.body.reason);

    }
}