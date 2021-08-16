package com.message.sms.except;

/**
 * @author kang
 * @date 2021/8/16 19:04
 */
public class AliyunException extends RuntimeException {
    public AliyunException() {
        super();
    }

    public AliyunException(String message) {
        super(message);
    }

    public AliyunException(String message, Throwable cause) {
        super(message, cause);
    }

    public AliyunException(Throwable cause) {
        super(cause);
    }

    protected AliyunException(String message, Throwable cause, boolean enableSuppression, boolean writableStackTrace) {
        super(message, cause, enableSuppression, writableStackTrace);
    }
}
