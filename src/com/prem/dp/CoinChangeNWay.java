package com.prem.dp;

/**
 * No. of ways sum can be get using given no. of coins
 *
 * Given Coins : {1,2,5,8}
 * Sum of rupees required : 8 rupee
 *
 *  {1,1,1,1,1,1,1,1}
 *  {2,1,1,1,1,1,1}
 *  {2,2,1,1,1,1}
 *  {2,2,2,1,1}
 *  {2,2,2,2}
 *  {5,2,1}
 *  {5,1,1,1}
 *  {8}
 *
 * Result:
 * 8 ways to get sum of 8 rupee using {1,2,5,8}
 *
 * 	1. create one extra column
 * 		fill first row and first column with 1
 * 		    0 |1 |2 |3 |4 |5 |6 |7 |8
 *       1| 1 |1 |1 |1 |1 |1 |1 |1 |1 |
 *       2| 1 |1 |2 |2 |3 |3 |4 |4 |5 |
 *       5| 1 |1 |2 |2 |3 |4 |5 |6 |7 |
 *       8| 1 |1 |2 |2 |3 |4 |5 |6 |8 |
 *
 *
 *
 * 	start from first row and first column
 * 		if sumvalue>=coinValue then
 * 			get min of (one above, go row's coin value left + 1)
 * 	    else
 * 	    	get above value
 *
 */
public class CoinChangeNWay {


  public int[][] createTemp(int[] arr,int input){
    int[][] matrix= new int[arr.length][input+1];

    for(int i=0;i<input+1;i++){
      matrix[0][i]=1;
    }
    for(int j=0;j<arr.length;j++){
      matrix[j][0]=1;
    }

    for(int j=1;j<arr.length;j++){
      for(int i=1;i<input+1;i++){
        if(i>=arr[j]){
          matrix[j][i]=matrix[j][i-arr[j]]+matrix[j-1][i];
        }
        else{
          matrix[j][i]=matrix[j-1][i];
        }
      }
    }
    return matrix;
  }

  public int printMatrix(int[][] matrix){
    for(int j=0;j<matrix.length;j++){
      for(int i=0;i<matrix[0].length;i++){
        System.out.print(matrix[j][i]+" |");
      }
      System.out.println();
    }
    return matrix[matrix.length-1][matrix[0].length-1];
  }

  public static void main(String[] args) {
    int num[]={1,2,3};
    CoinChangeNWay cc = new CoinChangeNWay();
    int[][] matrix=cc.createTemp(num,4);
    System.out.println(cc.printMatrix(matrix));

  }

}
