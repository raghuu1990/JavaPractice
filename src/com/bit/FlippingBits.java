package com.bit;

import java.util.Scanner;

// https://www.hackerrank.com/challenges/flipping-bits

public class FlippingBits {
	public static void main(String[] args) {
		Scanner in = new Scanner(System.in);
		int t = Integer.parseInt(in.next());
		Long[] result = new Long[t];
		for (int i = 0; i < t; i++) {
			Long a = in.nextLong();
			result[i] = flip(a);
		}
		for (int i = 0; i < result.length; i++) {
			System.out.println(result[i]);
		}
		in.close();
	}

	private static long flip(Long n) {
		for (int i = 31; i >= 0; i--) {
			n = n^((long)1<<i); 
		}
		return n;
	}
}