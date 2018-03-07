package com.hackerrank.weekofcode35;

import java.util.Scanner;

public class ThreeDSurfaceArea {

	static int surfaceArea(int[][] A) {
		// For Top And Bottom
		int area = A.length * A[0].length * 2;

		int r = A.length;
		int c = A[0].length;
		for (int i = 0; i <= r; i++) {
			for (int j = 0; j <= c; j++) {
				// Front View
				if (j != c) {
					if (i == 0) {
						area += A[i][j];
					} else if (i == r) {
						area += A[i - 1][j];
					} else {
						area += Math.abs(A[i][j] - A[i - 1][j]);
					}
				}

				// Side View
				if (i != r) {
					if (j == 0) {
						area += A[i][j];
					} else if (j == c) {
						area += A[i][j - 1];
					} else {
						area += Math.abs(A[i][j] - A[i][j - 1]);
					}
				}
			}
		}
		return area;
	}

	public static void main(String[] args) {
		Scanner in = new Scanner(System.in);
		int H = in.nextInt();
		int W = in.nextInt();
		int[][] A = new int[H][W];
		for (int A_i = 0; A_i < H; A_i++) {
			for (int A_j = 0; A_j < W; A_j++) {
				A[A_i][A_j] = in.nextInt();
			}
		}
		int result = surfaceArea(A);
		System.out.println(result);
		in.close();
	}
}
