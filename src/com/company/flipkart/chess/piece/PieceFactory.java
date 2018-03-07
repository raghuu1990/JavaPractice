package com.company.flipkart.chess.piece;

import com.company.flipkart.chess.PieceType;

public class PieceFactory {
	public static IPiece getPiece(PieceType pieceType) {
		if(pieceType==PieceType.ROOK) {
			return new Rook();
		}else if(pieceType==PieceType.BISHOP) {
			return new Bishop();
		}else if(pieceType==PieceType.QUEEN) {
			return new Queen();
		}else if(pieceType==PieceType.KING) {
			return new King();
		}else if(pieceType==PieceType.HORSE) {
			return new Horse();
		}
		return new Pawn();
	}
}