package com.array;

import java.util.Scanner;

public class AppearsOnceInSortedArray {
	public static void main(String args[]) throws Exception {
		Scanner in = new Scanner(System.in);
		int t = in.nextInt();
		int[] result = new int[t];
		for (int i = 0; i < t; i++) {
			int n = in.nextInt();
			int[] arr = new int[n];
			for (int j = 0; j < n; j++) {
				arr[j] = in.nextInt();
			}
			result[i] = find(arr);
		}
		for (int i = 0; i < result.length; i++) {
			System.out.println(result[i]);
		}
		in.close();
	}

	private static int find(int[] arr) {
		if(arr[0]!=arr[1]) {
			return arr[0];
		}
		for (int i = 1; i < arr.length-1; i++) {
			if(arr[i-1]!=arr[i]&&arr[i]!=arr[i+1]) {
				return arr[i];
			}
		}
		if(arr[arr.length-2]!=arr[arr.length-1]) {
			return arr[arr.length-1];
		}
		return -1;
	}
}