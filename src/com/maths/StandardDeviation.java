package com.maths;

import java.util.Arrays;
import java.util.Scanner;

// https://www.hackerrank.com/challenges/s10-standard-deviation/problem

public class StandardDeviation {

	public static void main(String[] args) {
		Scanner in = new Scanner(System.in);
		int t = in.nextInt();
		int[] arr = new int[t];

		for (int i = 0; i < t; i++) {
			arr[i] = in.nextInt();
		}

		double sd = standardDeviation(arr);
		System.out.printf("%.1f", sd);
		in.close();
	}

	private static double standardDeviation(int[] arr) {
		Arrays.sort(arr);
		double sd = 0;
		double mean =mean(arr);
		for (int i = 0; i < arr.length; i++) {
			sd = (sd*i + ((arr[i]-mean)*(arr[i]-mean)))/(i+1);
		}
		return Math.sqrt(sd);
	}
	
	public static double mean(int[] input) {
		double mean = 0;
		for (int i = 0; i < input.length; i++) {
			mean = (mean * i + input[i]) / (i + 1);
		}
		return mean;
	}
}