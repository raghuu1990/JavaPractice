package com.matrix;

import java.util.Scanner;

// https://www.hackerrank.com/challenges/30-2d-arrays/problem

public class HourglassSum {

	public static void main(String[] args) {
		Scanner in = new Scanner(System.in);
		int arr[][] = new int[6][6];
		for (int i = 0; i < 6; i++) {
			for (int j = 0; j < 6; j++) {
				arr[i][j] = in.nextInt();
			}
		}
		System.out.println(maxHourglassSum(arr));
		in.close();
	}

	public static int maxHourglassSum(int[][] arr) {
		int max = Integer.MIN_VALUE;
		for (int col = 0; col < arr[0].length-2; col++) {
			for (int row = 0; row < arr.length-2; row++) {
				int sum = 0;
				sum+=arr[row][col];
				sum+=arr[row][col+1];
				sum+=arr[row][col+2];
				sum+=arr[row+1][col+1];
				sum+=arr[row+2][col];
				sum+=arr[row+2][col+1];
				sum+=arr[row+2][col+2];
				max = Math.max(max, sum);
			}
		}
		return max;
	}
}