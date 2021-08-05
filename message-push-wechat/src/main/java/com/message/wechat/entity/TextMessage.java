package com.message.wechat.entity;

import lombok.Data;
import lombok.EqualsAndHashCode;

/**
 * 更多内容可看文档：https://work.weixin.qq.com/api/doc/90000/90135/90236#%E6%96%87%E6%9C%AC%E6%B6%88%E6%81%AF
 *
 * @author
 */
@EqualsAndHashCode(callSuper = true)
@Data
public class TextMessage extends BaseMessage {
    /**
     * 消息内容
     */
    private Text text;
    /**
     * 是否是保密消息
     */
    private int safe;
    /**
     * 是否开启 id 转译
     */
    private int enable_id_trans;

    @Data
    public static class Text {
        /**
         * 消息内容，最长不超过 2048 个字节
         */
        private String content;
    }
}
