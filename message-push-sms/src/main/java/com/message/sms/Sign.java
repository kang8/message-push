package com.message.sms;

import com.aliyun.dysmsapi20170525.Client;
import com.aliyun.dysmsapi20170525.models.DeleteSmsSignRequest;
import com.aliyun.dysmsapi20170525.models.DeleteSmsSignResponse;
import com.aliyun.dysmsapi20170525.models.QuerySmsSignRequest;
import com.aliyun.dysmsapi20170525.models.QuerySmsSignResponse;
import com.message.sms.except.AliyunSmsException;

/**
 * 签名服务
 *
 * @author kang
 * @date 2021/8/10 15:53
 */
public class Sign {

    public static QuerySmsSignResponse querySmsSign(String signName) {
        Client client = Sms.createClient();
        QuerySmsSignRequest queryRequest = new QuerySmsSignRequest().setSignName(signName);

        try {
            return client.querySmsSign(queryRequest);
        } catch (Exception e) {
            throw new AliyunSmsException("查询 SMS sign 错误", e);
        }
    }

    public static DeleteSmsSignResponse deleteSmsSignRequest(String signName) {
        Client client = Sms.createClient();
        DeleteSmsSignRequest deleteRequest = new DeleteSmsSignRequest().setSignName(signName);

        try {
            return client.deleteSmsSign(deleteRequest);
        } catch (Exception e) {
            throw new AliyunSmsException("删除 SMS sign 错误", e);
        }
    }
}
