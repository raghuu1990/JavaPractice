package com.stack;

import java.util.Scanner;

import java.util.Stack;
// https://www.hackerrank.com/challenges/ctci-balanced-brackets

public class BalancedBrackets {
	public static void main(String[] args) {
		Scanner in = new Scanner(System.in);
		int t = in.nextInt();
		String input[] = new String[t];
		for (int i = 0; i < t; i++) {
			input[i] = in.next();
		}
		for (int j = 0; j < input.length; j++) {
			System.out.println(isBalance(input[j]));
		}
		in.close();
	}

	private static String isBalance(String str) {
		if (str == null || str.equalsIgnoreCase("")) {
			return "YES";
		}
		Stack<Character> stack = new Stack<Character>();
		char[] chars = str.toCharArray();

		for (int i = 0; i < chars.length; i++) {
			char c = chars[i];
			if (isOpen(c)) {
				stack.add(c);
			} else if (isClose(c)) {
				if (stack.isEmpty()) {
					return "NO";
				}
				char ch = (char) stack.pop();
				if (!isSame(ch, c)) {
					return "NO";
				}
			}
		}
		if (stack.isEmpty()) {
			return "YES";
		}
		return "NO";
	}

	private static boolean isOpen(char c) {
		if (c == '[' || c == '{' || c == '(') {
			return true;
		}
		return false;
	}

	private static boolean isClose(char c) {
		if (c == ']' || c == '}' || c == ')') {
			return true;
		}
		return false;
	}

	private static boolean isSame(char char1, char char2) {
		if ((char1 == '[' && char2 == ']') || (char1 == '(' && char2 == ')') || (char1 == '{' && char2 == '}')) {
			return true;
		}
		return false;
	}
}