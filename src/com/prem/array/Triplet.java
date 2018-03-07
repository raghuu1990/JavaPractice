package com.prem.array;

import java.util.Arrays;

/**
 * find triplet in the array having pythagorus relation
 * a^2 = b^2+c^2
 * i.e. 3^2 + 4^2 = 5^2 => 9+16=25
 *
 */
public class Triplet {

  /**
   * first sort the array
   *
   * create new array and put sq. of above array into it
   */
  public void findTriplet(int[] arr){
    // if size is less than 3 then it's not eligible
    if(arr.length<3){
      return;
    }
    Arrays.sort(arr);
    int sqr[] = new int[arr.length];
    // storing square of arr into sqr array
    for(int i=0;i<arr.length;i++){
      sqr[i]=arr[i]*arr[i];
    }
    /**
     * start from index from the last index.
     * start + next == last index
     *
     * in this way start to match if match print and break;
     * else increment start and next by 1;
     */
    for(int i=sqr.length-1;i>=2;i--){
      int first=0;
      int last=i-1;
      while(first<last){
        int lhs=sqr[first]+sqr[last];
        if(lhs==sqr[i]){
          System.out.println(arr[first]+","+arr[last]+","+arr[i]);break;
        }
        else if(lhs<sqr[i]) {
          first++;
        }
        else last--;
      }
    }

  }

  public static void main(String[] args) {
    int[] arr={1,2,3,6,5,6,4,8,9};
    Triplet triplet= new Triplet();
    triplet.findTriplet(arr);

  }
}