package com.message.sms;

import com.message.sms.config.SmsProperties;
import org.json.JSONArray;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.ArrayList;
import java.util.List;

class SendTest {
    @Autowired
    private SmsProperties smsProperties;

    @Test
    void sendBatchSms() {
        List<String> phoneNumbers = new ArrayList<>() {{
            add("13083529161");
            add("13052854811");
            add("13092628877");
            add("13151152201");
            add("13063813990");
        }};

        JSONArray jsonArray = new JSONArray(phoneNumbers);
        System.out.println(jsonArray);
    }
}