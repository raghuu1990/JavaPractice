package com.hackerrank.hourrank26;

import java.util.Scanner;

// https://www.hackerrank.com/contests/hourrank-26/challenges/pair-sums

public class PairSums {
	public static void main(String[] args) {
		Scanner in = new Scanner(System.in);
		int n = in.nextInt();
		int[] A = new int[n];
		for (int A_i = 0; A_i < n; A_i++) {
			A[A_i] = in.nextInt();
		}
		long result = largestValue1(A);
		System.out.println(result);
		in.close();
	}
	
	public static long largestValue(int[] arr) {
		int max_sum = Integer.MIN_VALUE;
		int max_sum_here = 0;
		int start = 0, end = 0, tempStart = 0;

		for (int i = 0; i < arr.length; i++) {
			max_sum_here += arr[i];
			if (max_sum < max_sum_here) {
				max_sum = max_sum_here;
				start = tempStart;
				end = i;
			}

			if (max_sum_here < 0) {
				max_sum_here = 0;
				tempStart = i + 1;
			}
		}
		
		long sum = 0;
		for (int i = start; i <= end; i++) {
			sum+=arr[i];
		}
		
		long result = 0;
		
		for (int i = start; i <= end; i++) {
			for (int j = start; j <= end; j++) {
				if(i!=j) {
					result+=arr[i]*arr[j];
					System.out.println(arr[i]+" "+arr[j] + " = "+ arr[i]*arr[j]+" "+ result);
				}
			}
		}
		
		result = 0;
		for (int i = start; i <= end; i++) {
			result +=(sum-arr[i])*arr[i];
		}
		//System.out.println("Starting index : " + start + " , Ending index : " + end);
		return result/2;
	}

	static long largestValue1(int[] arr) {
		int max_sum = Integer.MIN_VALUE;
		int max_sum_here = 0;
		int start = 0, end = 0, tempStart = 0;

		for (int i = 0; i < arr.length; i++) {
			max_sum_here += arr[i];
			if (max_sum < max_sum_here) {
				max_sum = max_sum_here;
				start = tempStart;
				end = i;
			}

			if (max_sum_here < 0) {
				max_sum_here = 0;
				tempStart = i + 1;
			}
		}

		long sum = 0;
		for (int i = start; i <= end; i++) {
			sum+=arr[i];
		}

		long[] A = new long[arr.length];
		for (int i = 0; i < arr.length; i++) {
			A[i] = arr[i]*(sum-arr[i]);
		}
		return maxContiniousSumSubArray(A);
	}
	
	public static long maxContiniousSumSubArray(long[] arr) {
		long max_sum_here = arr[0];
		long max_sum = arr[0];
		for (int i = 1; i < arr.length; i++) {
			max_sum_here += arr[i];
			max_sum_here = Math.max(max_sum_here, arr[i]);
			max_sum = Math.max(max_sum_here, max_sum);
		}
		return max_sum/2;
	}
}