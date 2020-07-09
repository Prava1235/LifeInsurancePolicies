package com.demo.ecommerce.exception;

public class NoPurchaseHistoryFound extends RuntimeException{

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	private String message;

	public NoPurchaseHistoryFound() {

	}

	public NoPurchaseHistoryFound(String meaasge) {
		this.message = message;
	}

	public String getMessage() {
		return message;
	}

	public void setMessage(String message) {
		this.message = message;
	}



}
