package com.basics;

import java.math.BigInteger;
import java.util.Scanner;

public class BigFactorial {

	public static void main(String[] args) {
		Scanner in = new Scanner(System.in);
		int n = in.nextInt();
		String fact = factorial(n);
		String factJava = factorialJava(n);
		System.out.println(fact);
		System.out.println(factJava);
		in.close();
	}

	public static String factorial(int n) {
		int MAX = 500;
		int res[] = new int[MAX];
		String fact = "";
		res[0] = 1;
		int res_size = 1;

		for (int x = 2; x <= n; x++) {
			res_size = multiply(x, res, res_size);
		}

		for (int i = res_size - 1; i >= 0; i--) {
			fact += res[i];
		}
		return fact;
	}

	public static int multiply(int x, int res[], int res_size) {
		int carry = 0;
		for (int i = 0; i < res_size; i++) {
			int prod = res[i] * x + carry;
			res[i] = prod % 10;
			carry = prod / 10;
		}

		while (carry > 0) {
			res[res_size] = carry % 10;
			carry = carry / 10;
			res_size++;
		}
		return res_size;
	}

	public static String factorialJava(int n) {
		BigInteger fact = new BigInteger("1");
		for (int i = 1; i <= n; i++) {
			fact = fact.multiply(new BigInteger(i + ""));
		}
		return fact.toString();
	}
}