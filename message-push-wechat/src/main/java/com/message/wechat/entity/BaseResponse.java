package com.message.wechat.entity;

import lombok.Data;

@Data
public class BaseResponse {
    /**
     * 错误返回码
     *
     * 0 -> success, 非 0 -> fail
     */
    private int errcode;
    /**
     * 错误返回码提示语
     */
    private String errmsg;
}
