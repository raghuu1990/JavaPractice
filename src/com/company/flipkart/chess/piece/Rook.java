package com.company.flipkart.chess.piece;

import com.company.flipkart.chess.Colors;
import com.company.flipkart.chess.Position;

public class Rook extends AbstractPiece{
	@Override
	public boolean validateMove(String[][] board, Colors color, Position start, Position end) {
		return horizontalCheck(board, color, start, end) || verticalCheck(board, color, start, end);
	}
}