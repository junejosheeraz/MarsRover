package com.explore.mars.exception;


/**
 * Exception class which will be used if there is a problem with the exection of a request
 * @author sjunejo
 *
 */
public class InvalidCommandException extends RuntimeException {
	
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	public InvalidCommandException() {
		super();
	}
	
	public InvalidCommandException(String message) {
		super(message);
	}
	
	public InvalidCommandException(String message, Throwable th) {
		super(message, th);
	}
	
}
