package com.prem.dp;

import java.util.Arrays;

import com.prem.util.CodeUtil;

public class PalindromePartition {

  /**
   *    B   A   N   A   N   A
   * B  1 | 0 | 0 | 0 | 0 | 0 |
   * A  0 | 1 | 0 | 1 | 0 | 1 |
   * N  0 | 0 | 1 | 0 | 1 | 0 |
   * A  0 | 0 | 0 | 1 | 0 | 1 |
   * N  0 | 0 | 0 | 0 | 1 | 0 |
   * A  0 | 0 | 0 | 0 | 0 | 1 |
   */
  public int[][] palid(char[] word) {
    int[][] matrix = new int[word.length][word.length];

    for(int j=0;j<word.length;j++){
      for(int i=0;i+j<word.length;i++){
        if(word[i]==word[i+j]){
          if(j<=1) {
            matrix[i][i + j] = 1;
          }
          else{
            if(matrix[i+1][i+j-1]==1){
              matrix[i][i + j] = 1;
            }
          }
        }
      }
    }

    CodeUtil.display2dMatrix(matrix);
    return matrix;
  }
  /**
   *    B   A   N   A   N   A
   * B  1 | 0 | 0 | 0 | 0 | 0 |
   * A  0 | 1 | 0 | 1 | 0 | 1 |
   * N  0 | 0 | 1 | 0 | 1 | 0 |
   * A  0 | 0 | 0 | 1 | 0 | 1 |
   * N  0 | 0 | 0 | 0 | 1 | 0 |
   * A  0 | 0 | 0 | 0 | 0 | 1 |
   */
  /**
   * take a min cut array of word length
   *
   * fill all matrix by Integer.Max
   *
   *  if matrix[0][wordpos]=1 means that word is palindrome already-> no cuts required
   *    cut[i] = 0
   *  else
   *    start from cut[i+1] pos to wordpos where i=0
   *      Ex- B  A  N  A <- wordPos      | B [A  N  A] -> 1 cut required
   *          i i+1
   *        check in matrix[i+1][wordPos] -> ANA which will be palindrome and 1 value in matrix
   *      So, cuts[i] -> cuts[i]+1 -> 0 + 1
   *
   * if from i+1 to wordlen word is palindrome then
   *      0 -> i | i+1 -> wordlen (cuts[i+1] will be 1 more cuts required up to cuts[i]
   * and update if its less than current no. of cuts
   *
   *
   * Min Cuts Array:[0, 1, 2, 1, 2, 1]
   */
  public int minNoOfCuts(char[] word,int[][] matrix){
    int cuts[]=new int[word.length];
    for(int wordLen=0;wordLen<word.length;wordLen++){
      cuts[wordLen]=Integer.MAX_VALUE;
      if(matrix[0][wordLen]==1){
        cuts[wordLen]=0;
      }
      else{
        for(int i=0;i<wordLen;i++){
          if(matrix[i+1][wordLen]==1 && cuts[i]+1<cuts[wordLen]){
            cuts[wordLen]=cuts[i]+1;
          }
        }
      }
    }

    System.out.println("Cuts Array :"+Arrays.toString(cuts));
    return cuts[word.length-1];

  }

  public static void main(String[] args) {
    PalindromePartition palin= new PalindromePartition();
    char[] word="banana".toCharArray();
    int[][] palinMatrix= palin.palid(word);
    System.out.println("Min no. of cuts required:"+palin.minNoOfCuts(word, palinMatrix));
  }
}
