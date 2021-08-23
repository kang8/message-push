package com.message.sms;

import com.alibaba.fastjson.JSON;
import com.aliyun.dysmsapi20170525.Client;
import com.aliyun.dysmsapi20170525.models.SendBatchSmsRequest;
import com.aliyun.dysmsapi20170525.models.SendBatchSmsResponse;
import com.aliyun.dysmsapi20170525.models.SendSmsRequest;
import com.aliyun.dysmsapi20170525.models.SendSmsResponse;
import com.message.sms.except.AliyunSmsException;

import java.util.Collections;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

/**
 * @author kang
 * @date 2021/8/23 10:32
 */
public class Send {

    public static SendSmsResponse sendSms(String phoneNumber, String signName, String templateCode) {
        return sendSms(phoneNumber, signName, templateCode, null, null, null);
    }

    public static SendSmsResponse sendSms(String phoneNumber, String signName, String templateCode, Map<String, String> templateParam) {
        return sendSms(phoneNumber, signName, templateCode, templateParam, null, null);
    }

    public static SendSmsResponse sendSms(String phoneNumber, String signName, String templateCode, Map<String, String> templateParam,
                                          String smsUpExtendCode, String outId) {
        String templateParamJson = JSON.toJSONString(templateParam);

        Client client = Sms.createClient();
        SendSmsRequest sendSmsRequest = new SendSmsRequest()
                .setPhoneNumbers(phoneNumber)
                .setSignName(signName)
                .setTemplateCode(templateCode);

        if (templateParam != null) {
            sendSmsRequest.setTemplateParam(templateParamJson);
        }
        if (smsUpExtendCode != null) {
            sendSmsRequest.setSmsUpExtendCode(smsUpExtendCode);
        }
        if (outId != null) {
            sendSmsRequest.setOutId(outId);
        }

        try {
            return client.sendSms(sendSmsRequest);
        } catch (Exception e) {
            e.printStackTrace();
            throw new AliyunSmsException("发送短信失败", e);
        }
    }


    public static SendBatchSmsResponse sendBatchSms(List<String> phoneNumberList, String signName, String templateCode) {
        return sendBatchSms(phoneNumberList, signName, templateCode, null, null);
    }

    public static SendBatchSmsResponse sendBatchSms(List<String> phoneNumberList, String signName, String templateCode, Map<String, String> templateParam) {
        return sendBatchSms(phoneNumberList, signName, templateCode, templateParam, null);
    }

    public static SendBatchSmsResponse sendBatchSms(List<String> phoneNumberList, String signName, String templateCode,
                                                    Map<String, String> templateParam, List<String> smsUpExtendCodeList) {
        int phoneSize = phoneNumberList.size();

        String phoneNumberJson = JSON.toJSONString(phoneNumberList);
        String signNameJson = JSON.toJSONString(Collections.nCopies(phoneSize, signName));

        Client client = Sms.createClient();
        SendBatchSmsRequest sendBatchSmsRequest = new SendBatchSmsRequest()
                .setPhoneNumberJson(phoneNumberJson)
                .setSignNameJson(signNameJson)
                .setTemplateCode(templateCode);

        if (templateParam != null) {
            String templateParamJson = Collections.nCopies(phoneSize, JSON.toJSONString(templateParam))
                    .stream()
                    .collect(Collectors.joining(",", "[", "]"));
            sendBatchSmsRequest.setTemplateParamJson(templateParamJson);
        }
        if (smsUpExtendCodeList != null && smsUpExtendCodeList.size() > 0) {
            String smsUpExtendCodeJson = JSON.toJSONString(smsUpExtendCodeList);
            sendBatchSmsRequest.setSmsUpExtendCodeJson(smsUpExtendCodeJson);
        }


        try {
            return client.sendBatchSms(sendBatchSmsRequest);
        } catch (Exception e) {
            e.printStackTrace();
            throw new AliyunSmsException("批量发送短信失败", e);
        }
    }
}
