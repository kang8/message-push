package com.message.sms;

import com.aliyun.dysmsapi20170525.Client;
import com.aliyun.dysmsapi20170525.models.SendBatchSmsRequest;
import com.aliyun.dysmsapi20170525.models.SendBatchSmsResponse;
import com.aliyun.dysmsapi20170525.models.SendSmsRequest;
import com.aliyun.dysmsapi20170525.models.SendSmsResponse;
import com.message.sms.except.AliyunSmsException;

/**
 * @author kang
 * @date 2021/8/23 10:32
 */
public class Send {

    public static SendSmsResponse sendSms(String phoneNumber, String signName, String templateCode) {
        return sendSms(phoneNumber, signName, templateCode, null, null, null);
    }

    public static SendSmsResponse sendSms(String phoneNumber, String signName, String templateCode, String templateParam) {
        return sendSms(phoneNumber, signName, templateCode, templateParam, null, null);
    }

    public static SendSmsResponse sendSms(String phoneNumber, String signName, String templateCode, String templateParam, String smsUpExtendCode, String outId) {
        Client client = Sms.createClient();
        SendSmsRequest sendSmsRequest = new SendSmsRequest()
                .setPhoneNumbers(phoneNumber)
                .setSignName(signName)
                .setTemplateCode(templateCode)
                .setTemplateParam(templateParam)
                .setSmsUpExtendCode(smsUpExtendCode)
                .setOutId(outId);

        try {
            return client.sendSms(sendSmsRequest);
        } catch (Exception e) {
            e.printStackTrace();
            throw new AliyunSmsException("发送短信失败", e);
        }
    }


    public static SendBatchSmsResponse sendBatchSms(String phoneNumberJson, String signNameJson, String templateCode) {
        return sendBatchSms(phoneNumberJson, signNameJson, templateCode, null, null);
    }

    public static SendBatchSmsResponse sendBatchSms(String phoneNumberJson, String signNameJson, String templateCode, String templateParamJson) {
        return sendBatchSms(phoneNumberJson, signNameJson, templateCode, templateParamJson, null);
    }

    public static SendBatchSmsResponse sendBatchSms(String phoneNumberJson, String signNameJson, String templateCode, String templateParamJson, String smsUpExtendCodeJson) {
        Client client = Sms.createClient();
        SendBatchSmsRequest sendBatchSmsRequest = new SendBatchSmsRequest()
                .setPhoneNumberJson(phoneNumberJson)
                .setSignNameJson(signNameJson)
                .setTemplateCode(templateCode)
                .setTemplateParamJson(templateParamJson)
                .setSmsUpExtendCodeJson(smsUpExtendCodeJson);

        try {
            return client.sendBatchSms(sendBatchSmsRequest);
        } catch (Exception e) {
            e.printStackTrace();
            throw new AliyunSmsException("批量发送短信失败", e);
        }
    }
}
