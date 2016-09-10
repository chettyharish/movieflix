package com.movie.app.exception;

public class AddressNotFoundException extends RuntimeException {
	private static final long serialVersionUID = 5603051271523964879L;

	public AddressNotFoundException(String message) {
		super(message);
	}

}
