package com.example.demo.exception;

import org.springframework.web.bind.annotation.RestControllerAdvice;

@RestControllerAdvice
public class ExceptionHandler {
	
	@org.springframework.web.bind.annotation.ExceptionHandler(IdNotFound.class)
	public String idNotFound(IdNotFound e)
	{
		return "Record for entered id didn't found";
	}
	

}
