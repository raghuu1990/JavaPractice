package com.company.goldman;

import java.util.HashMap;
import java.util.Scanner;

public class GoldMan1 {
	public static void main(String[] args) {
		Scanner in = new Scanner(System.in);
		int n = in.nextInt();
		int[] arr = new int[n];
		for (int i = 0; i < n; i++) {
			int m = in.nextInt();
			arr[i] = m;
		}
		int k = in.nextInt();
		int r = getLargestNumberWithPrimeOccurences(arr, k);
		System.out.println(r);
		in.close();
	}

	private static int getLargestNumberWithPrimeOccurences(int[] arr, int k) {
		HashMap<Integer, Integer> freq = new HashMap<Integer, Integer>();
		for (int i = 0; i < arr.length; i++) {
			if (freq.containsKey(arr[i])) {
				freq.put(arr[i], freq.get(arr[i]) + 1);
			} else {
				freq.put(arr[i], 1);
			}
		}

		int result = -1;
		for (int key : freq.keySet()) {
			int frequency = freq.get(key);
			if (frequency >= k) {
				if (isPrime(frequency) && result < key) {
					result = key;
				}
			}

		}
		return result;
	}

	public static boolean isPrime(int n) {
		if (n <= 1) {
			return false;
		}
		for (int i = 2; i < n/2; i++) {
			if (n % i == 0) {
				return false;
			}
		}
		return true;
	}
}
