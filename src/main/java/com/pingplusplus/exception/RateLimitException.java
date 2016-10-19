package com.pingplusplus.exception;

public class RateLimitException extends PingppException {

	private static final long serialVersionUID = 1L;

	public RateLimitException(String message, Throwable e) {
		super(message, e);
	}

}
