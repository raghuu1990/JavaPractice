package com.company.flipkart.chess;

public enum Colors {
	BLACK("B"), WHITE("W");

	private String value;

	private Colors(String value) {
		this.value = value;
	}

	public String getValue() {
		return this.value;
	}

	public static Colors getColorType(String param) {
		for (Colors colors : Colors.values()) {
			if (colors.getValue().toString().equalsIgnoreCase(param)) {
				return colors;
			}
		}
		return null;
	}
}