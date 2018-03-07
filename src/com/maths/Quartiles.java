package com.maths;

import java.util.Arrays;
import java.util.Scanner;

// https://www.hackerrank.com/challenges/s10-quartiles/problem

public class Quartiles {
	public static void main(String[] args) {
		Scanner in = new Scanner(System.in);
		int n = in.nextInt();
		int[] arr = new int[n];
		for (int i = 0; i < n; i++) {
			arr[i] = in.nextInt();
		}

		Arrays.sort(arr);

		System.out.println(median(arr, 0, arr.length / 2 - 1));
		System.out.println(median(arr, 0, arr.length - 1));
		System.out.println(median(arr, (arr.length + 1) / 2, arr.length - 1));

		in.close();
	}

	private static int median(int[] array, int start, int end) {
		int median = 0;
		if ((end - start) % 2 == 0) {
			median = (array[(end + start) / 2]);
		} else {
			int value1 = array[(end + start) / 2];
			int value2 = array[(end + start) / 2 + 1];
			median = (value1 + value2) / 2;
		}
		return median;
	}
}