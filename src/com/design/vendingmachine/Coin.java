package com.design.vendingmachine;

public enum Coin {
	ONE(1), TWO(2), FIVE(5), TEN(10);

	private int value;

	private Coin(int value) {
		this.value = value;
	}

	public int getValue() {
		return value;
	}
}