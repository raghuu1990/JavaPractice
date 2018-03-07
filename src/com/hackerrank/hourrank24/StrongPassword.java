package com.hackerrank.hourrank24;

import java.util.HashSet;
import java.util.Scanner;
import java.util.Set;

// https://www.hackerrank.com/contests/hourrank-24/challenges/strong-password

/*
numbers = "0123456789"
lower_case = "abcdefghijklmnopqrstuvwxyz"
upper_case = "ABCDEFGHIJKLMNOPQRSTUVWXYZ"
special_characters = "!@#$%^&*()-+"
*/
public class StrongPassword {
	public static Set<Character> special_characters = new HashSet<Character>();

	public static void main(String[] args) {

		char [] sc = "!@#$%^&*()-+".toCharArray();
		for (int i = 0; i < sc.length; i++) {
			special_characters.add(sc[i]);
		}

		Scanner in = new Scanner(System.in);
		int n = in.nextInt();
		String password = in.next();
		int answer = minimumNumber(n, password);
		System.out.println(answer);
		in.close();
	}

	public static int minimumNumber(int n, String password) {
		int num = 0;
		boolean isSpecialCharacter = isSpecialCharacter(password);
		boolean isUpperCase = isUpperCase(password);
		boolean isLowerCase = isLowerCase(password);
		boolean isNumbers = isNumbers(password);

		if (!isSpecialCharacter) {
			num++;
		}

		if (!isUpperCase) {
			num++;
		}

		if (!isLowerCase) {
			num++;
		}

		if (!isNumbers) {
			num++;
		}

		if (n + num < 6) {
			return 6 - (n);
		}
		return num;
	}

	private static boolean isSpecialCharacter(String str) {
		for (int i = 0; i < str.length(); i++) {
			if (special_characters.contains(str.charAt(i))) {
				return true;
			}
		}
		return false;
	}

	private static boolean isUpperCase(String str) {
		for (int i = 0; i < str.length(); i++) {
			char c = str.charAt(i);
			if (c < 91 && c > 64) {
				return true;
			}
		}
		return false;
	}

	private static boolean isLowerCase(String str) {
		for (int i = 0; i < str.length(); i++) {
			char c = str.charAt(i);
			if (c < 123 && c > 96) {
				return true;
			}
		}
		return false;
	}

	private static boolean isNumbers(String str) {
		for (int i = 0; i < str.length(); i++) {
			char c = str.charAt(i);
			if (c < 58 && c > 47) {
				return true;
			}
		}
		return false;
	}
}
