package com.hackerrank.weekofcode35;

import java.util.Scanner;

// https://www.hackerrank.com/contests/w35/challenges/matrix-land/problem

public class MatrixLand {

	private static long matrixLand(int[][] matrix) {
		long maxSum = Integer.MIN_VALUE;
		long[][] newMatrix = new long[matrix.length][matrix[0].length];
		for (int i = matrix.length - 1; i >= 0; i--) {
			int[][] bestRight = new int[2][matrix[0].length];
			int[][] bestLeft = new int[2][matrix[0].length];

			setMaxSubSequenceSumRight(matrix, newMatrix, i, bestRight);
			setMaxSubSequenceSumLeft(matrix, newMatrix, i, bestLeft);

			for (int j = 0; j < matrix[0].length; j++) {
				newMatrix[i][j] = getMaxChild(matrix, newMatrix, i, bestLeft[0][j], bestRight[0][j], bestLeft[1][j], bestRight[1][j]);
				if (i == 0) {
					maxSum = Math.max(maxSum, newMatrix[0][j]);
				}
			}
		}
		return maxSum;
	}

	private static long getMaxChild(int[][] matrix, long[][] newMatrix, int row, int a1, int a2, int b1, int b2) {
		long sum = 0;
		long max = Integer.MIN_VALUE;

		for (int m = a1; m <= a2; m++) {
			sum += matrix[row][m];
			if (row != matrix.length - 1 && max < newMatrix[row + 1][m]) {
				max = newMatrix[row + 1][m];
			}
		}

		if (row == matrix.length - 1) {
			return sum;
		}

		long total1 = Integer.MIN_VALUE;

		long sum1 = 0;
		long max1 = Integer.MIN_VALUE;
		if (b1 < a1) {
			int a = Math.min(a1, b1);
			int b = Math.max(a1, b1);

			for (int m = b; m < a; m--) {
				sum1 += matrix[row][m];
				if (row != matrix.length - 1) {
					max1 = newMatrix[row + 1][m];
				}
				total1 = Math.max(total1, sum1 + max1);
			}
		}

		long total2 = Integer.MIN_VALUE;

		long sum2 = 0;
		long max2 = Integer.MIN_VALUE;

		if (b2 > b1) {
			int a = Math.min(a2, b2);
			int b = Math.max(a2, b2);
			for (int m = a + 1; m <= b; m++) {
				sum2 += matrix[row][m];
				if (row != matrix.length - 1) {
					max2 = newMatrix[row + 1][m];
				}
				total2 = Math.max(total2, sum2 + max2);
			}
		}
		return sum + Math.max(max, Math.max(total1, total2));
	}

	private static void setMaxSubSequenceSumRight(int[][] matrix1, long[][] matrix2, int row, int[][] best) {
		long tempMax = 0;
		int index = matrix1[0].length - 1;

		long tempMax1 = 0;
		int index1 = matrix1[0].length - 1;

		for (int j = matrix1[0].length - 1; j >= 0; j--) {
			if (j < (matrix1[0].length - 1)) {
				tempMax += matrix1[row][j + 1];
				if (tempMax < 0) {
					tempMax = 0;
					index = j;
				}
				best[0][j] = index;
			} else {
				best[0][j] = index;
			}

			if (j < (matrix1[0].length - 1)) {
				if(row != matrix1.length-1) {
					tempMax1 += matrix1[row][j + 1] + matrix2[row + 1][j + 1];
				}else {
					tempMax1 += matrix1[row][j + 1];
				}
				if (tempMax1 < 0) {
					tempMax1 = 0;
					index1 = j;
				}
				best[1][j] = index1;
			} else {
				best[1][j] = index1;
			}
		}
	}

	private static void setMaxSubSequenceSumLeft(int[][] matrix1, long[][] matrix2, int row, int[][] best) {
		long tempMax = 0;
		int index = 0;

		long tempMax1 = 0;
		int index1 = 0;

		for (int j = 0; j < matrix1[0].length; j++) {
			if (j != 0) {
				tempMax += matrix1[row][j - 1];
				if (tempMax < 0) {
					tempMax = 0;
					index = j;
				}
				best[0][j] = index;
			} else {
				best[0][j] = index;
			}

			if (j != 0) {
				if(row != matrix1.length-1) {
					tempMax1 += matrix1[row][j - 1] + matrix2[row + 1][j - 1];
				}else {
					tempMax1 += matrix1[row][j - 1];
				}
				if (tempMax1 < 0) {
					tempMax1 = 0;
					index1 = j;
				}
				best[1][j] = index1;
			} else {
				best[1][j] = index1;
			}
		}
	}

	public static void main(String[] args) {
		Scanner in = new Scanner(System.in);
		int n = in.nextInt();
		int m = in.nextInt();
		int[][] A = new int[n][m];
		for (int A_i = 0; A_i < n; A_i++) {
			for (int A_j = 0; A_j < m; A_j++) {
				A[A_i][A_j] = in.nextInt();
			}
		}
		long result = matrixLand(A);
		System.out.println(result);
		in.close();
	}
}