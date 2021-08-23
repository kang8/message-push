package com.message.sms;

import com.aliyun.dysmsapi20170525.Client;
import com.aliyun.dysmsapi20170525.models.QuerySendDetailsRequest;
import com.aliyun.dysmsapi20170525.models.QuerySendDetailsResponse;
import com.aliyun.teaopenapi.models.Config;
import com.message.sms.config.SmsProperties;
import com.message.sms.except.AliyunSmsException;
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
            throw new AliyunSmsException("创建 SMS Client 失败");
        }
    }

    public static QuerySendDetailsResponse querySendDetails(String phoneNumber, String bizId, String sendDate, Long pageSize, Long currentPage) {
        Client client = createClient();
        QuerySendDetailsRequest queryRequest = new QuerySendDetailsRequest()
                .setPhoneNumber(phoneNumber)
                .setSendDate(sendDate)
                .setPageSize(pageSize)
                .setCurrentPage(currentPage);

        if (bizId != null) {
            queryRequest.setBizId(bizId);
        }

        try {
            return client.querySendDetails(queryRequest);
        } catch (Exception e) {
            e.printStackTrace();
            throw new AliyunSmsException("查看短信发送记录和发送状态失败");
        }
    }
}
