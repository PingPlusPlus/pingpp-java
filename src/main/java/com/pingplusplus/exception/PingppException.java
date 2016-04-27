package com.pingplusplus.exception;

public abstract class PingppException extends Exception {

	public PingppException(String message) {
		super(message, null);
	}

	public PingppException(String message, Throwable e) {
		super(message, e);
	}

	private static final long serialVersionUID = 1L;

}
