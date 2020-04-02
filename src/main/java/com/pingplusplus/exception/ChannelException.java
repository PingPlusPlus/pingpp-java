package com.pingplusplus.exception;

public class ChannelException extends PingppException {

    private static final long serialVersionUID = 2L;

    private final String param;

    public ChannelException(String message, String type, String code, int statusCode, Throwable e) {
        super(message, type, code, statusCode, e);
        this.param = null;
    }

    public ChannelException(String message, String type, String code, String param, int statusCode, Throwable e) {
        super(message, type, code, statusCode, e);
        this.param = param;
    }

    public String getParam() {
        return param;
    }

}
