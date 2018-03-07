package com.DP;

import java.util.Scanner;

// https://www.hackerrank.com/challenges/ctci-recursive-staircase/problem

public class Staircase {
	public static void main(String[] args) {
		Scanner in = new Scanner(System.in);
		int p = in.nextInt();
		int[] input = new int[p];
		int max = Integer.MIN_VALUE;
		for (int i = 0; i < p; i++) {
			input[i] = in.nextInt();
			max = Math.max(input[i], max);
		}

		long[] result = getWays(max);
		
		for (int i = 0; i < p; i++) {
			System.out.println(result[input[i]-1]);
		}
		in.close();
	}

	public static long[] getWays(int max) {
		long[] table = new long[max];
		table[0] = 1;
		table[1] = 2;
		table[2] = 4;
		for (int i = 3; i < max; i++) {
			table[i] = table[i-1] + table[i-2] + table[i-3];
		}
		return table;
	}
}