package com.interview.array;

/**
 *         Best time to buy and sell stocks. 
 *         1) Only 1 transaction is allowed 
 *         2) Infinite number transactions are allowed
 *
 *         Time complexity O(n) Space complexity O(1)
 *
 *         https://leetcode.com/problems/best-time-to-buy-and-sell-stock/
 *         https://leetcode.com/problems/best-time-to-buy-and-sell-stock-ii/
 */
public class BuySellStockProfit {

	public static void main(String args[]) {
		int arr1[] = { 7, 10, 15, 5, 11, 2, 7, 9, 3 };
		int arr2[] = { 6, 4, 1, 3, 5, 7, 3, 1, 3, 4, 7, 9, 2, 5, 6, 0, 1, 2 };
		System.out.println(oneProfit(arr1));
		System.out.print(allTimeProfit(arr2));

	}

	public static int oneProfit(int arr[]) {
		int minPrice = arr[0];
		int maxProfit = Integer.MIN_VALUE;
		for (int i = 1; i < arr.length; i++) {
			if (arr[i] - minPrice > maxProfit) {
				maxProfit = arr[i] - minPrice;
			}
			if (arr[i] < minPrice) {
				minPrice = arr[i];
			}
		}
		return maxProfit;
	}

	public static int allTimeProfit(int arr[]) {
		if (arr.length == 0) {
			return 0;
		}
		int maxProfit = 0;
		int localMin = arr[0];
		for (int i = 1; i < arr.length; i++) {
			if (arr[i - 1] >= arr[i]) {
				localMin = arr[i];
			} else {
				maxProfit += arr[i] - localMin;
				localMin = arr[i];
			}

		}
		return maxProfit;
	}
}