package com.company.flipkart.chess.piece;

import com.company.flipkart.chess.Colors;
import com.company.flipkart.chess.Constants;
import com.company.flipkart.chess.Position;

public class Pawn extends AbstractPiece{

	@Override
	public boolean validateMove(String[][] board, Colors color, Position start, Position end){
		return isPawnStraightOneMove(board, color, start, end) || isPawnCrossCaptureMove(color, board, start, end);
	}

	private  boolean isPawnStraightOneMove(String[][] board, Colors color, Position start, Position end) {
		if(!board[end.i][end.j].equalsIgnoreCase(Constants.spaceBoard)) {
			return false;
		}
		if(start.j!=end.j) {
			return false;
		}
		if(color==Colors.WHITE) {
			if(end.i!=start.i+1) {
				return false;
			}
		}else {
			if(end.i!=start.i-1) {
				return false;
			}
		}
		return true;
	}

	private static boolean isPawnCrossCaptureMove(Colors color, String[][] board, Position start, Position end) {
		if(board[end.i][end.j].equalsIgnoreCase(Constants.spaceBoard)) {
			return false;
		}
		if(Math.abs(start.j-end.j)!=1) {
			return false;
		}
		if(color==Colors.WHITE) {
			if(end.i!=start.i+1) {
				return false;
			}
		}else {
			if(end.i!=start.i-1) {
				return false;
			}
		}
		return true;
	}
}