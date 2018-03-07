package com.codechef.jan2018;

import java.util.Scanner;

public class MaximumScore {
	public static void main(String[] args) {
		Scanner in = new Scanner(System.in);
		int T = in.nextInt();
		long[] result = new long[T];
		for (int i = 0; i < T; i++) {
			int N = in.nextInt();
			int[][] A = new int[N][N];

			for (int j = 0; j < N; j++) {
				for (int k = 0; k < N; k++) {
					A[j][k] = in.nextInt();
				}
			}
			result[i] = maximumScore(A);
		}
		for (int i = 0; i < T; i++) {
			System.out.println(result[i]);
		}
		in.close();
	}

	private static long maximumScore(int[][] a) {
		long sum = 0;
		int lastMax = Integer.MIN_VALUE;

		for (int j = 0; j < a.length; j++) {
			lastMax = Math.max(lastMax, a[a.length - 1][j]);
		}

		sum += lastMax;

		for (int i = a.length - 2; i >= 0; i--) {
			int max = Integer.MIN_VALUE;
			for (int j = 0; j < a.length; j++) {
				if (a[i][j] < lastMax) {
					max = Math.max(max, a[i][j]);
				}
			}
			if (max == Integer.MIN_VALUE) {
				return -1;
			}
			lastMax = max;
			sum += max;
		}
		return sum;
	}
}
