package com.employee.insurance.exception;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

import com.employee.insurance.constants.AppConstants;
@ControllerAdvice
public class GlobalExceptionHandler {

		
	/**
	 * Handles PriceNotFoundException
	 * @return String
	 */
	@ExceptionHandler(value = PolicyNotFoundException.class)
	public ResponseEntity<String> handlePriceNotFoundException() {
		return new ResponseEntity<>(AppConstants.POLICY_NOT_FOUND , HttpStatus.NOT_FOUND);
	}
}
