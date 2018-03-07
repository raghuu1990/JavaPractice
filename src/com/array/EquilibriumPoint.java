package com.array;

import java.util.Scanner;
// http://practice.geeksforgeeks.org/problems/equilibrium-point/0
public class EquilibriumPoint {
	public static void main(String[] args) {
		Scanner in = new Scanner(System.in);
		int t = in.nextInt();
		int[] result = new int[t];
		for (int i = 0; i < t; i++) {
			int n = in.nextInt();
			int[] c = new int[n];
			for (int j = 0; j < n; j++) {
				c[j] = in.nextInt();
			}
			result[i] = equilibriumPoint(c);
		}
		for (int i = 0; i < result.length; i++) {
			System.out.println(result[i] + " ");
		}
		in.close();
	}

	private static int equilibriumPoint(int[] arr) {
		int sum = 0;
		for (int i = 0; i < arr.length; i++) {
			sum += arr[i];
		}
		int currSum = 0;
		for (int i = 0; i < arr.length; i++) {
			if (currSum == sum - arr[i] - currSum) {
				return i + 1;
			}
			currSum += arr[i];
		}
		return -1;
	}
}