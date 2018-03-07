package com.bit;

import java.util.Scanner;

// https://www.hackerrank.com/challenges/and-product/problem

public class AndProduct {
	public static void main(String[] args) {
		Scanner in = new Scanner(System.in);
		int t = in.nextInt();
		long[] result = new long[t];

		for (int i = 0; i < t; i++) {
			long a = in.nextLong();
			long b = in.nextLong();
			result[i] = andProduct(a, b);
		}
		for (int i = 0; i < t; i++) {
			System.out.println(result[i]);
		}
		in.close();
	}

	private static long andProduct(long min, long max) {
		return min & ~(firstOneBitFromLeft(min^max) - 1);
	}
	
	private static int firstOneBitFromLeft(long n) {
        for (int i = 62; i >= 0; i--) {
            if (((1<<i) & n) == (1<<i)) {
                return (1<<i);
            }
        }
        return 1;
    }
}