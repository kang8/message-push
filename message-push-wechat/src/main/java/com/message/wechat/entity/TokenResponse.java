package com.message.wechat.entity;

import lombok.Data;
import lombok.EqualsAndHashCode;

/**
 * 更多内容可看文档：https://work.weixin.qq.com/api/doc/90000/90135/91039
 *
 * @author kang
 */
@EqualsAndHashCode(callSuper = true)
@Data
public class TokenResponse extends BaseResponse {
    /**
     * 访问令牌
     */
    private String access_token;
    /**
     * 令牌的有效时间，以秒为单位
     */
    private Integer expires_in;
}
