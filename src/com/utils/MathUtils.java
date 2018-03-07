package com.utils;

public class MathUtils {
	private static int ncr(int n, int r) {
		return factorial(n) / (factorial(r) * factorial(n - r));
	}

	public static int factorial(int n) {
		return (n <= 1) ? 1 : n * factorial(n - 1);
	}

	public static int absolute(int a) {
		if (a < 0) {
			return -1 * a;
		}
		return a;
	}
}