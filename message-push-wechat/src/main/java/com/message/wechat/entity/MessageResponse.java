package com.message.wechat.entity;

import lombok.Data;
import lombok.EqualsAndHashCode;

/**
 * 更多内容可看文档：https://work.weixin.qq.com/api/doc/90000/90135/90236#h2-u63A5u53E3u5B9Au4E49
 *
 * @author kang
 */
@EqualsAndHashCode(callSuper = true)
@Data
public class MessageResponse extends BaseResponse {
    /**
     * 未发送成功的人员
     */
    private String invaliduser;
    /**
     * 未发送成功的部门
     */
    private String invalidparty;
    /**
     * 未发送成功的标签
     */
    private String invalidtag;
}
