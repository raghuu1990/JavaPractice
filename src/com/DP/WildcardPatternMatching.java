package com.DP;

import java.util.Arrays;

public class WildcardPatternMatching {

	public static void main(String args[]) {
		String input = "baaabab";
		String pattern = "*****ba*****ab";
		// String pattern = "ba*****ab";
		// String pattern = "ba*ab";
		// String pattern = "a*ab";
		// String pattern = "a*****ab";
		// String pattern = "*a*****ab";
		// String pattern = "ba*ab****";
		// String pattern = "****";
		// String pattern = "*";
		// String pattern = "aa?ab";
		// String pattern = "b*b";
		// String pattern = "a*a";
		// String pattern = "baaabab";
		// String pattern = "?baaabab";
		// String pattern = "*baaaba*";

		if (strmatch(input, pattern, input.length(), pattern.length())) {
			System.out.println("Yes");
		} else {
			System.out.println("No");
		}
	}

	private static boolean strmatch(String input, String pattern, int n, int m) {
		if (m == 0) {
			return (n == 0);
		}

		boolean[][] map = new boolean[n + 1][m + 1];
		for (int i = 0; i < n + 1; i++) {
			Arrays.fill(map[i], false);
		}

		map[0][0] = true;

		for (int j = 1; j <= m; j++) {
			if (pattern.charAt(j - 1) == '*') {
				map[0][j] = map[0][j - 1];
			} else {
				break;
			}
		}

		for (int i = 1; i <= n; i++) {
			for (int j = 1; j <= m; j++) {
				if (pattern.charAt(j - 1) == '*') {
					map[i][j] = map[i][j - 1] || map[i - 1][j];
				} else if (input.charAt(i - 1) == pattern.charAt(j - 1) || pattern.charAt(j - 1) == '?') {
					map[i][j] = map[i-1][j - 1];
				} else {
					map[i][j] = false;
				}
			}
		}
		return map[n][m];
	}
}