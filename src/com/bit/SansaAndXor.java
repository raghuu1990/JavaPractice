package com.bit;

import java.util.Scanner;

// https://www.hackerrank.com/challenges/sansa-and-xor

public class SansaAndXor {
	public static void main(String[] args) {
		Scanner in = new Scanner(System.in);
		int t = in.nextInt();
		long[] result = new long[t];
		for (int i = 0; i < t; i++) {
			int n = in.nextInt();
			long[] arr = new long[n];
			for (int j = 0; j < n; j++) {
				arr[j] = in.nextLong();
			}
			result[i] = getSum(arr);
		}
		for (int i = 0; i < result.length; i++) {
			System.out.println(result[i]);
		}
		in.close();
	}

	private static long[] findFreq(long[] arr) {
        int n = arr.length;
		long[] freq = new long[n];
		for (int i = 0; i < n; i++) {
			freq[i] = (n-i)*(i+1);
		}
		return freq;
	}

	private static long getSum(long[] arr) {
		long[] freq = findFreq(arr);
		long xor = 0;
		for (int i = 0; i < arr.length; i++) {
			if (freq[i] % 2 == 0) {
				xor = 0 ^ xor;
			} else {
				xor = xor ^ arr[i];
			}
		}
		return xor;
	}
}