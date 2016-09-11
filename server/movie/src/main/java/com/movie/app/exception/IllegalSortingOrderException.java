package com.movie.app.exception;

public class IllegalSortingOrderException extends RuntimeException {
	private static final long serialVersionUID = 5603051271523964879L;

	public IllegalSortingOrderException(String message) {
		super(message);
	}
}
