package com.search;

import java.util.HashSet;
import java.util.Scanner;

// https://www.hackerrank.com/challenges/pairs/problem

public class Pairs {

	public static void main(String[] args) {
		Scanner in = new Scanner(System.in);
		int n = in.nextInt();
		int k = in.nextInt();
		int[] arr = new int[n];
		for (int i = 0; i < n; i++) {
			arr[i] = in.nextInt();
		}
		int result = pairs(k, arr);
		System.out.println(result);
		in.close();
	}

	static int pairs(int k, int[] arr) {
		HashSet<Integer> map = new HashSet<Integer>();
		int count = 0;
		for (int i = 0; i < arr.length; i++) {
			if (map.contains(arr[i] + k)) {
				count++;
			}
			if (map.contains(arr[i] - k)) {
				count++;
			}
			if (!map.contains(arr[i])) {
				map.add(arr[i]);
			}

		}
		return count;
	}
}