package com.hackerrank.worldcodesprint12;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.HashSet;
import java.util.Map.Entry;
import java.util.TreeMap;

// https://www.hackerrank.com/contests/world-codesprint-12/challenges/factorial-array

// Observe that 40! is divisible by 10e9. So if Ai>=40, then it adds 0 to our answer and we may ignore it.

// 40!%10e9 = 0

public class FactorialArray {
	private static int MOD = 1000000007;
	private static long fact[] = new long[100001];
	private static TreeMap<Integer, Integer> arr;
	
	static final long facts[] = new long[] { 0, 1, 2, 6, 24, 120, 720, 5040, 40320, 362880, 3628800, 39916800,
			479001600, 227020800, 178291200, 674368000, 789888000, 428096000, 705728000, 408832000, 176640000,
			709440000, 607680000, 976640000, 439360000, 984000000, 584000000, 768000000, 504000000, 616000000,
			480000000, 880000000, 160000000, 280000000, 520000000, 200000000, 200000000, 400000000, 200000000,
			800000000 };

	public static void main(String[] args) throws IOException {
		createFactotial();
		BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
		String[] input = in.readLine().split(" ");
		int n = Integer.parseInt(input[0]);
		int m = Integer.parseInt(input[1]);
		arr = new TreeMap<Integer, Integer>();
		input = in.readLine().split(" ");
		for (int i = 1; i <= n; i++) {
			int value = Integer.parseInt(input[i - 1]);
			if (value < 40) {
				arr.put(i, value);
			}
		}
		for (int j = 0; j < m; j++) {
			input = in.readLine().split(" ");
			int a = Integer.parseInt(input[0]);
			int b = Integer.parseInt(input[1]);
			int c = Integer.parseInt(input[2]);
			operation(a, b, c);
		}
		in.close();
	}

	public static final void operation(int a, int b, int c) {
		if (a == 1) {
			increaseRange(b, c);
		} else if (a == 2) {
			printFactorial(b, c);
		} else if (a == 3) {
			updateIndex(b, c);
		}
	}

	public static final void updateIndex(int b, int c) {
		if (c < 40) {
			arr.put(b, c);
		} else if (arr.containsKey(b)) {
			arr.remove(b);
		}
	}

	private static final void printFactorial(int b, int c) {
		long sum = 0;
		for (Entry<Integer, Integer> entry : arr.entrySet()) {
			int i = entry.getKey();
			if (i < b) {
				continue;
			} else if (i > c) {
				break;
			} else if (i >= b && i <= c) {
				if (entry.getValue() < 40) {
					sum += fact[entry.getValue()];
					sum = sum % MOD;
				}
			}
		}
		System.out.println(sum);
	}

	public static final void increaseRange(int b, int c) {
		HashSet<Integer> toRemove = new HashSet<Integer>();
		for (Entry<Integer, Integer> entry : arr.entrySet()) {
			int i = entry.getKey();
			if (i < b) {
				continue;
			} else if (i > c) {
				break;
			} else if (i >= b && i <= c) {
				if (entry.getValue() < 39) {
					entry.setValue(entry.getValue() + 1);
				} else {
					toRemove.add(i);
				}
			}
		}
		for (int i : toRemove) {
			arr.remove(i);
		}
	}

	public static final void createFactotial() {
		fact[0] = 1;
		for (int i = 1; i <= 100000; i++) {
			System.out.println((fact[i - 1] * i) +"		"+(double) ((fact[i - 1]*i) / MOD)+ "	"+ (fact[i - 1] * i) % MOD );
			fact[i] = (fact[i - 1] * i) % MOD;
		}
	}
}