package com.array;

import java.util.Arrays;
import java.util.Scanner;

public class ChocolateDistribution {
	public static void main(String args[]) {
		Scanner in = new Scanner(System.in);
		int T = in.nextInt();
		int [] result = new int[T];
		for (int i = 0; i < T; i++) {
			int N = in.nextInt();
			int [] arr = new int [N];
			for (int j = 0; j < N; j++) {
				arr[j] = in.nextInt();
			}
			int maxDiff = in.nextInt();
			result[i] = calculate(arr, maxDiff);
		}
		for (int i = 0; i < result.length; i++) {
		    System.out.println(result[i]);
		}
		in.close();
	}

	private static int calculate(int[] arr, int maxDiff) {
		int result = Integer.MAX_VALUE;
		int l = arr.length;
		Arrays.sort(arr);
		for (int j = 0; j < l-(maxDiff-1); j++) {
			result = Math.min(result, arr[j+(maxDiff-1)]-arr[j]);
		}
		return result;
	}
}