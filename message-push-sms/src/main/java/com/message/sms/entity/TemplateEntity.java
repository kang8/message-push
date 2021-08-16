package com.message.sms.entity;

import lombok.Data;

/**
 * @author kang
 * @date 2021/8/16 19:32
 */
@Data
public class TemplateEntity {
    /**
     * 短信类型
     */
    private Integer templateType;
    /**
     * 模板名称
     */
    private String templateName;
    /**
     * 模板内容
     */
    private String templateContent;
    /**
     * 短信模板申请说明
     */
    private String remark;
}
