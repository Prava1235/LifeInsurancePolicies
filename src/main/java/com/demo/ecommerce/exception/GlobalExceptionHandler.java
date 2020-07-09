package com.demo.ecommerce.exception;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

import com.employee.insurance.constants.AppConstants;

/**
 * Global exception handler component
 * @author janbee
 *
 */
@ControllerAdvice
public class GlobalExceptionHandler {

	/**
	 * Handles ProductNotFoundException
	 * @return String
	 */
	@ExceptionHandler(value = ProductNotFoundException.class)
	public ResponseEntity<String> handleProductNotFoundException() {
		return new ResponseEntity<>(AppConstants.PRODUCT_NOT_FOUND,HttpStatus.NOT_FOUND);
	}
	
	/**
	 * Handles UserNotFoundException
	 * @return String
	 */
	@ExceptionHandler(value = UserNotFoundException.class)
	public ResponseEntity<String> handleUserNotFoundException() {
		return new ResponseEntity<>(AppConstants.USER_NOT_FOUND,HttpStatus.NOT_FOUND);
	}
	
	/**
	 * Handles PriceNotFoundException
	 * @return String
	 */
	@ExceptionHandler(value = PriceNotFoundException.class)
	public ResponseEntity<String> handlePriceNotFoundException() {
		return new ResponseEntity<>(AppConstants.PRICE_NOT_FOUND, HttpStatus.NOT_FOUND);
	}
}
