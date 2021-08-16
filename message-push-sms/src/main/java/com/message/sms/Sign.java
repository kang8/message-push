package com.message.sms;

import com.aliyun.dysmsapi20170525.Client;
import com.aliyun.dysmsapi20170525.models.QuerySmsSignRequest;
import com.aliyun.dysmsapi20170525.models.QuerySmsSignResponse;
import com.message.sms.except.AliyunException;

/**
 * @author kang
 * @date 2021/8/10 15:53
 * <p>
 * 签名服务
 */
public class Sign {
    public static QuerySmsSignResponse querySmsSign(String signName) {
        Client client = Sms.createClient();
        QuerySmsSignRequest queryRequest = new QuerySmsSignRequest().setSignName(signName);

        try {
            return client.querySmsSign(queryRequest);
        } catch (Exception e) {
            throw new AliyunException("查询 SMS sign 错误", e);
        }
    }
}
