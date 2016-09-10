package com.movie.app.exception;

public class CommentNotFoundException extends RuntimeException {
	private static final long serialVersionUID = 5603051271523964879L;

	public CommentNotFoundException(String message) {
		super(message);
	}
}
