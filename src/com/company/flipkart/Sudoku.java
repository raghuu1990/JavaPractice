package com.company.flipkart;

import java.util.Scanner;

public class Sudoku {
	public static void main(String args[]) {
		Scanner in = new Scanner(System.in);
		int T = in.nextInt();
		for (int i = 0; i < T; i++) {
			int[][] sudoku = new int[9][9];
			for (int j = 0; j < 9; j++) {
				for (int k = 0; k < 9; k++) {
					sudoku[j][k] = in.nextInt();
				}
			}
			if (solve(0, 0, sudoku)) {
				print(sudoku);
				System.out.println("");
			} else {
				System.out.println("");
			}
		}
		in.close();
	}

	static boolean solve(int i, int j, int[][] sudoku) {
		if (i == 9) {
			i = 0;
			if (++j == 9){
				return true;
			}
		}
		// skip filled cells
		if (sudoku[i][j] != 0) {
			return solve(i + 1, j, sudoku);
		}

		for (int val = 1; val < 10; val++) {
			if (legal(i, j, val, sudoku)) {
				sudoku[i][j] = val;
				if (solve(i + 1, j, sudoku)) {
					return true;
				}
			}
		}
		sudoku[i][j] = 0; // reset on backtrack
		return false;
	}

	static boolean legal(int i, int j, int val, int[][] sudoku) {
		for (int k = 0; k < 9; k++) {
			if (val == sudoku[k][j]) {
				return false;
			}
		}
		for (int k = 0; k < 9; k++) {
			if (val == sudoku[i][k])
				return false;
		}
		int boxRowOffset = (i / 3) * 3;
		int boxColOffset = (j / 3) * 3;

		for (int k = 0; k < 3; k++) {
			for (int m = 0; m < 3; m++) {
				if (val == sudoku[boxRowOffset + k][boxColOffset + m]) {
					return false;
				}
			}
		}

		return true;
	}

	private static void print(int[][] sudoku) {
		for (int i = 0; i < 9; i++) {
			for (int j = 0; j < 9; j++) {
				System.out.print(sudoku[i][j]);
				if (j != 8) {
					System.out.print(' ');
				}
			}
			System.out.println();
		}
	}

	static int[][] parseProblem(String[] args) {
		int[][] problem = new int[9][9]; // default 0 vals
		for (int n = 0; n < args.length; ++n) {
			int i = Integer.parseInt(args[n].substring(0, 1));
			int j = Integer.parseInt(args[n].substring(1, 2));
			int val = Integer.parseInt(args[n].substring(2, 3));
			problem[i][j] = val;
		}
		return problem;
	}

	private static void printMatrix(int[][] sudoku) {
		for (int i = 0; i < 9; i++) {
			if (i % 3 == 0) {
				System.out.println(" ----------------------- ");
			}
			for (int j = 0; j < 9; j++) {
				if (j % 3 == 0) {
					System.out.print("| ");
				}
				System.out.print(sudoku[i][j] == 0 ? " " : sudoku[i][j]);
				System.out.print(' ');
			}
			System.out.println("|");
		}
		System.out.println(" ----------------------- ");
	}

	
}
