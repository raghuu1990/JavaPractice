package com.prem.dp;

import com.prem.util.CodeUtil;

/**
 * A word and a pattern is given
 * find if word is matched by pattern.
 */
public class  WildCardMatching {

  /**
   *     ""  _   r   _   m   *   m
   *  "" T | F | F | F | F | F | F |
   *  p  F | T | F | F | F | F | F |
   *  r  F | F | T | F | F | F | F |
   *  e  F | F | F | T | F | F | F |
   *  m  F | F | F | F | T | T | F |
   *  i  F | F | F | F | F | T | F |
   *  u  F | F | F | F | F | T | F |
   *  m  F | F | F | F | F | T | T |
   *
   *  if word's character and pattern's character matches or pattern contains "_"
   *  then take one from above left diagonal
   *
   *  if pattern's character is "*" then
   *    true -> either of left or above is true
   *
   */
  public boolean matches(char[] word, char[] pattern) {
    boolean matrix[][] = new boolean[word.length + 1][pattern.length + 1];

    matrix[0][0]=true;

    for(int j=1;j<=word.length;j++) {
      for(int i=1;i<=pattern.length;i++) {
        if(word[j-1]==pattern[i-1]||pattern[i-1]=='_'){
          matrix[j][i]=matrix[j-1][i-1];
        }
        else if(pattern[i-1]=='*'){
          matrix[j][i]=matrix[j-1][i]||matrix[j][i-1];
        }
      }
    }
    CodeUtil.display2dMatrix(matrix);
    return matrix[word.length][pattern.length];
  }

  public static void main(String[] args) {
    WildCardMatching wcm= new WildCardMatching();
    char[] word = "premium".toCharArray();
    char[] pattern = "_r_m*m".toCharArray();
    System.out.println(wcm.matches(word, pattern));
  }
}