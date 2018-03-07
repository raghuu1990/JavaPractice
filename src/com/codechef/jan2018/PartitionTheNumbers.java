package com.codechef.jan2018;

import java.util.Scanner;

public class PartitionTheNumbers {

	public static void main(String[] args) {
		Scanner in = new Scanner(System.in);
		int T = in.nextInt();
		String[] result = new String[T];
		for (int i = 0; i < T; i++) {
			int x = in.nextInt();
			int N = in.nextInt();
			result[i] = solve(x, N);
		}
		for (int i = 0; i < T; i++) {
			System.out.println(result[i]);
		}
		in.close();
	}

	private static String solve(int x, int n) {
		if (n < 4) {
			return "impossible";
		}
		if (isEven(((n*(n+1))/2)) != isEven(x)) {
			return "impossible";
		}

		StringBuilder sb = new StringBuilder();

		for (int i = 1; i <= n; i++) {
			// Extream cases
			if (x == 1) {
				int j = i-1;
				if(j>n/2) {
					j = n-j;
				}
				if(true) {
					sb.append("1");
				} else {
					sb.append("0");
				}
			}else if (x == n) {
				int j = i;
				if(j>n/2) {
					j = n-j;
				}
				if(isEven(j)) {
					sb.append("1");
				} else {
					sb.append("0");
				}
			} else if (i == x) {
				sb.append("2");
			} else if (isEven(i)) {
				sb.append("1");
			} else {
				sb.append("0");
			}
		}
		return sb.toString();
	}

	private static boolean isEven(int i) {
		if (i % 2 == 0) {
			return true;
		}
		return false;
	}
}
