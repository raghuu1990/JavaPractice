package com.interview.misc;

import java.util.ArrayList;
import java.util.List;

// All prime numbers before n

public class PrimeNumbersBeforeN {

	public static List<Integer> primes;
	public static List<Integer> primeCount;

	public static List<Integer> primeNumbersBeforeN(int n) {
		List<Integer> result = new ArrayList<Integer>();
		result.add(2);
		for (int i = 3; i < n; i += 2) {
			for (int r : result) {
				if (i % r == 0) {
					break;
				}
				if (2 * r > i) {
					result.add(i);
					break;
				}
			}
		}
		return result;
	}

	public static boolean isPrime(int n) {
		int i;
		if (n == 2) {
			return true;
		}
		if (n % 2 == 0) {
			return false;
		}
		for (i = 3; i <= Math.sqrt(n); i += 2) {
			if (n % i == 0) {
				return false;
			}
		}
		return true;
	}

	public static void primeNums(int n) {
		primeCount = new ArrayList<Integer>();
		primes = new ArrayList<Integer>();
		primes.add(2);

		primeCount.add(0);
		primeCount.add(0);
		primeCount.add(1);

		for (int i = 3; i <= n; i += 2) {
			for (int r : primes) {
				if (i % r == 0) {
					primeCount.add(primeCount.get(i - 1));
					primeCount.add(primeCount.get(i - 1));
					break;
				}
				if (2 * r > i) {
					primes.add(i);
					primeCount.add(primeCount.get(i - 1) + 1);
					primeCount.add(primeCount.get(i - 1) + 1);
					break;
				}
			}
		}
	}

	public static void main(String args[]) {
		int num = 350; 
		System.out.println(isPrime(9));
		List<Integer> result = primeNumbersBeforeN(num-1);
		result.forEach(i -> System.out.print(i + " "));
		primeNums(num);
		System.out.println();
		System.out.println("Total prime nos before : "+ num+" : "+primeCount.get(num));
		primes.forEach(i -> System.out.print(i + " "));
	}
}
