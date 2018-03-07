package com.hackerrank.weekofcode36;

import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.Scanner;

//  https://www.hackerrank.com/contests/w36/challenges/ways-to-give-a-check

public class WaysToGiveACheck {
	private static char [] playersType = {'R', 'N', 'B', 'Q', 'K', 'P'};
	private static HashMap<Character, Integer> map = new HashMap<Character, Integer>();
	
	public static void main(String[] args) {
		for (int i = 0; i < 6; i++) {
			map.put(playersType[i],i);
		}
		Scanner in = new Scanner(System.in);
		int t = in.nextInt();
		for (int i = 0; i < t; i++) {
			char[][] board = new char[8][8];
			for (int j = 0; j < 8; j++) {
				String str = in.next();
				for (int k = 0; k < 8; k++) {
					board[j][k] = str.charAt(k);
				}
			}
			int result = waysToGiveACheck(board);
			System.out.println(result);
		}
		in.close();
	}

	private static int waysToGiveACheck(char[][] board) {
		int result = 0;
		Position whitePawn = getPawnPosition(board);
		Position blackKing = getBlackKingPositions(board);
		if (blackKing == null || whitePawn==null) {
			return 0;
		} else {
			ArrayList<Position> blockers = getBlockers(board);
			ArrayList<Position> blackPlayers = getBlackPlayers(board);
			blockers.remove(blackKing);
			blockers.remove(whitePawn);
			blackPlayers.remove(whitePawn);
			if(isHidden(blackPlayers, blackKing, blockers, whitePawn)) {
				result+=4;
				return result;
			}
			for (int i = 0; i < 4; i++) {
				int freq = Collections.frequency(blockers, new Position(playersType[i]));
				if(freq==2 || (freq==1 && playersType[i]=='Q')) {
					continue;
				}
				if(freq==1 && playersType[i]=='B') {
					if ((whitePawn.col) % 2 == 0 && blockers.contains(new Position(playersType[i], Color.WHITE))) { // white
						continue;
					}else if ((whitePawn.col) % 2 == 1 && blockers.contains(new Position(playersType[i], Color.BLACK))) { // black
						continue;
					}
				}
				if (isUnSafe(blackKing, new Position(whitePawn.row - 1, whitePawn.col, playersType[i]), PlayerType.values()[i], blockers)) {
					result++;
				}
			}
		}
		return result;
	}
	
	private static boolean isHidden(ArrayList<Position> blackPlayers, Position blackKing, ArrayList<Position> blockers, Position whitePawn){
		blockers.add(new Position(whitePawn.row-1, whitePawn.col));
		for (Position killer : blackPlayers) {
			if(isUnSafe(blackKing, killer,  PlayerType.values()[map.get(killer.playerType)], blockers)) {
				return true;
			}
		}
		blockers.remove(new Position(whitePawn.row-1, whitePawn.col));
		return false;
	}

	private static ArrayList<Position> getBlackPlayers(char[][] board) {
		ArrayList<Position> list = new ArrayList<Position>();
		for (int i = 0; i < 8; i++) {
			for (int j = 0; j < 8; j++) {
				if (board[i][j] != '#' && board[i][j]<91) {
					list.add(new Position(i, j, board[i][j]));
				}
			}
		}
		return list;
	}

	private static ArrayList<Position> getBlockers(char[][] board) {
		ArrayList<Position> list = new ArrayList<Position>();
		for (int i = 0; i < 8; i++) {
			for (int j = 0; j < 8; j++) {
				if (board[i][j] != '#') {
					list.add(new Position(i, j, board[i][j]));
				}
			}
		}
		return list;
	}

	private static Position getBlackKingPositions(char[][] board) {
		for (int i = 0; i < 8; i++) {
			for (int j = 0; j < 8; j++) {
				if (board[i][j] == 'k') {
					return new Position(i, j, board[i][j]);
				}
			}
		}
		return null;
	}

	private static Position getPawnPosition(char[][] board) {
		for (int i = 0; i < 8; i++) {
			if (board[1][i] == 'P' && board[0][i]=='#') {
				return new Position(1, i, board[1][i]);
			}
		}
		return null;
	}

	private static boolean isUnSafe(Position kingPosition, Position playerPosition, PlayerType playerType, ArrayList<Position> blockers) {
		if (playerType == PlayerType.ROOK) {
			if (isUnSafeStraightCheck(kingPosition, playerPosition, blockers)) {
				return true;
			}
		} else if (playerType == PlayerType.KNIGHT) {
			if (isUnSafeTowAndHalfCheck(kingPosition, playerPosition)) {
				return true;
			}
		} else if (playerType == PlayerType.BISHOP) {
			if (isUnSafeCrossCheck(kingPosition, playerPosition, blockers)) {
				return true;
			}
		} else if (playerType == PlayerType.QUEEN) {
			if (isUnSafeStraightCheck(kingPosition, playerPosition, blockers)) {
				return true;
			}
			if (isUnSafeCrossCheck(kingPosition, playerPosition, blockers)) {
				return true;
			}
		}else if (playerType == PlayerType.PAWN) {
			if (isUnSafeStraightPawnCheck(kingPosition, playerPosition, blockers)) {
				return true;
			}
			if (isUnSafeCrossPawnCheck(kingPosition, playerPosition, blockers)) {
				return true;
			}
		}else if (playerType == PlayerType.KING) {
			if (isUnSafeKingCheck(kingPosition, playerPosition, blockers)) {
				return true;
			}
		}
		return false;
	}

	private static boolean isUnSafeKingCheck(Position king, Position player, ArrayList<Position> blockers) {
		if (Math.abs(king.row-player.row)<=1 && Math.abs(king.col-player.col)<=1) {
			return true;
		}
		return false;
	}

	private static boolean isUnSafeStraightPawnCheck(Position king, Position player, ArrayList<Position> blockers) {
		// 2 steps
		if (player.row==6 && king.row==4 && king.col == player.col) {
			for (Position blocker : blockers) {
				if (king.col == blocker.col && blocker.row ==3) {
					return false;
				}
			}
			return true;
		}
		// one step
		if (king.row+1==player.row && Math.abs(king.col-player.col)<=1) {
			return true;
		}
		return false;
	}

	private static boolean isUnSafeCrossPawnCheck(Position kingPosition, Position playerPosition, ArrayList<Position> blockers) {
		// King in Right
		if (kingPosition.row+1 == playerPosition.row && Math.abs(kingPosition.col - playerPosition.col) == 1) {
			return true;
		}
		return false;
	}

	private static boolean isUnSafeStraightCheck(Position king, Position player, ArrayList<Position> blockers) {
		// Vertical
		if (king.col == player.col) {
			for (Position blocker : blockers) {
				if (king.col == blocker.col && player.row < blocker.row && king.row > blocker.row) {
					return false;
				}
			}
			return true;
		}
		// Horizontal
		if (king.row == player.row) {
			for (Position blocker : blockers) {
				if (king.row == blocker.row && ((player.col < blocker.col && blocker.col < king.col) || (player.col > blocker.col && blocker.col > king.col))) {
					return false;
				}
			}
			return true;
		}
		return false;
	}

	private static boolean isUnSafeCrossCheck(Position kingPosition, Position playerPosition, ArrayList<Position> blockers) {
		// King in Right
		if (kingPosition.col - playerPosition.col > 0
				&& (kingPosition.col - playerPosition.col) == (kingPosition.row - playerPosition.row)) {
			for (Position blocker : blockers) {
				if (blocker.col - playerPosition.col > 0
						&& (blocker.col - playerPosition.col) == (blocker.row - playerPosition.row)) {
					return false;
				}
			}
			return true;
		}
		// King in Left
		if (playerPosition.col - kingPosition.col > 0
				&& (playerPosition.col - kingPosition.col) == (kingPosition.row - playerPosition.row)) {
			for (Position blocker : blockers) {
				if (playerPosition.col - blocker.col > 0
						&& (playerPosition.col - blocker.col) == (blocker.row - playerPosition.row)) {
					return false;
				}
			}
			return true;
		}

		return false;
	}

	private static boolean isUnSafeTowAndHalfCheck(Position kingPosition, Position playerPosition) {
		if (kingPosition.row == playerPosition.row + 2 && kingPosition.col == playerPosition.col - 1) {
			return true;
		}
		if (kingPosition.row == playerPosition.row + 2 && kingPosition.col == playerPosition.col + 1) {
			return true;
		}

		if (kingPosition.row == playerPosition.row + 1 && kingPosition.col == playerPosition.col + 2) {
			return true;
		}

		if (kingPosition.row == playerPosition.row + 1 && kingPosition.col == playerPosition.col - 2) {
			return true;
		}
		return false;
	}
}

enum PlayerType {
	ROOK, KNIGHT, BISHOP, QUEEN, KING, PAWN
}

enum Color {
	BLACK, WHITE
}

class Position {
	int col;
	int row;
	Character playerType;
	Color positionColor;

	Position(int row, int col) {
		this.row = row;
		this.col = col;
	}
	
	Position(Character playerType) {
		this.playerType = playerType;
	}

	Position(Character playerType, Color positionColor) {
		this.playerType = playerType;
		this.positionColor = positionColor;
	}
	
	Position(int row, int col, Character playerType) {
		this.row = row;
		this.col = col;
		this.playerType = playerType;
		this.positionColor = getPositionColor();
	}

	public Color getPositionColor() {
		if ((this.col + this.row) % 2 == 0) {
			return Color.WHITE;
		}
		return Color.BLACK;
	}

	@Override
	public boolean equals(Object obj) {
		if(((Position) obj).playerType == null) {
			return this.col == ((Position) obj).col && this.row == ((Position) obj).row;
		} else if(((Position) obj).positionColor !=null){
			return this.playerType == ((Position) obj).playerType && this.positionColor == ((Position) obj).positionColor;
		} else {
			return this.playerType == ((Position) obj).playerType;
		}
	}
}