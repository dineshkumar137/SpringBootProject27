package com.example.demo.exception;

public class ProductexistsAlready extends RuntimeException {
private String msg;

	
	
	public ProductexistsAlready() {
		super();
	}



	public ProductexistsAlready(String msg) {
		super(msg);
	
	}
	
}
