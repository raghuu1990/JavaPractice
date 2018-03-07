package com.prem.dp;

/**
 * Given different prices for cutting rod of different length
 * We need to sell rod in particular given meter in any length
 * in which maximum profit we can make.
 *
 * because we can take same length rod again and again, then
 *
 * take max of
 * 1. (required rod length - current rod length) price + current rod length price
 * 2. one above
 */
public class RodCutting {

  private int[]   len={1,2,3,4};
  private int[] price={2,5,7,8};
  private int totalLen=5;

  public static void main(String[] args) {
    RodCutting rc= new RodCutting();
    int[][] matrix=rc.createMatrix(rc.len,rc.price,rc.totalLen);
    rc.display(matrix);
    System.out.println("Maximum profit:"+matrix[rc.len.length][rc.totalLen]);
    System.out.println("Lengths of rod are:");
    rc.bottomUp(matrix,rc.len,rc.totalLen);
  }

  /**
   *              Rod length
   *           1 |2 |3 |4  |5  |
   *       ____________________
   *  P L | 0 |0 |0 |0 |0  |0  |
   *  2 1 | 0 |2 |4 |6 |8  |10 |
   *  5 2 | 0 |2 |5 |7 |10 |12 |
   *  7 3 | 0 |2 |5 |7 |10 |12 |
   *  8 4 | 0 |2 |5 |7 |10 |12 |
   */
  public int[][] createMatrix(int[] len, int[] price, int total){
    int totalLen=total+1;
    int entLen=len.length+1;

    int[][] matrix= new int[entLen][totalLen];

    for(int j=1;j<entLen;j++){
      for(int i=1;i<totalLen;i++){
        if(i>=len[j-1]){
          matrix[j][i]= Math.max(matrix[j][i-len[j-1]]+price[j-1],matrix[j-1][i]);
        }
        else{
          matrix[j][i]=matrix[j-1][i];
        }
      }
    }
    return matrix;
  }

  public void display(int matrix[][]){
    for(int j=0;j<matrix.length;j++){
      for(int i=0;i<matrix[0].length;i++){
        System.out.print(matrix[j][i]+" |");
      }
      System.out.println();
    }
  }

  public void bottomUp(int matrix[][],int len[],int totalLen){
    int i=price.length+1;
    int j=len.length;

    while(i!=0){
      if(matrix[j][i]==matrix[j-1][i]){
        j--;
      }
      else{
        System.out.print(len[j-1]+",");
        i=i-len[j-1];
      }
    }
  }
}