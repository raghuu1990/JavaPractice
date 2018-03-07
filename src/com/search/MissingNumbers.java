package com.search;

import java.util.Scanner;
import java.util.TreeMap;

// https://www.hackerrank.com/challenges/missing-numbers/problem

public class MissingNumbers {

	public static void main(String[] args) {
		Scanner in = new Scanner(System.in);
		int n = in.nextInt();
		int[] a = new int[n];
		for (int i = 0; i < n; i++) {
			a[i] = in.nextInt();
		}
		int m = in.nextInt();
		int[] b = new int[m];
		for (int j = 0; j < m; j++) {
			b[j] = in.nextInt();
		}
		int[] result = missingNumbers(a, b);
		for (int i = 0; i < result.length; i++) {
			System.out.print(result[i] + (i != result.length - 1 ? " " : ""));
		}
		System.out.println("");
		in.close();
	}

	static int[] missingNumbers(int[] a, int[] b) {
		TreeMap<Integer, Integer> map = new TreeMap<Integer, Integer>();
		for (int i = 0; i < b.length; i++) {
			if (map.containsKey(b[i])) {
				map.put(b[i], map.get(b[i]) + 1);
			} else {
				map.put(b[i], 1);
			}
		}

		for (int i = 0; i < a.length; i++) {
			int freq = map.get(a[i]);
			if (freq == 1) {
				map.remove(a[i]);
			} else {
				map.put(a[i], map.get(a[i]) - 1);
			}
		}
		int[] result = new int[map.size()];
		int i = 0;
		for (int key : map.keySet()) {
			result[i++] = key;
		}
		return result;
	}
}