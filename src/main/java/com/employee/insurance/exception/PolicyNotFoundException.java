package com.employee.insurance.exception;

public class PolicyNotFoundException extends Exception{

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	
	public PolicyNotFoundException() {
		
	}
	
	public PolicyNotFoundException(String msg) {
		super(msg);
	}

}
