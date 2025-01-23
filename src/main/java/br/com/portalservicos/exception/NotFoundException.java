package br.com.portalservicos.exception;

public class NotFoundException extends RuntimeException {

	public NotFoundException() {
		super();
	}

	public NotFoundException(String message) {
		super(message);
	}

	public NotFoundException(String message, Throwable throwable) {
		super(message, throwable);
	}

}
