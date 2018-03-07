package com.company.flipkart.chess.piece;

import com.company.flipkart.chess.Colors;
import com.company.flipkart.chess.Position;

public class Bishop extends AbstractPiece{
	@Override
	public boolean validateMove(String[][] board, Colors color, Position start, Position end) {
		return crossCheck(board, color, start, end);
	}
}