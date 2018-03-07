package com.DP;

import java.util.Scanner;

// http://practice.geeksforgeeks.org/problems/maximum-sum-increasing-subsequence/0

// Test Case : 1 101 2 3 100 4 5
// All the increasing subsequences : (1,101); (1,2,3,100); (1,2,3,4,5), out of this (1,2,3,100) has maximum sum,i.e., 106.

/*

1
7
1 101 2 3 100 4 5

*/

public class MaximumSumIncreasingSubsequence {
	public static void main(String args[]) throws Exception {
		Scanner in = new Scanner(System.in);
		int t = in.nextInt();
		int [] result = new int[t];
		for (int i = 0; i < t; i++) {
			int n = in.nextInt();
			int [] arr = new int[n];
			for (int j = 0; j < n; j++) {
				arr[j] = in.nextInt();
			}
			result[i]= findMaxSum(arr);
			System.out.println(result[i]);
			result[i]= longestIncreasingSubsequenceLength(arr);
			System.out.println(result[i]);
		}
		for (int i = 0; i < result.length; i++) {
			// System.out.println(result[i]);
		}
		in.close();
	}

	private static int findMaxSum(int[] arr) {
		int l = arr.length;
		int[] ms = new int[l];
		for (int i = 0; i < l; i++) {
			ms[i] = arr[i];
		}

		for (int i = 1; i < l; i++) {
			for (int j = 0; j < i; j++) {
				if(arr[i]>arr[j] && ms[i] < ms[j]+arr[i]) {
					ms[i] = ms[j]+arr[i];
				}
			}
		}
		
		int max = ms[0];
		for (int i = 1; i < l; i++) {
			if(max < ms[i]) {
				max = ms[i];
			}
		}
		return max;
	}

	public static int longestIncreasingSubsequenceLength(int arr[]) {
		int max = Integer.MIN_VALUE;
		int sum = 0;
		int size = arr.length;
		int[] tailTable = new int[size];
		tailTable[0] = arr[0];
		max = sum = arr[0];
		
		int len = 1;
		for (int i = 1; i < size; i++) {
			int index = 0;
			if (arr[i] < tailTable[0]) {
				index = 0;
				sum = arr[0];
			} else if (arr[i] > tailTable[len - 1]) {
				index = len++;
				sum+=arr[i];
			} else {
				index = getHigherIndex(tailTable, -1, len - 1, arr[i]);
				sum-=tailTable[index];
				sum+=arr[i];
			}
			tailTable[index] = arr[i];
			max = Math.max(max, sum);
		}
		return max;
	}

	public static int getHigherIndex(int arr[], int low, int high, int value) {
		while (low < high) {
			int mid = low + ((high - low) / 2);
			if (arr[mid] >= value) {
				high = mid;
			} else {
				low = mid+1;
			}
		}
		return high;
	}
}