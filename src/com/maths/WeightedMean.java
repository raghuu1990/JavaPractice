package com.maths;

import java.util.Scanner;

// https://www.hackerrank.com/challenges/s10-weighted-mean/problem

public class WeightedMean {

	public static void main(String[] args) {
		Scanner in = new Scanner(System.in);
		int n = in.nextInt();
		int[] X = new int[n];
		int[] W = new int[n];
		for (int i = 0; i < n; i++) {
			X[i] = in.nextInt();
		}

		for (int i = 0; i < n; i++) {
			W[i] = in.nextInt();
		}
		
		float weightMean = weightedMean(X, W);
		System.out.printf("%.1f", weightMean);
		in.close();
	}

	private static float weightedMean(int[] X, int[] W) {
		float sum = 0;
		int count = 0;
		for (int i = 0; i < W.length; i++) {
			sum = sum + X[i] * W[i];
			count += W[i];
		}
		return sum / count;
	}
}