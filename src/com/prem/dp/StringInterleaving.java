package com.prem.dp;

import com.prem.util.CodeUtil;

/**
 * Three words are given
 *
 * need to find if words3 and be formed by words1 and word2
 *
 *
 */
public class StringInterleaving {

  public boolean isInterleaving(char[] word1, char[] word2, char[] word3){
    boolean[][] matrix= new boolean[word1.length+1][word2.length+1];

    matrix[0][0]=true;

    for(int i=0;i<word2.length;i++) {
      if(word2[i]==word3[i]){
        matrix[0][i+1]=matrix[0][i];
      }
    }

    for(int j=0;j<word1.length;j++){
      if(word1[j]==word3[j]){
        matrix[j+1][0]=matrix[j][0];
      }
    }

    /**
     *
     * first check word1 with mainString (put in 0th column)
     * then check word2 with mainString(word3) (put in 0th row)
     *
     * if word1[i] or word2[j] matches with word3[i+j]
     *  then
     *    check if left or above is true
     *      then matrix[j][i]=true
     *
     *
     * word1={a,b,c}
     * word2={d,e,f}
     * word3={a,d,b,e,c,f}
     *
     * word3 ->  a   d   b  e  c  f
     *               (2)
     *       _   d   e   f
     *    _  T | F | F | F |
     *    a  T | T | F | F |
     *(1) b  F | T | T | F |
     *    c  F | F | T | T |
     *
     */

    for(int j=1;j<word1.length+1;j++) {
      for(int i=1;i<word2.length+1;i++) {
        if((word1[j-1]==word3[(j-1)+(i-1)])||(word2[i-1]==word3[(j-1)+(i-1)]) && (matrix[j-1][i] || matrix[j][i-1])){
          matrix[j][i]=true;
        }
      }
    }

    CodeUtil.display2dMatrix(matrix);

    return matrix[word1.length][word2.length];
  }

  public static void main(String[] args) {
    StringInterleaving si= new StringInterleaving();
    String word1 = "abx";
    String word2 = "def";
    String word3 = "adbexf";

    System.out.println("Is word3 interleaving of word1 and word2 -> "+si.isInterleaving(word1.toCharArray(), word2.toCharArray(), word3.toCharArray()));
  }
}