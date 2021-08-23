package com.message.sms;

import com.alibaba.fastjson.JSON;
import com.aliyun.dysmsapi20170525.models.QuerySendDetailsResponse;
import com.aliyun.dysmsapi20170525.models.QuerySendDetailsResponseBody;
import com.message.IntegrationSmsTest;
import com.message.sms.config.SmsProperties;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;

class SmsTest extends IntegrationSmsTest {
    @Autowired
    private SmsProperties smsProperties;

    @Test
    void querySendDetails() {
        QuerySendDetailsResponse queryResponse = Sms.querySendDetails(smsProperties.getPhone2(), null, "20210823", 10L, 1L);

        System.out.println(queryResponse.body.code);
        System.out.println(queryResponse.body.message);
        System.out.println(queryResponse.body.requestId);
        System.out.println(queryResponse.body.totalCount);
        System.out.println(queryResponse.body.smsSendDetailDTOs);

        System.out.println(JSON.toJSONString(queryResponse.body.smsSendDetailDTOs));
    }

    @Test
    void querySendDetailsWithBizId() {
        QuerySendDetailsResponse queryResponse = Sms.querySendDetails(smsProperties.getPhone2(), "537806429704236540^0", "20210823", 10L, 1L);

        System.out.println(queryResponse.body.code);
        System.out.println(queryResponse.body.message);
        System.out.println(queryResponse.body.requestId);
        System.out.println(queryResponse.body.totalCount);
        System.out.println();

        for (QuerySendDetailsResponseBody.QuerySendDetailsResponseBodySmsSendDetailDTOsSmsSendDetailDTO query : queryResponse.body.smsSendDetailDTOs.getSmsSendDetailDTO()) {
            System.out.println(query.outId);
            System.out.println(query.content);
            System.out.println(query.sendDate);
            System.out.println(query.sendStatus);
            System.out.println(query.errCode);
            System.out.println(query.phoneNum);
            System.out.println(query.templateCode);
        }
    }
}