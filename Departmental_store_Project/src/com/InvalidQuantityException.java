package com;

public class InvalidQuantityException extends RuntimeException {

	private String message;

	public InvalidQuantityException(String name) {
		this.message=name;
	}
@Override
	public String getMessage() {
		return message;
	}

}
