package com.glaucus.Counter;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

@ControllerAdvice

public class InvalidApiRequestHandler {

	@ExceptionHandler
	public ResponseEntity<ApiErrorResponse> handleException(InvalidApiRequest ex){
		ApiErrorResponse error = new ApiErrorResponse();
		error.setStatus(HttpStatus.NOT_FOUND.value());
		error.setMessage(ex.getMessage());
		error.setTimestamp(System.currentTimeMillis()); 
		return new ResponseEntity<>(error,HttpStatus.NOT_FOUND);
	}
	
	@ExceptionHandler
	public  ResponseEntity<ApiErrorResponse> handleException(Exception x){
		ApiErrorResponse error = new ApiErrorResponse();
		error.setStatus(HttpStatus.BAD_REQUEST.value());
		error.setMessage(x.getMessage());
		error.setTimestamp(System.currentTimeMillis()); 
		return new ResponseEntity<>(error,HttpStatus.BAD_REQUEST);
	
	}
}
