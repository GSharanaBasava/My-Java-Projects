package com;

public class InvalidChoiceException extends RuntimeException{
	
	private String message;
	
	public InvalidChoiceException(String name) {
		this.message=name;
	}
	
	public String getMessage() {
		return message;
	}

}
