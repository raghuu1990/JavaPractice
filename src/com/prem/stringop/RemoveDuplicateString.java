package com.prem.stringop;

import java.util.Arrays;

public class RemoveDuplicateString {

  /**
   * Complexity : O(n)
   * [a, a, e, e, h, h, n, n]
   * [a, e, h, n, _, _, _, _]
   *
   * index->slow->fast : three pointers required, slow will follow fast
   *
   * if slow and fast are same increment fast
   *
   * if slow and fast match keep incrementing fast
   * set char at index -> char at slow
   * increment index then
   */
  public char[] removeDuplicate(char[] word) {
    Arrays.sort(word);
    int slow=0;
    int fast=0;
    int index=0;
    while (fast < word.length) {
      while(fast<word.length && word[slow]==word[fast]){
        fast++;
      }
      word[index++]=word[slow];
      slow=fast;

    }

    while (index < word.length) {
      word[index++]='_';
    }

    return word;
  }

  public static void main(String[] args) {
    RemoveDuplicateString rds= new RemoveDuplicateString();
    char[] word="hheennaa".toCharArray();
    Arrays.sort(word);
    System.out.println(Arrays.toString(word));
    System.out.println(Arrays.toString(rds.removeDuplicate(word)));
  }
}