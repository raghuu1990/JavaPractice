package com.maths;

import java.util.ArrayList;

// https://www.interviewbit.com/problems/prime-sum/

public class PrimeSum {

	public static void main(String[] args) {
		long t = System.currentTimeMillis();
		System.out.println(primeSum(1616545));
		System.out.println(System.currentTimeMillis() - t);
	}

	public static ArrayList<Integer> primeSum(int A) {
		ArrayList<Integer> result = new ArrayList<Integer>();
		boolean[] isPrime = primeNumbersBeforeN(A);
		for (int i = 2; i <= A; i++) {
			if (isPrime[i] && isPrime[A - i]) {
				result.add(i);
				result.add(A - i);
				break;
			}

		}
		return result;
	}

	// Sieve of Eratosthenes
	public static boolean[] primeNumbersBeforeN(int n) {
		boolean[] isPrime = new boolean[n + 1];
		for (int i = 0; i < isPrime.length; i++) {
			isPrime[i] = true;
		}

		for (int p = 2; p * p <= n; p++) {
			if (isPrime[p] == true) {
				for (int i = p * 2; i <= n; i += p)
					isPrime[i] = false;
			}
		}
		return isPrime;
	}
}