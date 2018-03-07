package com.regex;

import java.util.Scanner;

// https://www.hackerrank.com/challenges/valid-username-checker/problem
public class ValidUsername {
	public static void main(String[] args) {
		Scanner in = new Scanner(System.in);
		int n = Integer.parseInt(in.nextLine());
		while (n-- != 0) {
			String userName = in.nextLine();

			if (userName.matches(UsernameValidator.regularExpression)) {
				System.out.println("Valid");
			} else {
				System.out.println("Invalid");
			}
		}
		in.close();
	}

}

class UsernameValidator {
	public static final String regularExpression = "^[a-zA-Z]\\w{7,29}$";
}