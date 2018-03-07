package com.maths;

import java.util.Scanner;

// https://www.hackerrank.com/challenges/repeat-k-sums

// TODO :

public class RepeatKSums {
	public static void main(String[] args) {
		Scanner in = new Scanner(System.in);
		int t = in.nextInt();
		int[][] result = new int[t][];
		for (int i = 0; i < t; i++) {
			int n = in.nextInt();
			int k = in.nextInt();
			//int s = getNoOfTimeUsed(n, k);
			int s = getNoOfTimeUsed(n+k-1, k);
			int[] arr = new int[n];
			for (int j = 0; j < n+k-1; j++) {
				arr[j] = in.nextInt();
			}
			result[i] = findPowerSum(arr, s, n, k);
		}

		for (int i = 0; i < args.length; i++) {
			for (int j = 0; j < args.length; j++) {
				System.out.print(result[i][j] + "");
			}
			System.out.println();
		}
		in.close();
	}

	public static int[] findPowerSum(int[] arr, int s, int a, int b) {
		int[] reselt = new int[a];
		if(a==1) {
			reselt[0] = arr[0] / b;
			return reselt;
		}

		if(b==1) {
			for (int i = 0; i < arr.length; i++) {
				reselt[i] = arr[i];
			}
			return reselt;
		}
		
		if(a==b) {
			reselt[0] = arr[0] / b;
			reselt[a-1] = arr[arr.length-1] / b;
		}
		return reselt;
	}

	private static int getNoOfTimeUsed(int n, int k) {
		 if(k > n - k) {
		        k = n - k;
		    }
		    int p = 1;
		    for (int i = 1; i <= k; ++i) {
		        p *= n + 1 - i;
		        p /= i;
		    }
		    return p;
	}
	
	private static int getNoOfTimeUsed1(int a, int b) {
		if(a==1) {
			return 1;
		}
		if(b==1) {
			return a;
		}
		return a+b-1;
	}

	private static int ncr(int n, int r) {
		int fact = factorial(n) / (factorial(r) * factorial(n - r));
		return fact < 1 ? 1 : fact;
	}

	public static int factorial(int n) {
		return (n <= 1) ? 1 : n * factorial(n - 1);
	}
}