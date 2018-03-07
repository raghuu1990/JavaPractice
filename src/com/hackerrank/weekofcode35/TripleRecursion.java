package com.hackerrank.weekofcode35;

import java.util.Scanner;

public class TripleRecursion {
	public static void main(String[] args) {
		Scanner in = new Scanner(System.in);
		int n = in.nextInt();
		int m = in.nextInt();
		int k = in.nextInt();
		tripleRecursion(n, m, k);
		in.close();
	}

	public static void tripleRecursion(int n, int m, int k) {
		int[][] matrix = new int[n][n];
		for (int i = 0; i < matrix.length; i++) {
			for (int j = 0; j < matrix[0].length; j++) {
				if (i == 0 && j == 0) {
					matrix[i][j] = m;
				} else if (i == j) {
					matrix[i][j] = matrix[i - 1][j - 1] + k;
				} else if (i > j) {
					matrix[i][j] = matrix[i - 1][j] - 1;
				} else if (j > i) {
					matrix[i][j] = matrix[i][j - 1] - 1;
				}
			}
		}
		printMatrix(matrix);
	}

	public static void printMatrix(int[][] matrix) {
		for (int i = 0; i < matrix.length; i++) {
			for (int j = 0; j < matrix[0].length; j++) {
				System.out.print(matrix[i][j]);
				if (j < (matrix[0].length - 1)) {
					System.out.print(" ");
				}
			}
			if (i < (matrix.length - 1)) {
				System.out.println();
			}
		}
	}
}