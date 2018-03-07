package com.design.vendingmachine;

public class SoldOutException extends RuntimeException {
	private static final long serialVersionUID = 3734520291666587624L;
	private String message;

	public SoldOutException(String string) {
		this.message = string;
	}

	@Override
	public String getMessage() {
		return message;
	}
}