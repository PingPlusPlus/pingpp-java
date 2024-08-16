package com.pingplusplus.exception;

public class RateLimitException extends PingppException {

    private static final long serialVersionUID = 2L;

    public RateLimitException(String message, Throwable e) {
        super(message, e);
    }

    public RateLimitException(String message, String type, String code, int statusCode, Throwable e) {
        super(message, type, code, statusCode, e);
    }
}
