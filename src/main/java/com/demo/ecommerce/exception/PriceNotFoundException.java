package com.demo.ecommerce.exception;

public class PriceNotFoundException extends Exception{

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	
	public PriceNotFoundException() {
		
	}
	
	public PriceNotFoundException(String msg) {
		super(msg);
	}

}
