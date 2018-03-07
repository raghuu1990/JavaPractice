package com.bit;

import java.util.Scanner;

// https://www.hackerrank.com/challenges/lonely-integer

public class AppearsOnceInUnSortedArray {
	public static void main(String[] args) {
		Scanner in = new Scanner(System.in);
		int n = in.nextInt();
		int[] a = new int[n];
		for (int a_i = 0; a_i < n; a_i++) {
			a[a_i] = in.nextInt();
		}
		int result = lonelyinteger(a);
		System.out.println(result);
		in.close();
	}

	public static int lonelyinteger(int[] a) {
		int result = a[0];
		for (int a_i = 1; a_i < a.length; a_i++) {
			result ^= a[a_i];
		}
		return result;
	}
}