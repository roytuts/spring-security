package com.roytuts.spring.boot.security.jwt.auth.api.exception;

public class DisabledUserException extends RuntimeException {

	private static final long serialVersionUID = 1L;

	public DisabledUserException(String msg) {
		super(msg);
	}

}