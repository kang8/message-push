package com.message.sms;

import com.aliyun.dysmsapi20170525.Client;
import com.aliyun.dysmsapi20170525.models.*;
import com.message.sms.entity.TemplateEntity;
import com.message.sms.except.AliyunSmsException;

/**
 * 短信模板
 *
 * @author kang
 * @date 2021/8/16 19:29
 */
public class Template {

    public static AddSmsTemplateResponse addSmsTemplate(TemplateEntity templateEntity) {
        Client client = Sms.createClient();
        AddSmsTemplateRequest addRequest = new AddSmsTemplateRequest()
                .setTemplateType(templateEntity.getTemplateType())
                .setTemplateName(templateEntity.getTemplateName())
                .setTemplateContent(templateEntity.getTemplateContent())
                .setRemark(templateEntity.getRemark());

        try {
            return client.addSmsTemplate(addRequest);
        } catch (Exception e) {
            throw new AliyunSmsException("新增短信模板失败", e);
        }
    }

    public static void deleteSmsTemplate(String templateCode) {
        Client client = Sms.createClient();
        DeleteSmsTemplateRequest deleteRequest = new DeleteSmsTemplateRequest().setTemplateCode(templateCode);

        try {
            client.deleteSmsTemplate(deleteRequest);
        } catch (Exception e) {
            throw new AliyunSmsException("删除短信模板错误", e);
        }
    }

    public static ModifySmsTemplateResponse modifySmsTemplate(String templateCode, TemplateEntity templateEntity) {
        Client client = Sms.createClient();
        ModifySmsTemplateRequest modifyRequest = new ModifySmsTemplateRequest()
                .setTemplateCode(templateCode)
                .setTemplateType(templateEntity.getTemplateType())
                .setTemplateName(templateEntity.getTemplateName())
                .setTemplateContent(templateEntity.getTemplateContent())
                .setRemark(templateEntity.getRemark());

        try {
            return client.modifySmsTemplate(modifyRequest);
        } catch (Exception e) {
            throw new AliyunSmsException("修改短信模板失败", e);
        }
    }

    public static QuerySmsTemplateResponse querySmsTemplate(String templateCode) {
        Client client = Sms.createClient();
        QuerySmsTemplateRequest queryRequest = new QuerySmsTemplateRequest().setTemplateCode(templateCode);

        try {
            return client.querySmsTemplate(queryRequest);
        } catch (Exception e) {
            throw new AliyunSmsException("查询短信模板失败", e);
        }
    }
}
