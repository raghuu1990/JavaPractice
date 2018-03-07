package com.hackerrank.weekofcode35;

import java.util.Arrays;
import java.util.Scanner;

// https://www.hackerrank.com/contests/w35/challenges/matrix-land/problem

public class MatrixLand2 {
	static final long INF = Long.MAX_VALUE;

	public static long matrixLand(int[][] matrix) {
		int row = matrix.length;
		int col = matrix[0].length;

		int total = 0;
		if (col == 1) {
			for (int i = 0; i < row; i++) {
				total += matrix[i][0];
			}
			return total;
		}

		long[] finalRow = new long[col];

		long[] pp = new long[col];
		long[] qq = new long[col];
		long[] leftMaxSum = new long[col];
		long[] rightMaxSum = new long[col];

		for (int i = 0; i < row; i++) {
			long sum = 0;
			for (int j = 0; j < col; j++) {
				leftMaxSum[j] = sum = Math.max(sum + matrix[i][j], 0);
			}

			sum = 0;
			for (int j = col - 1; j >= 0; j--) {
				rightMaxSum[j] = sum = Math.max(sum + matrix[i][j], 0);
			}

			for (int j = col - 1; j >= 0; j--) {
				pp[j] = (j == col - 1 ? 0 : pp[j + 1]) + matrix[i][j];
			}

			pp[0] += finalRow[0];
			for (int j = 1; j < col; j++) {
				pp[j] = Math.max(pp[j - 1], finalRow[j] + pp[j] + leftMaxSum[j - 1]);
			}

			for (int j = 0; j < col; j++) {
				qq[j] = (j == 0 ? 0 : qq[j - 1]) + matrix[i][j];
			}

			qq[col - 1] += finalRow[col - 1];
			for (int j = col - 2; j >= 0; j--) {
				qq[j] = Math.max(qq[j + 1], finalRow[j] + qq[j] + rightMaxSum[j + 1]);
			}

			Arrays.fill(finalRow, -INF);

			sum = 0;
			for (int j = col - 1; j >= 0; j--) {
				finalRow[j] = Math.max(finalRow[j], pp[j] - sum + (j == col - 1 ? 0 : rightMaxSum[j + 1]));
				sum += matrix[i][j];
			}

			sum = 0;
			for (int j = 0; j < col; j++) {
				finalRow[j] = Math.max(finalRow[j], qq[j] - sum + (j == 0 ? 0 : leftMaxSum[j - 1]));
				sum += matrix[i][j];
			}
		}

		long max = Long.MIN_VALUE;
		for (int j = 0; j < col; j++) {
			max = Math.max(max, finalRow[j]);
		}
		return max;
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