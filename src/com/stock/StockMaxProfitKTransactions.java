package com.stock;

//import com.prem.util.CodeUtil;

// http://www.geeksforgeeks.org/maximum-profit-by-buying-and-selling-a-share-at-most-k-times/

// Day prices are given, Allowed to make at most 2 transactions in a day, 
// where as second transaction can only start after first one is complete (Sell->buy->sell->buy)

public class StockMaxProfitKTransactions {
	public static void main(String[] args) {
		int k = 3;
		int price[] = {1, 2, 10, 0, 30, 35};
		// int price[] = { 90, 80, 70, 60, 50 };
		// int price[] = {2, 5, 7, 1, 4, 3, 1, 3};
		// int price[] = {10, 22, 5, 75, 65, 80};
		// int price[] = { 2, 30, 15, 10, 8, 25, 80 };
		// int price[] = {100, 30, 15, 10, 8, 25, 80};
		// int price[] = {100, 180, 260, 310, 40, 535, 695};
		System.out.println(getMaxProfit(price, k));
	}
	
	private static int getMaxProfit(int price[], int k){
		if (k == 0 || price.length == 0) {
            return 0;
        }

		int n = price.length;
		// Table to store results of subproblems matrix[t][i] stores maximum profit using
	    // atmost k transactions up to day i (including day i)
		int[][] matrix = new int[k + 1][n];

		// For day 0, you can't earn money irrespective of how many times you trade
		for (int i = 0; i <= k; i++) {
			matrix[i][0] = 0;
		}
		
		// profit is 0 if we don't do any transation (i.e. k =0)
		for (int j = 0; j < n; j++) {
			matrix[0][j] = 0;
		}

		// Fill the table in bottom-up fashion  //  O(k.n2)
		// matrix[t][i] will be maximum of –
	    //  1-  Profit[t][i-1] which represents not doing any transaction on the ith day. 
		// 	2-  Maximum profit gained by selling on ith day. In order to sell shares on ith day,
		// 		we need to purchase it on any one of [0, i – 1] days. If we buy shares on jth day and 
		//      sell it on ith day, max profit will be matrix[i] – price[j] + matrix[t-1][j] where j (0 to i-1).
		// 		Here matrix[t-1][j] is best we could have done with one less transaction till jth day.
		
		/*
		for (int i = 1; i <= k; i++) {
			for (int j = 1; j < n; j++) {
				int max_so_far = Integer.MIN_VALUE;
				for (int m = 0; m < j; m++) {
					max_so_far = Math.max(max_so_far, price[j] - price[m] + matrix[i - 1][m]);
				}
				matrix[i][j] = Math.max(matrix[i][j - 1], max_so_far);
			}
		}
		*/
		
		//  O(kn)
		for (int i = 1; i <= k; i++) {
			int prevDiff = Integer.MIN_VALUE;
			for (int j = 1; j < n; j++) {
				prevDiff = Math.max(prevDiff, matrix[i - 1][j - 1] - price[j - 1]);
				matrix[i][j] = Math.max(matrix[i][j - 1], price[j] + prevDiff);
			}
		}
		
		// CodeUtil.display2dMatrix(matrix);
		return matrix[k][n - 1];
	}
}