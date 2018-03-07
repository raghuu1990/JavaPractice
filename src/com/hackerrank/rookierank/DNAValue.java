package com.hackerrank.rookierank;

import java.util.Arrays;
import java.util.Scanner;

public class DNAValue {
	static int[] dnaValue(String str) {
		int n = str.length();
		int[] result = new int[n];
		Arrays.fill(result, 0);
		for (int i = 0; i < result.length; i++) {
			if (str.charAt(i) == str.charAt(0)) {
				int j = Math.min(i + 1, n - i);
				for (; j > 0; j--) {
					String str1 = str.substring(0, j);
					String str2 = str.substring(i - j + 1, i + 1);
					String str3 = str.substring(i, i + j);
					if (str1.equalsIgnoreCase(str2) && str1.equalsIgnoreCase(str3)) {
						result[i] = j;
						break;
					}
				}
			}

		}
		return result;
	}

	public static void main(String[] args) {
		Scanner in = new Scanner(System.in);
		String s = in.next();
		int[] result = dnaValue(s);
		for (int i = 0; i < result.length; i++) {
			System.out.print(result[i] + (i != result.length - 1 ? " " : ""));
		}
		System.out.println("");

		in.close();
	}
}