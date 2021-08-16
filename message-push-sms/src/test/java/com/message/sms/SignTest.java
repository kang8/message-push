package com.message.sms;

import com.aliyun.dysmsapi20170525.models.QuerySmsSignResponse;
import com.message.IntegrationSmsTest;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

class SignTest extends IntegrationSmsTest {

    @Test
    void querySmsSign() throws Exception {
        QuerySmsSignResponse query = Sign.querySmsSign("yikang");

        assertEquals("OK", query.body.message);
    }
}