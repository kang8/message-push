package com.message.sms.except;

/**
 * @author kang
 * @date 2021/8/16 19:04
 */
public class AliyunSmsException extends RuntimeException {
    public AliyunSmsException() {
        super();
    }

    public AliyunSmsException(String message) {
        super(message);
    }

    public AliyunSmsException(String message, Throwable cause) {
        super(message, cause);
    }

    public AliyunSmsException(Throwable cause) {
        super(cause);
    }

    protected AliyunSmsException(String message, Throwable cause, boolean enableSuppression, boolean writableStackTrace) {
        super(message, cause, enableSuppression, writableStackTrace);
    }
}
