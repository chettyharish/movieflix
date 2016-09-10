package com.movie.app.exception;

public final class AuthenticatorExistsException extends RuntimeException {
	private static final long serialVersionUID = 5603051271523964879L;

	public AuthenticatorExistsException(String message) {
		super(message);
	}
}
