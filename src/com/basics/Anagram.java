package com.basics;

import java.util.Scanner;

public class Anagram {
	public static void main(String[] args) {
		Scanner in = new Scanner(System.in);
		int t = in.nextInt();
		in.nextLine();
		String[] str = new String[t];
		for (int i = 0; i < t; i++) {
			str[i] = in.nextLine();
		}

		for (int i = 0; i < t; i++) {
			String tempStr = str[i];
			int l = tempStr.length();
			if (l % 2 == 1) {
				System.out.println("-1");
				continue;
			}
			int[] hash = new int[256];
			for (int j = 0; j < l / 2; j++) {
				int c1 = tempStr.charAt(j);
				int c2 = tempStr.charAt(l - j - 1);
				hash[c1] = hash[c1] + 1;
				hash[c2] = hash[c2] - 1;
			}

			int change = 0;
			for (int j = 'a'; j <= 'z'; j++) {
				change += absolute(hash[j]);
			}
			System.out.println(change / 2);
		}
		in.close();
	}

	public static int absolute(int a) {
		if (a < 0) {
			return -1 * a;
		}
		return a;
	}
}
