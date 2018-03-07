package com.bigdatastructure;

import java.math.BigInteger;
import java.util.Scanner;

// https://www.hackerrank.com/challenges/java-biginteger/problem

public class JavaBigInteger {

	public static void main(String[] args) {
		Scanner in = new Scanner(System.in);
		BigInteger a = in.nextBigInteger();
		BigInteger b = in.nextBigInteger();
		System.out.println(a.add(b));
		System.out.println(a.multiply(b));

		if (a.isProbablePrime(0)) {
			System.out.println("prime");
		} else {
			System.out.println("not prime");
		}

		String A = in.next();
		if (A.equals((new StringBuilder(A)).reverse().toString())) {
			System.out.println("Yes");
		} else {
			System.out.println("No");
		}
		in.close();
	}
}