package com.example.demo.exception;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.ResponseStatus;

import com.example.demo.model.ErrorResponse;

@ControllerAdvice
public class GlobalRExceptionHandler {
	
	
	
	@ExceptionHandler(value= OutofStockException.class)
	@ResponseStatus(HttpStatus.NOT_FOUND)
	public @ResponseBody ErrorResponse errorResponseChecker(OutofStockException ex)
	{
		return new ErrorResponse(HttpStatus.NOT_FOUND.value() , ex.getMessage());
	}

	@ExceptionHandler(value= ProductexistsAlready.class)
	@ResponseStatus(HttpStatus.CONFLICT)
	public @ResponseBody ErrorResponse errorResponseChecker(ProductexistsAlready ex)
	{
		return new ErrorResponse(HttpStatus.CONFLICT.value() , ex.getMessage());
	}

	
}