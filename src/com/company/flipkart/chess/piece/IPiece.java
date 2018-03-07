package com.company.flipkart.chess.piece;

import com.company.flipkart.chess.Colors;
import com.company.flipkart.chess.Position;

public interface IPiece {
	boolean validateMove(String[][] board, Colors color, Position start, Position end);
	boolean isAllEmptyInCross(String[][] board, Position start, Position end);
	boolean isAllEmptyInHorizontal(String[][] board, Position start, Position end);
	boolean isAllEmptyInVertical(String[][] board, Position start, Position end);
}