package com.prem.dp;

import com.prem.util.CodeUtil;

public class MinPathCost {

  /**
   *
   *  Player has to start from [0][0] pos to reach [n][n] with minimum cost.
   *
   *  path cost matrix (given)
   *  1 | 2 | 3
   *  4 | 8 | 2
   *  1 | 5 | 3
   *
   *  Constraint: you can move only down and right ward
   *
   *  So, reach from top or left having minimum cost to current position
   *
   *
   *  start filling from first row and first column sum in sum matrix
   *  from row[1] and col[1]
   *     check up or left -> min(up,left)+ current one
   *     and fill all matrix
   *
   *  1 | 3  | 6
   *  5 | 11 | 8    SUM MATRIX
   *  6 | 11 | 11
   *
   */
  public int getMin(int[][] cost,int row, int col){
    int[][] tempCompute = new int[cost.length][cost[0].length];
    int sum=0;
    for(int i=0;i<cost[0].length;i++){
      sum+=cost[0][i];
      tempCompute[0][i]=sum;
    }
    sum=0;
    for(int j=0;j<cost.length;j++){
      sum+=cost[j][0];
      tempCompute[j][0]=sum;
    }

    for(int j=1;j<cost.length;j++){
      for(int i=1;i<cost[0].length;i++){
        tempCompute[j][i]=cost[j][i]+Math.min(tempCompute[j-1][i],tempCompute[j][i-1]);
      }
    }

    CodeUtil.display2dMatrix(tempCompute);
    return tempCompute[cost.length-1][cost[0].length-1];
  }

  public static void main(String[] args) {

    int[][] cost={
        {1,2,3},
        {4,8,2},
        {1,5,3}
    };

    MinPathCost mpc= new MinPathCost();
    System.out.println("Min path cost:"+mpc.getMin(cost,2,2));
  }
}
