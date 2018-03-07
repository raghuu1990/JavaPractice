package com.prem.dp;

/**
 * at given max weight can be hold by bag get max price value you can get
 * given prices of each weight
 *
 * Maximise the profit keep in mind weight should not exceed threshold
 *
 *  int[] weights= {1,3,4,5};
 *  int[] prices = {1,4,5,7};
 *
 *
 *           Weight limit
 *       0 |1 |2 |3 |4 |5 |6 |7 |
 *       ________________________
 *       
 *  P W  0 |0 |0 |0 |0 |0 |0 |0 |   if we've 0 wt then price carried ->0 whatever wt limit is
 *  1 1  0 |1 |1 |1 |1 |1 |1 |1 |   if we've 1 wt and wt limit>=1 max price value -> 1
 *  4 3  0 |1 |1 |4 |5 |5 |5 |5 |   if we've 3 wt till wt limit<3 we can take only wt 1 (above)-> max price (1)
 *  5 4  0 |1 |1 |4 |5 |6 |6 |9 |
 *  7 5  0 |1 |1 |4 |5 |7 |8 |9 |
 *
 *       0 |1 |2 |3 |4 |5 |6 |7 |
 *       
 *  set first row and column 0 rs. (wt with 0 will have 0 price)
 *
 *  when columns weight >= weight[j]
 *    Max of (price [j-1][columns weight - weight[j-1]] + price[j], price[j-1][i]
 *    (one row above and go left to current col weight - current row weight)+ current price
 *
 *    else take above price.
 *
 *    # Note if we have provision of repeating same thing then go left in same row
 * 			otherwise go left in above row
 */

public class KnapSack {
	public static void main(String[] args) {
		int maxWeight = 7;
		int[] weights = { 1, 3, 4, 5 };
		int[] prices = { 1, 4, 5, 7 };
		
		int result = createMatrix(weights, prices, maxWeight);
		System.out.println("Maximum profit :" + result);
	}

	public static int createMatrix(int[] weights, int[] prices, int maxWeight) {
		int[][] matrix = new int[prices.length + 1][maxWeight + 1];
		for (int i = 0; i <= prices.length; i++) {
			for (int j = 0; j <= maxWeight; j++) {
				if (i == 0 || j == 0) {
					matrix[i][j] = 0;
				} else if (weights[i - 1] <= j) {
					matrix[i][j] = Math.max(prices[i - 1] + matrix[i - 1][j - weights[i - 1]], matrix[i - 1][j]);
				} else {
					matrix[i][j] = matrix[i - 1][j];
				}
			}
		}
		display(matrix);
		return matrix[weights.length][maxWeight];
	}

	public static void display(int[][] matrix) {
		for (int j = 0; j < matrix.length; j++) {
			for (int i = 0; i < matrix[0].length; i++) {
				System.out.print(matrix[j][i] + " |");
			}
			System.out.println();
		}
	}
}