 package com;

public class InsufficientBalanceException extends RuntimeException {
	private String message;

	InsufficientBalanceException(String message){
		this.message=message;
	}
	@Override
	public String getMessage() {
		return message;
	}
	
}
/**
  Rules to work with custum/User-Define Exception
1.create a class with the exception name .
2.if class extends runtimeExceptin ->Unchecked excection 
2a.if class extends exception ->checked excxeption
3.override the getmessage method ->(variable,constructor,method)
4.invoke the exception Object using throw keyword
handle it using try and catch block with suitable message  
 
 
*/