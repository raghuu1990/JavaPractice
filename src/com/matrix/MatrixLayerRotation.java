package com.matrix;

import java.util.Scanner;

// https://www.hackerrank.com/challenges/matrix-rotation-algo/problem

// TODO :

public class MatrixLayerRotation {
	public static void main(String[] args) {
		Scanner in = new Scanner(System.in);
		int m = in.nextInt();
		int n = in.nextInt();
		int r = in.nextInt();
		int[][] matrix = new int[m][n];
		for (int i = 0; i < m; i++) {
			for (int j = 0; j < n; j++) {
				matrix[i][j] = in.nextInt();
			}
		}
		matrixRotation(matrix, r);
		in.close();
	}

	static void matrixRotation(int[][] matrix, int r) {
		int ROW = matrix.length;
		int COL = matrix[0].length;
		int temp[] = new int[2*ROW+2*COL];
		
		int i;
		for (i = 0; i < COL; i++) {
			temp[i] = matrix[0][i];
		}
		
		for (; i < ROW; i++) {
			temp[i] = matrix[COL-1][i];
		}

		for (int j = 0; j < COL; j++) {
			matrix[0][j] = matrix[0][j];
		}

		for (int i1 = 0; i1 < ROW; i1++) {
			for (int j = 0; j < COL; j++) {

			}
		}
	}
}
