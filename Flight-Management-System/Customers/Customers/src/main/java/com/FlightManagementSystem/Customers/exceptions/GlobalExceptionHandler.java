package com.FlightManagementSystem.Customers.exceptions;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.servlet.mvc.method.annotation.ResponseEntityExceptionHandler;

@ControllerAdvice
public class GlobalExceptionHandler extends ResponseEntityExceptionHandler {
	
	@ExceptionHandler(value =RecordNotFoundException.class)
	public ResponseEntity<String> RecordNotFoundException (Exception exception) {
		ResponseEntity<String> responseEntity = new ResponseEntity<>(exception.getMessage(), HttpStatus.NOT_FOUND);
		return responseEntity;
	}
	@ExceptionHandler(value = RecordsNotFoundException.class)
	public ResponseEntity<String> handleInvalidEmailException(Exception exception) {
		ResponseEntity<String> responseEntity = new ResponseEntity<>(exception.getMessage(), HttpStatus.NOT_FOUND);
		return responseEntity;
	}
	@ExceptionHandler(value = RecordsAlreadyFoundExceptions.class)
	public ResponseEntity<String> handlePhoneNoException(Exception exception) {
		ResponseEntity<String> responseEntity = new ResponseEntity<>(exception.getMessage(), HttpStatus.NOT_FOUND);
		return responseEntity;
	}
}