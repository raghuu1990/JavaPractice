package com.search;

import java.util.Arrays;
import java.util.Scanner;

// https://www.hackerrank.com/challenges/hackerland-radio-transmitters/problem

public class HackerlandRadioTransmitters {
	public static void main(String[] args) {
		// [2, 4, 5, 6, 7, 9, 11, 12]

		Scanner in = new Scanner(System.in);
		int n = in.nextInt();
		int k = in.nextInt();
		int[] x = new int[n];
		for (int x_i = 0; x_i < n; x_i++) {
			x[x_i] = in.nextInt();
		}
		int result = hackerlandRadioTransmitters(x, k);
		System.out.println(result);
		in.close();
	}

	public static int hackerlandRadioTransmitters(int[] x, int k) {
		Arrays.sort(x);
		int count = 0;
		int i = 0;
		int n = x.length;
		while(i<n) {
			count++;
			int loc = x[i] + k;
			while (i < n && x[i] <= loc) i++;
		    loc = x[--i] + k;
		    while (i < n && x[i] <= loc) i++;
		}
		return count;
	}
}