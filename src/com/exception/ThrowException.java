package com.exception;

import java.util.Scanner;

public class ThrowException {
	public static void main(String[] args) {
		Scanner in = new Scanner(System.in);
		int t = in.nextInt();
		while (t-- > 0) {

			int n = in.nextInt();
			int p = in.nextInt();
			Calculator1 myCalculator = new Calculator1();
			try {
				int ans = myCalculator.power(n, p);
				System.out.println(ans);
			} catch (Exception e) {
				System.out.println(e.getMessage());
			}
		}
		in.close();
	}
}

class Calculator1 {

	public int power(int n, int p) throws Exception {
		if (n < 0 || p < 0) {
			throw (new Exception("n or p should not be negative."));
		}
		if (n == 0 && p == 0) {
			throw (new Exception("n and p should not be zero."));
		}
		return (int) Math.pow(n, p);
	}
}