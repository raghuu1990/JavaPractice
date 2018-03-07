package com.prem.array;

/**
 * given array : {3,5,4,2};
 *
 * find maximum index difference -> j-i   where arr[i]<arr[j]
 *
 * ex- 3,5   j-i =1
 * ex- 3,4   j-i =2, right answer
 */
public class MaximumIndex {

  /**
   *
   * create Separate MinArray and MaxArray
   * take i to minArray and j to maxArray
   *
   * if minArray[i]<minArray[j]  -> increment j and update j-i (max index diff)
   * else increment i
   */
  public static int maximumIndex(int arr[]){
    int[] minArr=MinMaxArray.makeMinArray(arr);
    int[] maxArr=MinMaxArray.makeMaxArray(arr);

    int i=0,j=0,maxDiff=-1;
    while(i<arr.length && j<arr.length){
      if(minArr[i]<maxArr[j]){
        maxDiff=Math.max(maxDiff,j-i);
        j++;
      }
      else{
        i++;
      }
    }
    return maxDiff;
  }


  public static void main(String[] args) {
    int[] arr= {3,5,4,2};
    System.out.println(maximumIndex(arr));
  }
}