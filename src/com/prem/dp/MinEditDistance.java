package com.prem.dp;

import com.prem.util.CodeUtil;

/**
 * Minimum operations required to convert vertical/row word to horizontal column word
 *
 * using add, remove, update operation
 *
 * first fill first row and column 0 -> N
 * coz ""(blank string) requires n no. of adding op to convert into word.
 *
 *  if w1[j]==w2[i]
 *        take 1 from above diagonally
 *  else
 *        take Min of left, up and diagonally
 */
public class MinEditDistance {
  /**
   *    _   B   U   L   K
   * _  0 | 1 | 2 | 3 | 4 |
   * B  1 | 0 | 1 | 2 | 3 |
   * O  2 | 1 | 1 | 2 | 3 |
   * O  3 | 2 | 2 | 2 | 3 |
   * K  4 | 3 | 3 | 3 | 2 |
   */
  public int createResult(char[] first,char[] second){
    int[][] matrix= new int[first.length+1][second.length+1];
    //filling first row and first column
    for(int i=0;i<second.length+1;i++){
      matrix[0][i]=i;
      matrix[i][0]=i;
    }
    int i=1,j=1;
    for(i=1;i<=first.length;i++){
      for(j=1;j<=second.length;j++){
        if(first[i-1]==second[j-1]){
          matrix[j][i]=matrix[j-1][i-1];
        }
        else{
                                // replace                  remove            insert
          matrix[j][i]=Math.min(matrix[j-1][i-1],Math.min(matrix[j][i-1],matrix[j-1][i]))+1;
        }
      }
    }
    CodeUtil.display2dMatrix(matrix);
    return matrix[i-1][j-1];
  }


  public static void main(String[] args) {
    MinEditDistance med= new MinEditDistance();
    String word1="hope";
    String word2="home";
    String word3="host";
    System.out.println("Min Edit required:"+med.createResult(word1.toCharArray(), word3.toCharArray()));
  }
}