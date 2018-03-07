package com.prem.dp;

/**
 * Minimum coins required to make a sum of rupee.
 *
 * Given Coins : {1,2,5,6,8}
 * Sum of rupees required : 11 rupee
 *
 * Result:
 * min 2 coins required : 5,6
 *
 * 	1. create one extra row and column
 * 		fill first row with max
 *
 * 	start from first row and first column
 * 		if sumvalue>=coinValue then
 * 			get min of (one above, go row's coin value left + 1)
 * 	    else
 * 	    	get above value
 *
 * # Note if we have provision of repeating same thing then go left in same row otherwise go left in above row
 */
public class CoinChange {
	
	
	public static void main(String[] args) {
		int totalSum=11;
		int[] coins={1,2,5,6,8};
		
		int matrix[][] = createMatrix(coins, totalSum);
		for(int i=1;i<=totalSum;i++) {
			System.out.println("\nTotal coins required to make " + i + " rupees :" + matrix[i][coins.length]);
			System.out.print("Coins are:");
			bottomUp(matrix, i, coins);
		}
	}

  /**       0 |1 |2 |3 |4 |5 |6 |7 |8 |9 |10|11|  (Total sum colums)
   *	    ____________________________________
   *	    0 |mx|mx|mx|mx|mx|mx|mx|mx|mx|mx|mx|
   *	1	0 |1 |2 |3 |4 |5 |6 |7 |8 |9 |10|11|
   *	2	0 |1 |1 |2 |2 |3 |3 |4 |4 |5 |5 |6 |
   *	5	0 |1 |1 |2 |2 |1 |2 |2 |3 |3 |2 |3 |
   *	6	0 |1 |1 |2 |2 |1 |1 |2 |2 |3 |2 |2 |
   *	8	0 |1 |1 |2 |2 |1 |1 |2 |1 |2 |2 |2 |
   *
   */

	public static int[][] createMatrix(int coins[],int totalSum){
		int sumLen=totalSum+1;
		int coinLen=coins.length+1;
		
		int matrix[][]=new int[sumLen][coinLen];
		
		for(int i=1;i<sumLen;i++){
			matrix[i][0]=Integer.MAX_VALUE;
		}
		
		for(int j=1;j<coinLen;j++){   // iterate coins
			for(int i=1;i<sumLen;i++){// iterate total sum value
				if(i>=coins[j-1]){   // if total sum is equal or greater than coins value, take min (upper, (sumvalue-coinValue)+1);
					matrix[i][j]=Math.min(matrix[i][j-1], matrix[i-coins[j-1]][j]+1);
				}
				else{
					matrix[i][j]=matrix[i][j-1]; // if total sum is less than coins value take upper value;
				}
			}
		}
		display(matrix);
		return matrix;

	}

	/**     0 |1 |2 |3 |4 |5 |6 |7 |8 |9 |10|11|  (Total sum colums)
	 *	    ____________________________________
	 *	    0 |mx|mx|mx|mx|mx|mx|mx|mx|mx|mx|mx|
	 *	1	0 |1 |2 |3 |4 |5 |6 |7 |8 |9 |10|11|
	 *	2	0 |1 |1 |2 |2 |3 |3 |4 |4 |5 |5 |6 |
	 *	5	0 |1 |1 |2 |2 |1 |2 |2 |3 |3 |2 |3 |
	 *	6	0 |1 |1 |2 |2 |1 |1 |2 |2 |3 |2 |2 |
	 *	8	0 |1 |1 |2 |2 |1 |1 |2 |1 |2 |2 |2 |
	 *
	 *  while doing bottom up keep moving upside if sumValue matches one up field value
	 *  other move left by row's coins value.
	 */
	public static void bottomUp(int[][] resultMatrix,int sumValue,int[]coins){
		int i=sumValue;
		int j=coins.length;
		while(i!=0) {
			if (resultMatrix[i][j] == resultMatrix[i][j - 1]) {
				j=j-1;
			}
			else{
				System.out.print(coins[j-1] +",");
				i=i-coins[j-1];
			}
		}
	}

	public static void display(int[][] matrix) {
		for (int j = 0; j < matrix[0].length; j++) {
			for (int i = 0; i < matrix.length; i++) {
				System.out.print(matrix[i][j] + " |");
			}
			System.out.println();
		}
	}
}