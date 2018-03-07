package com.prem.array;

public class MinLenSubArray {

  /**
   * find minimum length of subarray whose sum is greater than given number k
   *
   * O(n)
   *
   * take start, end and currentSum , minLen
   *
   * start to add currentSum from first element
   * if currentSum less than then keep on adding
   * if exceeds
   *  update minLen and substract value from arr[start] from currentSum and start++
   */
  public int minLenSubArrayGreaterThanValueK(int[] arr, int k){
    int start=0,end=0;
    int currentSum=0;
    int minLen=arr.length+1;

    while(end<arr.length){
      if(currentSum<=k){
        currentSum+=arr[end++];
      }
      else{
        if(end-start<minLen){
          minLen=end-start;
        }
        currentSum-=arr[start++];
      }
    }
    if(currentSum<k){
      return -1;
    }
    return minLen;
  }

  public static void main(String[] args) {
    //int[] arr={1,4,45,6,0,19};
    int[] arr={1,10,5,2,7};
    MinLenSubArray mlsa= new MinLenSubArray();
    System.out.println(mlsa.minLenSubArrayGreaterThanValueK(arr,11));
  }

}
