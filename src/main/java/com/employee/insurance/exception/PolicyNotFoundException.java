package com.employee.insurance.exception;

import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.http.HttpStatus;

@ResponseStatus(HttpStatus.NOT_FOUND)
public class PolicyNotFoundException extends Exception{

	/**
	 * 
	 */
	private static final long serialVersionUID = -9079454849611061074L;
	
	public PolicyNotFoundException() {
		super();
	}
	
	public PolicyNotFoundException(String msg) {
		super(msg);
	}

}
