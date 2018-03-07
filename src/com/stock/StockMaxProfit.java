package com.stock;

import java.util.Scanner;

// https://www.hackerrank.com/challenges/stockmax

// Each day, you can buy one stock and sell any number of stocks that you own

public class StockMaxProfit {
	public static void main(String[] args) {
		Scanner in = new Scanner(System.in);
		int t = in.nextInt();
		long[] result = new long[t];
		for (int j = 0; j < t; j++) {
			int n = in.nextInt();
			long[] input = new long[n];
			for (int i = 0; i < n; i++) {
				input[i] = in.nextLong();
			}
			result[j] = getMaxProfit(input);
		}

		for (int i = 0; i < t; i++) {
			System.out.println(result[i]);
		}
		in.close();
	}

	public static long getMaxProfit(long[] prices) {
		int l = prices.length;
		long[] max = new long[l];

		Long maxValue = Long.MIN_VALUE;
		for (int i = l - 1; i >= 0; i--) {
			if (maxValue < prices[i]) {
				maxValue = prices[i];
			}
			max[i] = maxValue;
		}

		long maxProfit = 0;
		for (int i = 0; i < l; i++) {
			if (prices[i] < max[i]) {
				maxProfit += max[i] - prices[i];
			}
		}
		return maxProfit;
	}
}