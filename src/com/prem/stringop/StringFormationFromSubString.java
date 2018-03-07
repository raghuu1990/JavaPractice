package com.prem.stringop;

public class StringFormationFromSubString {

  public static void main(String[] args) {
    //String mainString="abcabcabc";
    String mainString="abcabcabcd";
    System.out.println(canStringMadeFromSubString(mainString));
  }

  public static boolean canStringMadeFromSubString(String str){
    int prefixSuffixSameLen=PrefixSuffixSameLength.maxPrefixSuffixSameLen(str.toCharArray());
    System.out.println(prefixSuffixSameLen);
    return str.length()%(str.length()-prefixSuffixSameLen)==0;
  }

}
