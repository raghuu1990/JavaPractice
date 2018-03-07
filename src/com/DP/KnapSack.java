package com.DP;

public class KnapSack {
	public static void main(String[] args) {
		int value[] = { 120, 100, 60 };
		int weight[] = { 30, 20, 10 };
		int maxWeight = 50;
		int result1 = knapSackDP(value, weight, maxWeight);
		System.out.println(result1);

		int result2 = knapSackRecursion(value, weight, maxWeight, value.length);
		System.out.println(result2);
	}

	private static int knapSackDP(int[] value, int[] weight, int maxWeight) {
		int n = value.length;
		int[][] dp = new int[n + 1][maxWeight + 1];

		for (int i = 0; i <= n; i++) {
			for (int w = 0; w <= maxWeight; w++) {
				if(i==0 || w==0) {
					dp[i][w] = 0;
				} else if(weight[i-1]<=w) {
					dp[i][w] = Math.max(value[i-1] + dp[i-1][w-weight[i-1]], dp[i-1][w]);
				} else {
					dp[i][w] = dp[i-1][w];
				}
			}
		}
		return dp[n][maxWeight];
	}

	static int knapSackRecursion(int value[], int weight[], int maxWeight, int n) {
		if (n == 0 || maxWeight == 0) {
			return 0;
		}

		// If weight of the nth item is more than Knapsack capacity W, then
		// this item cannot be included in the optimal solution
		if (weight[n - 1] > maxWeight) {
			return knapSackRecursion(value, weight, maxWeight, n - 1);

			// Return the maximum of two cases:
			// (1) nth item included
			// (2) not included
		} else {
			return Math.max(value[n - 1] + knapSackRecursion(value, weight, maxWeight - weight[n - 1], n - 1),
					knapSackRecursion(value, weight, maxWeight, n - 1));
		}
	}
}
