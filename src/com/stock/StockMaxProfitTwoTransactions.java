package com.stock;

// http://www.geeksforgeeks.org/maximum-profit-by-buying-and-selling-a-share-at-most-twice/

// Day prices are given, Allowed to make at most 2 transactions in a day, 
// where as second transaction can only start after first one is complete (Sell->buy->sell->buy)

public class StockMaxProfitTwoTransactions {
	public static void main(String[] args) {
		// long price[] = { 2, 30, 15, 10, 8, 25, 80 };
		// long price[] = {10, 22, 5, 75, 65, 80};
		// long price[] = {100, 30, 15, 10, 8, 25, 80};
		 long price[] = {90, 80, 70, 60, 50};
		System.out.println(getMaxProfit(price));
	}

	public static long getMaxProfit(long[] prices) {
		int n = prices.length;
		long[] profit = new long[n];

		for (int i = 0; i < n; i++) {
			profit[i] = 0;
		}

		Long maxValue = prices[n-1];
		for (int i = n - 2; i >= 0; i--) {
			if (maxValue < prices[i]) {
				maxValue = prices[i];
			}
			profit[i] = Math.max(maxValue - prices[i], profit[i + 1]);
		}

		Long minValue = prices[0];
		for (int i = 1; i < n; i++) {
			if (minValue > prices[i]) {
				minValue = prices[i];
			}
			profit[i] = Math.max(profit[i - 1], profit[i] + prices[i] - minValue);
		}

		return profit[n - 1];
	}
}