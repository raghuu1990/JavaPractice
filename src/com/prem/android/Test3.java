package com.prem.android;

/**
 * Created by lovebharti on 27/12/16.
 */
public class Test3 {
	public static void main(String[] args) {
		int[] a = { 2, -1, 2, 3, 4, -5 };
		System.out.print(maxSubArraySum(a) + " ");
		System.out.print(nonContiguousArraySum(a));
		System.out.println("");
	}

	private static int nonContiguousArraySum(int[] a) {
		int size = a.length;
		int max_sum = 0, current_sum = 0;
		for (int i = 0; i < size; i++) {
			if (a[i] >= 0)
				max_sum = max_sum + a[i];
		}
		return max_sum;
	}

	public static int maxSubArraySum(int[] arr) {
		int result = Integer.MIN_VALUE;
		int maxSumCurrent = 0;
		for (int i = 0; i < arr.length; i++) {
			maxSumCurrent += arr[i];
			if (maxSumCurrent < 0)
				maxSumCurrent = 0;
			if (maxSumCurrent > result) {
				result = maxSumCurrent;
			}
		}

		// Check for arr in case result comes 0, means having all -ve (included
		// with 0 or not)
		if (result == 0) {
			int maxForNeg = Integer.MIN_VALUE;
			for (int i = 0; i < arr.length; i++) {
				if (arr[i] > maxForNeg) {
					maxForNeg = arr[i];
				}
			}
			result = maxForNeg;
		}
		return result;
	}

	static int contiguousArraySum(int a[]) {
		int size = a.length;
		int max_sum = 0, current_sum = 0;

		for (int i = 0; i < size; i++) {
			current_sum = current_sum + a[i];
			if (current_sum < 0)
				current_sum = 0;
			if (max_sum < current_sum)
				max_sum = current_sum;
		}
		return max_sum;
	}
}