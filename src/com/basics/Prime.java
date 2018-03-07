package com.basics;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Prime {

	public static int[] prime;
	public static List<Integer> primes;
	public static List<Integer> primeCount;

	public static void main(String[] args) {
		Scanner in = new Scanner(System.in);
		int N = in.nextInt();
		int[] P = new int[N];
		int max = Integer.MIN_VALUE;
		for (int i = 0; i < N; i++) {
			int num = in.nextInt();
			P[i] = num;
			if (num > max) {
				max = num;
			}
		}
		
		//processPrime(max);
		primeNumbers(max);
		int H = in.nextInt();
		System.out.println(getAssignmentsDone(P, H));
		in.close();
	}

	public static void processPrime(int size) {
		prime = new int[size+1];
		prime[0] = 0;
		prime[1] = 1;
		prime[2] = 2;
		for (int i = 3; i <= size; i++) {
			if (isPrime(i)) {
				prime[i] = prime[i - 1] + 1;
			} else {
				prime[i] = prime[i - 1];
			}
		}
	}

	public static void primeNumbers(int n) {
		primeCount = new ArrayList<Integer>();
		primes = new ArrayList<Integer>();
		primes.add(2);

		primeCount.add(0);
		primeCount.add(0);
		primeCount.add(1);
		
		boolean flag = false;
		for (int i = 3; i <= n; i += 2) {
			for (int r : primes) {
				if (2 * r > i) {
					break;
				}
				if (i % r == 0) {
					flag = true;
					break;
				}
			}
			if (!flag) {
				primeCount.add(primeCount.get(i-1)+1);
				primes.add(i);
			}else {
				flag = false;
				primeCount.add(primeCount.get(i-1));
			}
		}
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

	private static int getAssignmentsDone(int[] p, int h) {
		int r = 0;

		int hours = 0;
		for (int i = 0; i < p.length; i++) {
			hours += primeCount.get(p[i]);
			if (hours <= h) {
				r++;
			} else {
				break;
			}
		}
		return r;
	}
}