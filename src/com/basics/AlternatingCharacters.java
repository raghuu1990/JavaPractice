package com.basics;

import java.util.Scanner;

public class AlternatingCharacters {
	public static void main(String args[]) {
		Scanner in = new Scanner(System.in);
		int t = in.nextInt();
		in.nextLine();
		String[] str = new String[t];
		int[] result = new int[t];
		for (int i = 0; i <= t; i++) {
			str[i] = in.nextLine();
		}

		for (int i = 0; i < t; i++) {
			String s = str[i];
			int l = s.length();
			for (int j = 1; j < l; j++) {
				if (s.charAt(j) == s.charAt(j - 1)) {
					result[i] = result[i] + 1;
				}
			}
		}

		for (int i = 0; i < t; i++) {
			System.out.println(result[i]);
		}
		in.close();
	}
}
