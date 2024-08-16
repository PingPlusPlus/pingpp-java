package com.pingplusplus.exception;

public class InvalidRequestException extends PingppException {

    private static final long serialVersionUID = 2L;

    private final String param;

    public InvalidRequestException(String message, String type, String code, String param, int statusCode, Throwable e) {
        super(message, type, code, statusCode, e);
        this.param = param;
    }

    public String getParam() {
        return param;
    }
}
