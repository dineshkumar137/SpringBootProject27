package com.example.demo.exception;

public class OutofStockException extends RuntimeException {
	public String msg;

	public OutofStockException() {
		super();
	}

	public OutofStockException(String msg) {
		super(msg);
		
	}
}
