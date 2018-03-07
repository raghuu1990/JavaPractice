package com.design.vendingmachine;

public class NotSufficientChangeException extends RuntimeException {
	private static final long serialVersionUID = -6138363837100301016L;
	private String message;

	public NotSufficientChangeException(String string) {
		this.message = string;
	}

	@Override
	public String getMessage() {
		return message;
	}
}