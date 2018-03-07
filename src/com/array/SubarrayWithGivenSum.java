package com.array;

import java.util.Scanner;

// http://practice.geeksforgeeks.org/problems/subarray-with-given-sum/0

public class SubarrayWithGivenSum {
	public static void main(String[] args) {
		Scanner in = new Scanner(System.in);
		int t = in.nextInt();
		String[] result = new String[t];
		for (int i = 0; i < t; i++) {
			int n = in.nextInt();
			int sum = in.nextInt();
			int[] c = new int[n];
			for (int j = 0; j < n; j++) {
				c[j] = in.nextInt();
			}
			result[i] = getSubArray(c, sum);
		}
		for (int i = 0; i < result.length; i++) {
			System.out.println(result[i] + " ");
		}
		in.close();
	}

	private static String getSubArray(int[] arr, int sum) {
		int currentSum = 0;
		int start = 0;
		int end = 0;

		for (int i = 0; i < arr.length; i++) {
			currentSum += arr[i];
			end = i;
			if (sum == currentSum) {
				return (start + 1) + " " + (end + 1);
			} else if (currentSum > sum) {
				while (currentSum > sum && start > -1) {
					currentSum -= arr[start];
					start++;
				}
				if (currentSum == sum) {
					return (start + 1) + " " + (end + 1);
				}
			}
		}
		return " " + -1;
	}
}