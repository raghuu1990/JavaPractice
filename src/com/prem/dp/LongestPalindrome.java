package com.prem.dp;

import com.prem.util.CodeUtil;

public class LongestPalindrome {

  /**
   *    B   A   N   A   N   A
   * B  1 | 0 | 0 | 0 | 0 | 0 |
   * A  0 | 1 | 0 | 1 | 0 | 1 |
   * N  0 | 0 | 1 | 0 | 1 | 0 |
   * A  0 | 0 | 0 | 1 | 0 | 1 |
   * N  0 | 0 | 0 | 0 | 1 | 0 |
   * A  0 | 0 | 0 | 0 | 0 | 1 |
   *
   * i goes down and i+j goes right
   *
   *  first take one lenght for each character in word {B,A,N,A,N,A}
   *      diagonal will filled with 1
   *  take 2 character each then {ba,an,na,an,na}
   *  match every first and last character if matches then it's palindrome if below condition matches:
   *    increment first by one (i+1) and decrement last by 1 (i+j-1)
   *      and check if it was palindrome
   *
   *      Ex - ANA
   *     first  A -> A (last)
   *        then check for N -> which is already true
   *
   *      Ex - ANANA
   *     first  A -> A (last)
   *        then check for ANA which is already true
   */
  public int palid(char[] word) {
    int[][] matrix = new int[word.length][word.length];

    int maxLen=0;

    for(int j=0;j<word.length;j++){
      for(int i=0;i+j<word.length;i++){
        if(word[i]==word[i+j]){
          if(j<=1) {
            matrix[i][i + j] = 1;
            if(j+1>maxLen) maxLen=j+1;
          }
          else{
            if(matrix[i+1][i+j-1]==1){
              matrix[i][i + j] = 1;
              if(j+1>maxLen) maxLen=j+1;
            }
          }
        }
      }
    }

    CodeUtil.display2dMatrix(matrix);
    return maxLen;
  }

  public static void main(String[] args) {
    LongestPalindrome lp = new LongestPalindrome();
    System.out.println("Longest Palindrome:"+lp.palid("banana".toCharArray()));
    System.out.println("Longest Palindrome:"+lp.palid("aaaa".toCharArray()));
  }
}
