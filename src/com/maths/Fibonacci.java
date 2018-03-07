package com.maths;

public class Fibonacci {
	public static void main(String args[]) {
		System.out.println(fibonacciDP(15));
		System.out.println(fibonacciRecursive(15));
	}

	public static int fibonacciRecursive(int n) {
		if (n == 1 || n == 0) {
			return n;
		}
		return fibonacciRecursive(n - 1) + fibonacciRecursive(n - 2);
	}

	public static int fibonacciDP(int n) {
		int n1 = 0, n2 = 1;
		int sum;

		if (n == n1 || n == n2) {
			return n;
		}

		for (int i = 2; i <= n; i++) {
			sum = n1 + n2;
			n1 = n2;
			n2 = sum;
		}
		return n2;
	}
}