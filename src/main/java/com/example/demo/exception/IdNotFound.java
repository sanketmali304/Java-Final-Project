package com.example.demo.exception;

public class IdNotFound extends Exception{
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	
	public IdNotFound (String msg)
	{
		super(msg);
	}
}
