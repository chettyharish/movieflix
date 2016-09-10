package com.movie.app.exception;

public class PaymentExistsException extends RuntimeException {
	private static final long serialVersionUID = 5603051271523964879L;

	public PaymentExistsException(String message) {
		super(message);
	}
}
