package com.array;

import java.util.Scanner;

// https://www.hackerrank.com/challenges/java-negative-subarray/problem

public class NegativeSubarraySum {
	public static void main(String[] args) {
		Scanner in = new Scanner(System.in);
		int n = in.nextInt();
		int[] arr = new int[n];
		for (int i = 0; i < n; i++) {
			arr[i] = in.nextInt();
		}
		int result = negativeSubArraySum(arr);
		System.out.println(result);
		in.close();
	}

	private static int negativeSubArraySum(int[] arr) {
		int count = 0;
		for (int i = 0; i < arr.length; i++) {
			for (int j = i; j < arr.length; j++) {
				if (subArraySum(arr, i, j) < 0) {
					count++;
				}
			}
		}
		return count;
	}

	private static int subArraySum(int[] arr, int start, int end) {
		int sum = 0;
		for (int i = start; i <= end; i++) {
			sum += arr[i];
		}
		System.out.println(sum);
		return sum;
	}
}