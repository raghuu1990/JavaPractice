package com.codechef.jan2018;

import java.util.Scanner;

public class KConcatenation {
	public static void main(String[] args) {
		Scanner in = new Scanner(System.in);
		int T = in.nextInt();
		long[] result = new long[T];
		for (int i = 0; i < T; i++) {
			int N = in.nextInt();
			int K = in.nextInt();
			int[] A = new int[N];

			for (int j = 0; j < N; j++) {
				A[j] = in.nextInt();
			}
			result[i] = kConcatenation(A, K);
		}
		for (int i = 0; i < T; i++) {
			System.out.println(result[i]);
		}
		in.close();
	}

	private static long kConcatenation(int[] a, int k) {
		if(k==1) {
			return maxContiniousSumSubArray(a);
		}

		long sum = 0;
		for (int j = 0; j < a.length; j++) {
			sum += a[j];
		}
		
		long maxSum = 0;
		long sumTillNow = 0;
		
		int start = 0;
		int end = 0;
		int temp = 0;
		
		for (int i = 0; i < a.length; i++) {
			sumTillNow += a[i];
			
			if(true) {
				
			}
		}
		
		return sum;
	}
	
	public static long maxContiniousSumSubArray(int[] arr) {
		long max_sum_here = arr[0];
		long max_sum = arr[0];
		for (int i = 1; i < arr.length; i++) {
			max_sum_here += arr[i];
			max_sum = Math.max(max_sum_here, max_sum);
			max_sum_here = Math.max(0, max_sum_here);
		}
		return max_sum;
	}
}
