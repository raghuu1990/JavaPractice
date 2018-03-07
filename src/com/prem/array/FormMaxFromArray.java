package com.prem.array;

import java.util.Arrays;
import java.util.Comparator;

/**
 *
 * arr= {3,30,34,5,9}
 * return such that when will concatenated will form maximum no. from array
 * output:
 * 9 5 34 3 30
 */
public class FormMaxFromArray {

  public static void main(String[] args) {
    Integer[] arr={3,30,34,5,9};
    Arrays.sort(arr,new StringComparator());

    String a="a";
    String b="b";
    //System.out.println(a.co);
    System.out.println(Arrays.toString(arr));
  }
}

class StringComparator implements Comparator<Integer>{
  @Override
  public int compare(Integer a, Integer b) {
    return (b+""+a).compareTo(a+""+b);
  }
}
