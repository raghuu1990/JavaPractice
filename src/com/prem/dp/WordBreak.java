package com.prem.dp;

import java.util.Arrays;
import java.util.List;

import com.prem.util.CodeUtil;

public class WordBreak {

  /**
   * You have been given a word i.e. iammat
   * and a dictionary : "i","a","am","at","mat"
   * you need to tell, word can be broke into small words present in dictionary
   *
   * To move diagonally use i+j in innerloop to iterate
   *
   *  i to i+j gives you word from 1->2->3 of word length in each iteration
   *
   *  # first we'll check if i to i+j word is in dictionary or not
   *  # if not then check if i to k and k to i+j both word exist or not
   *
   *
   *     i   a   m   m   a   t
   *  i  T | T | T | F | F | T
   *  a  _ | T | T | F | F | T
   *  m  _ | _ | F | F | F | F
   *  m  _ | _ | _ | F | F | T
   *  a  _ | _ | _ | _ | T | T
   *  t  _ | _ | _ | _ | _ | F
   *
   */
  public boolean isWordBreakValid(char[] word) {

    List<String> dic = Arrays.asList("i","a","am","at","mat");
    boolean[][] matrix = new boolean[word.length][word.length];

    for(int j=0;j<word.length;j++) {
      for(int i=0;i+j<word.length;i++) {
        String current=String.valueOf(Arrays.copyOfRange(word,i,i+j+1));//iammat
        if (dic.contains(current)) {
          matrix[i][i+j]=true;
        }
        else if(j>0){
          for(int k=0;i+k<i+j;k++){ //i -> k and k+1 -> i+j
            if(matrix[i][i+k] && matrix[i+k+1][i+j]){
              matrix[i][i+j]=true;
            }
          }
        }
      }
    }
    CodeUtil.display2dMatrix(matrix);
    return matrix[0][word.length-1];
  }

  public static void main(String[] args) {
    WordBreak wb= new WordBreak();
    System.out.println(wb.isWordBreakValid("iammat".toCharArray()));
  }

}
