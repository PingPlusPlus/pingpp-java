package com.pingplusplus.exception;

public class APIException extends PingppException {

	private static final long serialVersionUID = 1L;

	public APIException(String message, Throwable e) {
		super(message, e);
	}

}
