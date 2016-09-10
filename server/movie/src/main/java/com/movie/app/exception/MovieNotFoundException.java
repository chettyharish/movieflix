package com.movie.app.exception;

public class MovieNotFoundException extends RuntimeException {
	private static final long serialVersionUID = 5603051271523964879L;

	public MovieNotFoundException(String message) {
		super(message);
	}
}
