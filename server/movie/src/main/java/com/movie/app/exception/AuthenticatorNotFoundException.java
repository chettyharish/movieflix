package com.movie.app.exception;

public class AuthenticatorNotFoundException extends RuntimeException {
	private static final long serialVersionUID = 5603051271523964879L;

	public AuthenticatorNotFoundException(String message) {
		super(message);
	}
}
