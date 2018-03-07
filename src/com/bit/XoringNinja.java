package com.bit;

import java.util.Scanner;

// https://www.hackerrank.com/challenges/xoring-ninja

public class XoringNinja {
	private static long MOD = 1000000007l;
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
			result[i] = xoringSum(arr);
		}
		for (int i = 0; i < result.length; i++) {
			System.out.println(result[i]);
		}
		in.close();
	}

	private static long xoringSum(long[] arr) {
		long max = max(arr);
        //long pow = ((long)Math.pow(2, arr.length-1))% MOD;
        long pow = ((long)pow(2, arr.length-1))% MOD;
        return (pow*max) % MOD;
	}
	
	private static long max(long[] arr) {
		long max = 0;
		for (int i = 0; i < arr.length; i++) {
			max |= arr[i];
		}
		return max;
	}

	private static long pow(long n, long k) {
		if (k == 0)
			return 1;
		if (n == 0)
			return 0;
		if (n == 1)
			return 1;
		
		long result= n % MOD;
		long pow = 1;
		while (pow <= k) {
			result *= n;
			result %= MOD;
			pow++;
		}
		return result % MOD;
	}
}