package com.company.flipkart.chess;

import com.company.flipkart.chess.piece.IPiece;
import com.company.flipkart.chess.piece.PieceFactory;

public class MoveValidator {
	public static boolean isValidMove(String[][] board, PieceType pieceType, Colors color, Position start, Position end) {
		if(!isInputPieceCorrect(board, pieceType, color, start)) {
			return false;
		}

		if(!isTargetValid(board, color, start, end)) {
			return false;
		}
		
		IPiece piece = PieceFactory.getPiece(pieceType);
		if(!piece.validateMove(board, color, start, end)) {
			return false;
		}

		executeMove(board, pieceType, color, start, end);
		return true;
	}
	
	private static boolean isTargetValid(String[][] board, Colors color, Position start, Position end) {
		if(end.i>7 || end.i<0 || end.j>7 || end.j<0) {
			return false;
		}
		if(start.i == end.i && start.j == end.j) {
			return false;
		}
		
		String target =  board[end.i][end.j];
		if(!target.equalsIgnoreCase(Constants.spaceBoard)) {
			//  target not empty and own color
			if(color==Colors.getColorType(target.charAt(0)+"")) {
				return false;
			}
		}
		return true;
	}

	public static void executeMove(String[][] board, PieceType piece, Colors color, Position start, Position end) {
		board[end.i][end.j] = board[start.i][start.j];
		board[start.i][start.j] = Constants.spaceBoard; 
	}

	private static boolean isInputPieceCorrect(String[][] board, PieceType playerType, Colors color, Position start) {
		String playerString =  board[start.i][start.j];
		if(playerType==PieceType.getPieceType(playerString.charAt(0)+"")) {
			return false;
		}
		if(color==Colors.getColorType(playerString.charAt(1)+"")) {
			return false;
		}
		return true;
	}
}