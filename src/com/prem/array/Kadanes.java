package com.prem.array;

public class Kadanes {

  /**
   * find subarray with largest sum -> find larger subarray if two subarray has equal sum
   * O(n)
   * No extra space
   *
   * take result -> min_value
   * start to add array from starting on tempMaxSum and update if exceeds result
   * if tempMaxSum < 0 then update with 0.
   *
   * result will give maxSum
   *
   * if result comes 0 then
   *    second case: if all having -ve with 0 or not
   *                 just check for larger element value
   *
   */
  public int maxSubArraySum(int[] arr){
    int result=Integer.MIN_VALUE;
    int maxSumCurrent=0;
    for(int i=0;i<arr.length;i++){
      maxSumCurrent+=arr[i];
      if(maxSumCurrent<0) maxSumCurrent=0;
      if(maxSumCurrent>result){
        result = maxSumCurrent;
      }
    }

    // Check for arr in case result comes 0, means having all -ve (included with 0 or not)
    if(result==0){
      int maxForNeg=Integer.MIN_VALUE;
      for(int i=0;i<arr.length;i++){
        if(arr[i]>maxForNeg){
          maxForNeg=arr[i];
        }
      }
      result=maxForNeg;
    }
    return result;
  }

  public static void main(String[] args) {
    int arr[]={5,-1,3,-2,-1,6,0,-1,4};
    Kadanes kd= new Kadanes();
    System.out.println(kd.maxSubArraySum(arr));
    int arr2[]={-5,-1,-3,-2,-1,-6,0,-1,-4};
    System.out.println(kd.maxSubArraySum(arr2));

    int arr3[]={-5,-1,-3,-2,-1,-6,-10,-1,-4};
    System.out.println(kd.maxSubArraySum(arr3));

  }
}
