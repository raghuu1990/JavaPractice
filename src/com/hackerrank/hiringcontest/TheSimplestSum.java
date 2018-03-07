package com.hackerrank.hiringcontest;

import java.util.Scanner;

// https://www.hackerrank.com/contests/hackerrank-hiring-contest/challenges/the-simplest-sum

public class TheSimplestSum {
	private static int mod = 1000000007;

	public static void main(String[] args) {
		Scanner in = new Scanner(System.in);
		int q = in.nextInt();
		for (int a0 = 0; a0 < q; a0++) {
			int k = in.nextInt();
			long a = in.nextLong();
			long b = in.nextLong();
			long result = simplestSum(k, a, b);
			System.out.println(result);
		}
		in.close();
	}

	static long simplestSum(int k, long a, long b) {
		long lSum = 0;
		long totalSum = 0;
		long i = 0;
		long l = 0;
		long lUsed = 0;
		boolean gotA = false;
		for (;; i++) {
			lSum = (lSum + l) % mod;
			l += (long) (Math.pow(k, i));
			if (!gotA && (l - 1) >= b) {
				totalSum = (totalSum + (lSum * (b - a + 1)) % mod) % mod;
				break;
			} else if (!gotA && (l - 1) >= a) {
				totalSum = (totalSum + (lSum * (l - a)) % mod) % mod;
				lUsed = (l - 1);
				gotA = true;
			} else if (gotA && (l - 1) < b) {
				totalSum = (totalSum + (lSum * ((l - 1) - lUsed)) % mod) % mod;
				lUsed = (l - 1);
			} else if (gotA && (l - 1) >= b) {
				totalSum = (totalSum + (lSum * (b - lUsed)) % mod) % mod;
				break;
			}
		}
		return totalSum % mod;
	}
}
