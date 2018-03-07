package com.DP;

// https://www.geeksforgeeks.org/longest-increasing-subsequence/
// https://www.geeksforgeeks.org/longest-monotonically-increasing-subsequence-size-n-log-n/

public class LongestIncreasingSubsequence {
	public static void main(String args[]) {
		int arr[] = { 10, 22, 9, 33, 21, 50, 41, 60 };
		// int arr[] = { 2, 5, 3, 7, 11, 8, 10, 13, 6 };
		System.out.println("Length of lis is " + longestIncreasingSubsequenceLength(arr));
		System.out.println("Length of lis is " + longestIncreasingSubsequenceLength1(arr));
	}

	// O(nlogn)
	public static int longestIncreasingSubsequenceLength(int arr[]) {
		int size = arr.length;
		int[] tailTable = new int[size];
		tailTable[0] = arr[0];
		
		int max = 1;
		for (int i = 1; i < size; i++) {
			int index = 0;
			if (arr[i] < tailTable[0]) {
				index = 0;
			} else if (arr[i] > tailTable[max - 1]) {
				index = max++;
			} else {
				index = getHigherIndex(tailTable, 0, max - 1, arr[i]);
			}
			tailTable[index] = arr[i];
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
	
	// O(n^2)
	public static int longestIncreasingSubsequenceLength1(int arr[]) {
		int n = arr.length;
		int lis[] = new int[n];
		for (int i = 0; i < n; i++) {
			lis[i] = 1;
		}

		for (int i = 1; i < n; i++) {
			for (int j = 0; j < i; j++) {
				if (arr[i] > arr[j] && lis[i] < lis[j] + 1) {
					lis[i] = lis[j] + 1;
				}
			}
		}

		int max = 0;
		for (int i = 0; i < n; i++) {
			if (max < lis[i]) {
				max = lis[i];
			}
		}
		return max;
	}
}