package com.cg.greatoutdoors.exception;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;


@RestControllerAdvice
public class ExceptionController {

	@ExceptionHandler(value = ProductException.class)
	public ResponseEntity<String> handleException(ProductException exception) {
		return new ResponseEntity<String>(exception.getMessage(), HttpStatus.NOT_FOUND);
	}
	@ExceptionHandler(value = UserException.class)
	public ResponseEntity<String> handleException(UserException exception) {
		return new ResponseEntity<String>(exception.getMessage(), HttpStatus.NOT_FOUND);
	}
	@ExceptionHandler(value = AddToCartException.class)
	public ResponseEntity<String> handleException(AddToCartException exception) {
		return new ResponseEntity<String>(exception.getMessage(), HttpStatus.NOT_FOUND);
	}
}
