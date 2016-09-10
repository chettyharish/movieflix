package com.movie.app.exception;

public class PaymentNotFoundException extends RuntimeException {
	private static final long serialVersionUID = 5603051271523964879L;

	public PaymentNotFoundException(String message) {
		super(message);
	}
}
