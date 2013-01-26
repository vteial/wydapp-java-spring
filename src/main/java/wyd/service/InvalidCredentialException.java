package wyd.service;

import wyd.WydException;

public class InvalidCredentialException extends WydException {

	public InvalidCredentialException() {
		super();
	}

	public InvalidCredentialException(String message) {
		super(message);
	}

	public InvalidCredentialException(String message, Throwable throwable) {
		super(message);
	}
}
