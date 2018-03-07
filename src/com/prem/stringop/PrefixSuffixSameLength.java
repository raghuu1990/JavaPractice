package com.prem.stringop;

import java.util.Arrays;

public class PrefixSuffixSameLength {

  /**
   * a a b a a
   * 0 1 0 1 2
   * j i
   * a a b a a
   * 0 1 0 1 2
   *   j i
   *
   * a  a  b  a  a
   * 0, 1, 0, 1, 2
   *
   * here pref -> aa   suff -> aa
   *
   * a b a b a
   * 0 0 1 2 3
   *
   * here pref -> aba , suff -> aba
   *  initially take i ahead of j
   *    if char at j and char at i matches
   *      increment both
   *    else
   *      put j at position as much string matched previously i.e. j=pattern[j-1]
   *      j should be greater than zero, so
   *         if j==0 put pattern[i]=0 and increment i
   *
   */
  public static int[] createPattern(char[] text){
    int j=0;
    int i=j+1;
    int pattern[] = new int[text.length];
    while(i<text.length){
      if(text[j]==text[i]){
        pattern[i]=j+1;
        i++;j++;
      }
      else{
        if(j==0){
          pattern[i]=0;
          i++;
        }
        if(j!=0) j=pattern[j-1];
      }
    }
    return pattern;
  }

  public static int maxPrefixSuffixSameLen(char[] text){
    int maxLen=0;
    int j=0;
    int i=j+1;
    int pattern[] = new int[text.length];
    while(i<text.length){
      if(text[j]==text[i]){
        pattern[i]=j+1;
        maxLen=Math.max(maxLen,pattern[i]);
        i++;j++;
      }
      else{
        if(j==0){
          pattern[i]=0;
          i++;
        }
        if(j!=0) j=pattern[j-1];
      }
    }
    return maxLen;
  }

  public static void main(String[] args) {
    System.out.println(Arrays.toString(PrefixSuffixSameLength.createPattern("aabaa".toCharArray())));
    System.out.println(PrefixSuffixSameLength.maxPrefixSuffixSameLen("aabaa".toCharArray()));
  }
}