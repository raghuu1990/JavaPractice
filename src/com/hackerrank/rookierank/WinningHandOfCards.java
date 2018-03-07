package com.hackerrank.rookierank;

import java.util.Scanner;

public class WinningHandOfCards {
	static int winningHands(int M, int X, int[] arr) {
		int dp[][] = new int[arr.length + 1][M];
		for (int i = 0; i < arr.length; i++) {
			for (int m = 0; m < M; m++) {
				int x = (int) (((long) arr[i] * m) % M);
				dp[i + 1][x] += dp[i][m];
				dp[i + 1][m] += dp[i][m];
			}
			dp[i + 1][arr[i] % M] += 1;
		}
		return dp[arr.length][X];
	}

	public static void main(String[] args) {
		Scanner in = new Scanner(System.in);
		int n = in.nextInt();
		int m = in.nextInt();
		int x = in.nextInt();
		int[] a = new int[n];
		for (int a_i = 0; a_i < n; a_i++) {
			a[a_i] = in.nextInt();
		}
		int result = winningHands(m, x, a);
		System.out.println(result);
		in.close();
	}
}