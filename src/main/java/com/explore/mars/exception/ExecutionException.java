package com.explore.mars.exception;


/**
 * Exception class which will be used if there is a problem with the exection of a request
 * @author sjunejo
 *
 */
public class ExecutionException extends RuntimeException {
	
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	public ExecutionException() {
		super();
	}
	
	public ExecutionException(String message) {
		super(message);
	}
	
	public ExecutionException(String message, Throwable th) {
		super(message, th);
	}
	
}
