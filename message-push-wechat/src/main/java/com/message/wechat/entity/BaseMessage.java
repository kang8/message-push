package com.message.wechat.entity;

import java.io.Serializable;

import lombok.Data;
import lombok.experimental.SuperBuilder;

@Data
@SuperBuilder
public class BaseMessage implements Serializable {
    // 成员、部门和标签，必须有一个存在。也就是要有消息接收方。

    /**
     * 指定接受消息的成员
     */
    private String touser;
    /**
     * 指定接受消息的部门
     */
    private String toparty;
    /**
     * 指定接受消息的标签
     */
    private String totag;
    /**
     * 消息类型
     */
    private String msgtype;
    /**
     * 企业应用 ID
     */
    private int agentid;
    /**
     * 是否开启重复消息检查
     */
    private Integer enable_duplicate_check;
    /**
     * 是否重复消息检查的时间间隔
     */
    private Integer duplicate_check_interval;
}
