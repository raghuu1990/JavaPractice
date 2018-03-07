package com.company.flipkart.chess.piece;

import com.company.flipkart.chess.Colors;
import com.company.flipkart.chess.Position;

public class Horse extends AbstractPiece{
	private static int[][] horseMoves = { { 2, 2, -2, -2, 1, 1, -1, -1 }, { 1, -1, 1, -1, 2, -2, 2, -2 } };

	@Override
	public boolean validateMove(String[][] board, Colors color, Position start, Position end) {
		for (int i = 0; i < horseMoves[0].length; i++) {
			if ((start.i + horseMoves[0][i] == end.i) && (start.j + horseMoves[1][i] == end.j)) {
				return true;
			}
		}
		return false;
	}
}