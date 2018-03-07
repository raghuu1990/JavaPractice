package com.company.flipkart.chess;

import java.util.Scanner;

/*
Input :

WP 12 22
BP 60 64
BH 71 50
WQ 03 30

*/
public class Main {
	static String[][] board;
	public static void main(String[] args) {
		Scanner in = new Scanner(System.in);
		initialiseBoard();
		printBoard();
		int count = 1;
		
		while (in.hasNextLine()) {
			String inputString = in.nextLine();
			if(!inputString.isEmpty()) {
				String[] input = inputString.split(" ");
				boolean result = MoveValidator.isValidMove(
						board,
						PieceType.getPieceType(input[0].charAt(1) + ""),
						Colors.getColorType(input[0].charAt(0) + ""),
						new Position(Integer.parseInt(input[1].charAt(0) + ""), Integer.parseInt(input[1].charAt(1) + "")),
						new Position(Integer.parseInt(input[2].charAt(0) + ""), Integer.parseInt(input[2].charAt(1) + "")));
				System.out.println();
				System.out.print("Move : " + count +"  ");
				if (result) {
					System.out.print(inputString + " [Valid]");
					System.out.println();
					printBoard();
				} else {
					System.out.print(inputString + " [Invalid]");
					System.out.println();
					System.out.println();
					System.out.println(Constants.spacePrint+"Error Invalid move");
				}
				count++;
			}
		}
		in.close();
	}

	public static void initialiseBoard() {
		board = new String[8][8];
		for (int i = 0; i < board.length; i++) {
			for (int j = 0; j < board[0].length; j++) {
				board[i][j]= "--";
				if (i == 0 || i == 1) {
					board[i][j] = "W";
				} else if (i == 6 || i == 7) {
					board[i][j] = "B";
				}
				if ((i ==0 || i==7)&& (j == 0 || j == 7)) {
					board[i][j] += "R";
				}

				if ((i ==0 || i==7)&& (j == 1 || j == 6)) {
					board[i][j] += "H";
				}

				if ((i ==0 || i==7)&& (j == 2 || j == 5)) {
					board[i][j] += "B";
				}
				
				if (i ==1 || i==6) {
					board[i][j] += "P";
				}

				if (i == 0 && j == 3) {
					board[i][j] += "Q";
				}

				if (i == 0 && j == 4) {
					board[i][j] += "K";
				}
				
				if (i == 7 && j == 3) {
					board[i][j] += "Q";
				}

				if (i == 7 && j == 4) {
					board[i][j] += "K";
				}
			}
		}
	}

	public static void printBoard() {
		System.out.println();
		for (int i = 0; i < board.length; i++) {
			System.out.print(Constants.spacePrint);
			for (int j = 0; j < board[0].length; j++) {
				System.out.print(board[i][j] + " ");
			}
			System.out.println();
		}
	}
}