package com.prem.dp;

import com.prem.util.CodeUtil;

public class WaysToReachEnd {

  /**
   * we have to find no. of ways to reach from top-left corner to
   * right-down corner.
   * only down and right move is allowed
   *
   * fill first row and first column
   *  start to add up and left in current
   *
   *   1 | 1 | 1 |
   *   1 | 2 | 3 |
   *   1 | 3 | 6 |
   */
  public int noOfWaysToReachRightDownCorner(int[][] board) {
    //filling first row and first column 1
    for(int i=0;i<board[0].length;i++){
      board[0][i]=1;
      board[i][0]=1;
    }

    for(int j=1;j<board.length;j++){
      for(int i=1;i<board[0].length;i++){
        board[j][i]=board[j-1][i]+board[j][i-1];
      }
    }
    CodeUtil.display2dMatrix(board);

    return board[board.length-1][board[0].length-1];
  }

  public static void main(String[] args) {
    int[][] board= new int[3][3];
    WaysToReachEnd wrte= new WaysToReachEnd();
    System.out.println(wrte.noOfWaysToReachRightDownCorner(board));

  }
}