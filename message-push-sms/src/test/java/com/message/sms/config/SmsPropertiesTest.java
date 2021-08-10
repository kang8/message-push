package com.message.sms.config;

import com.message.IntegrationSmsTest;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;

import static org.junit.jupiter.api.Assertions.*;

class SmsPropertiesTest extends IntegrationSmsTest {
    @Autowired
    private SmsProperties smsProperties;

    @Test
    void testSmsProperties() {
        System.out.println(smsProperties.getAccessKeyId());
        System.out.println(smsProperties.getAccessKeySecret());
        System.out.println(smsProperties.getEndpoint());

        assertEquals("dysmsapi.aliyuncs.com", smsProperties.getEndpoint());
    }
}