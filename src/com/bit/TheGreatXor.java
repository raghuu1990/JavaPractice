package com.bit;

import java.util.Scanner;

// https://www.hackerrank.com/challenges/the-great-xor

public class TheGreatXor {
	public static void main(String[] args) {
		Scanner in = new Scanner(System.in);
		long q = in.nextLong();
		for (int a0 = 0; a0 < q; a0++) {
			long x = in.nextLong();
			System.out.println(findNoOfZero(x));
		}
		in.close();
	}

	private static long findNoOfZero(long x) {
		long count = 0;
		for (int i = 62; i >= 0; i--) {
			if ((((long) 1) << i) < x) {
				if (((((long) 1) << i) & x) == 0) {
					count += Math.pow(2, i);
				}
			}
		}
		return count;
	}
}