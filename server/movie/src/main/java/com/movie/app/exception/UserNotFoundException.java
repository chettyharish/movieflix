package com.movie.app.exception;

public class UserNotFoundException extends RuntimeException {
	private static final long serialVersionUID = 5603051271523964879L;

	public UserNotFoundException(String message) {
		super(message);
	}
}
