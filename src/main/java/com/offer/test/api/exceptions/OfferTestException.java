package com.offer.test.api.exceptions;

public class OfferTestException extends Exception {

	private static final long serialVersionUID = 4084469028556289930L;

	public OfferTestException() {
		super();
	}

	public OfferTestException(String message) {
		super(message);
	}

	public OfferTestException(String message, Throwable cause) {
		super(message, cause);
	}
}
