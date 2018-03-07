package com.prem.stringop;

/**
 * O(m+n) -> where m is length of substring and n is length of main string
 *
 *  start to match from text and pattern first character
 *  if matches then increment both
 *  else
 *    we'll have to start pattern text matching from start from text current index
 *    but we'll take help from pattern computed array
 *
 *    send pattern index to pattern[
 *
 *    if substring and text is matching
 *          keep incrementing both index
 *    else
 *      put substring index to pattern[p-1] index
 *      ( it means now you'll have to start substring matching from this index to
 *      main string current index)
 */
public class KMP {

  //a b a a b a a a
  //    a a b a a
  //    0 1 0 1 2
  public int findSubString(int[] preSufMatch, char[] text,char[] subString){
    int t=0;
    int p=0;
    while (t < text.length && p<subString.length) {
      if(text[t]==subString[p]){
        t++;p++;
      }
      else{
        if(p!=0) {
          p = preSufMatch[p - 1];
        }
        else{
          t++;
        }
      }
    }
    return t-subString.length;
  }


  public static void main(String[] args) {
    //char[] text= "abcdabca".toCharArray();
    char[] text= "abaabaaa".toCharArray();
    char[] patternText="aabaa".toCharArray();
    KMP kmp= new KMP();
    int[] pattern = PrefixSuffixSameLength.createPattern(patternText);
    System.out.println("Pattern []: ");
    for(int k:pattern)
      System.out.print(k+" ");
    System.out.print("\nresult:");
    System.out.print(kmp.findSubString(pattern, text,patternText));
/*
*/
  }

}
