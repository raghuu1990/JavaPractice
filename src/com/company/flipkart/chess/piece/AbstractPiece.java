package com.company.flipkart.chess.piece;

import com.company.flipkart.chess.Colors;
import com.company.flipkart.chess.Constants;
import com.company.flipkart.chess.Position;

public abstract class AbstractPiece implements IPiece {
	@Override
	public boolean validateMove(String[][] board, Colors color, Position start, Position end) {
		return true;
	}

	public boolean crossCheck(String[][] board, Colors color, Position start, Position end) {
		if (Math.abs(start.i - end.i) == Math.abs(start.j - end.j)) {
			if (isAllEmptyInCross(board, start, end)) {
				return true;
			}
		}
		return false;
	}

	public boolean horizontalCheck(String[][] board, Colors color, Position start, Position end) {
		if (start.i == end.i) {
			if (isAllEmptyInHorizontal(board, start, end)) {
				return true;
			}
		}
		return false;
	}

	public boolean verticalCheck(String[][] board, Colors color, Position start, Position end) {
		if (start.j == end.j) {
			if (isAllEmptyInVertical(board, start, end)) {
				return true;
			}
		}
		return false;
	}

	public boolean isAllEmptyInCross(String[][] board, Position start, Position end) {
		Position first = null;
		Position second = null;
		if (start.i < end.i) {
			first = start;
			second = end;
		} else {
			first = end;
			second = start;
		}

		int i = first.i + 1;
		int j = first.j;
		boolean isIncrement = first.j < second.j ? true : false;
		j = isIncrement ? ++j : --j;
		for (; i < second.i;) {
			if (!board[i][j].equalsIgnoreCase(Constants.spaceBoard)) {
				return false;
			}
			i++;
			j = isIncrement ? ++j : --j;
		}
		return true;
	}

	public boolean isAllEmptyInHorizontal(String[][] board, Position start, Position end) {
		Position first = null;
		Position second = null;

		if (start.j < end.j) {
			first = start;
			second = end;
		} else {
			first = end;
			second = start;
		}
		int j = first.j + 1;
		for (; j < second.i;) {
			if (!board[first.i][j].equalsIgnoreCase(Constants.spaceBoard)) {
				return false;
			}
			j++;
		}
		return true;
	}

	public boolean isAllEmptyInVertical(String[][] board, Position start, Position end) {
		Position first = null;
		Position second = null;

		if (start.i < end.i) {
			first = start;
			second = end;
		} else {
			first = end;
			second = start;
		}
		int i = first.i + 1;
		for (; i < second.i;) {
			if (!board[i][first.j].equalsIgnoreCase(Constants.spaceBoard)) {
				return false;
			}
			i++;
		}
		return true;
	}
}