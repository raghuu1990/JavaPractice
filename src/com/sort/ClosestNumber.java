package com.sort;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.Scanner;

// https://www.hackerrank.com/challenges/closest-numbers/problem

public class ClosestNumber {

	public static void main(String[] args) {
		Scanner in = new Scanner(System.in);
		int n = in.nextInt();
		int arr[] = new int[n];
		for (int i = 0; i < n; i++) {
			arr[i] = in.nextInt();
		}
		closestNumber(arr);
		in.close();
	}

	static void closestNumber(int[] arr) {
		HashMap<Integer, ArrayList<Integer>> map = new HashMap<Integer, ArrayList<Integer>>();
		Arrays.sort(arr);
		int minDiff = Integer.MAX_VALUE;
		for (int i = 1; i < arr.length; i++) {
			if (minDiff >= Math.abs(arr[i] - arr[i - 1])) {
				minDiff = Math.abs(arr[i] - arr[i - 1]);
				if (!map.containsKey(minDiff)) {
					ArrayList<Integer> list = new ArrayList<Integer>();
					list.add(arr[i - 1]);
					list.add(arr[i]);
					map.put(minDiff, list);
				} else {
					map.get(minDiff).add(arr[i - 1]);
					map.get(minDiff).add(arr[i]);
				}
			}
		}
		for (Integer i : map.get(minDiff)) {
			System.out.print(i + " ");
		}
	}
}