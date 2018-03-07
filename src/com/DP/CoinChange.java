package com.DP;

import java.util.Scanner;

// https://www.hackerrank.com/challenges/coin-change/problem
// O(m*n)

public class CoinChange {
	public static void main(String[] args) {
		Scanner in = new Scanner(System.in);
		int sum = in.nextInt();
		int count = in.nextInt();
		int[] arr = new int[count];
		for (int i = 0; i < count; i++) {
			arr[i] = in.nextInt();
		}
		long ways = getWaysDP(sum, arr, count);
		System.out.println(ways);
		in.close();
	}

	public static long getWaysDP(int sum, int[] arr, int index) {
		long[] table = new long[sum + 1];
		table[0] = 1;
		for (int i = 0; i < index; i++) {
			int coinCost = arr[i];
			for (int j = coinCost; j <= sum; j++) {
				table[j] += table[j - coinCost];
			}
		}
		return table[sum];
	}
	
	public static int getWays(int sum, int[] arr, int index) {
		if (sum == 0) {
			return 1;
		}
		if (sum < 0) {
			return 0;
		}
		if (index <= 0 && sum >= 1) {
			return 0;
		}
		return getWays(sum, arr, index - 1) + getWays(sum - arr[index - 1], arr, index);
	}
}