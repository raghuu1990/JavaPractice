package com.company.flipkart.chess;

public enum PieceType {
	ROOK("R"), HORSE("H"), BISHOP("B"), QUEEN("Q"), KING("K"), PAWN("P");

	private String value;

	private PieceType(String value) {
		this.value = value;
	}

	public String getValue() {
		return this.value;
	}

	public static PieceType getPieceType(String param) {
		for (PieceType piece : PieceType.values()) {
			if (piece.getValue().toString().equalsIgnoreCase(param)) {
				return piece;
			}
		}
		return null;
	}
}