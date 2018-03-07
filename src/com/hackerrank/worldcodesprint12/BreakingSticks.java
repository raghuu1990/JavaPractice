package com.hackerrank.worldcodesprint12;

import java.util.Scanner;

// https://www.hackerrank.com/contests/world-codesprint-12/challenges/breaking-sticks

public class BreakingSticks {
	public static void main(String[] args) {
		Scanner in = new Scanner(System.in);
		int n = in.nextInt();
		long[] a = new long[n];
		for (int i = 0; i < n; i++) {
			a[i] = in.nextLong();
		}
		long result = longestSequence(a);
		System.out.println(result);
		in.close();
	}

	public static long longestSequence(long[] a) {
		long sum = 0;
		for (int i = 0; i < a.length; i++) {
			sum+=longestSequence(a[i]);
		}
		return sum;
	}
	
	public static long longestSequence(long a) {
		if(a==1) {
			return 1;
		}
		long sum = a;
		long n = a;
		while(n>1) {
			long d = getFirstDivisor(n);
			if(d!=-1) {
				sum+=n/d;
				n=n/d;
			}else {
				break;
			}
		}
		return sum+1;
	}
	
	public static long getFirstDivisor(long a) {
		for (long i = 2; i <= Math.sqrt(a); i++) {
			if(a%i==0) {
				return i;
			}
		}
		return -1;
	}
}