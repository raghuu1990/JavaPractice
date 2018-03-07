package com.prem.array;

import java.util.Arrays;

/**
 * We have given a number 2196, using same number
 * We need to find next greater element
 * i.e. 2691
 */
public class NextGreaterElement {

  /**
   * O(nlogn)
   *  2 1 9 6
   * start from last element to first
   *    when end element is found greater than next ( 1 <- 6)
   *    swap elements at end and index  -> 2 6 9 1
   *    and sort element after index  -> 2 6 (9 1) -> 2 6 1 9
   */
  public int[] next(int[] arr){
    if(arr.length<2){
      return arr;
    }

    int end=arr.length-1;
    int index=arr.length-2;
    while(index>=0){
      if(arr[end]>arr[index]){
        swap(arr,index,end);
        break;
      }
      index--;
    }
    Arrays.sort(arr,index+1,arr.length);
    return arr;
  }

  public void swap(int[] arr,int i, int j){
    int temp=arr[i];
    arr[i]=arr[j];
    arr[j]=temp;
  }

  public static void main(String[] args) {
    NextGreaterElement nge= new NextGreaterElement();
    int[] arr= {2,1,9,6};
    System.out.println(Arrays.toString(nge.next(arr)));
  }

}
