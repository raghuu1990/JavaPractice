package com.bit;

import java.util.Scanner;

// https://www.hackerrank.com/challenges/yet-another-minimax-problem

// TODO :

public class MinimumScore {
	public static void main(String[] args) {
		Scanner in = new Scanner(System.in);
		int t = Integer.parseInt(in.next());
		long[] arr = new long[t];
		for (int i = 0; i < t; i++) {
			arr[i] = in.nextLong();
		}
		System.out.println(getMinScore(arr));
		in.close();
	}

	private static long getMinScore(long[] arr) {
		int max = -1;
		for(int i = 0; i<arr.length ;i++) {
			int j = indexOfFirstZeroBitFromLeft(arr[i]);
			if(max<j) {
				max = j;
			}
		}
		
		long result = 0;
		for (int j = 0; j < arr.length-1; j++) {
			long value = xorIgnoringFromLeft(arr[j], arr[j-1], j);
			if (result<value) {
				result = value;
			}
		}
		return result;
	}
	
	private static int indexOfFirstZeroBitFromLeft(long x) {
		for (int i = 62; i >= 0; i = i--) {
			if ((((long) 1) << i) < x) {
				if (((((long) 1) << i) & x) == 0) {
					return i;
				}
			}
		}
		return -1;
	}

	private static long xorIgnoringFromLeft(long a, long b, int start) {
		long xor = a^b;
		for (int i = 62; i > start; i = i--) {
			xor = (((long) 1) << i) &  xor;
		}
		return xor;
	}
}