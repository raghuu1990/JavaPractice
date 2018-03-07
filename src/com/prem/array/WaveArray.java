package com.prem.array;

import java.util.Arrays;

/**
 * given array
 * make this array to a1> a2 < a3 > a4 < a5
 */
public class WaveArray {

  public static void main(String[] args) {
    int[] arr={1,2,3,4,5,6,7,8};
    WaveArray wa= new WaveArray();
    System.out.println(Arrays.toString(wa.waveArray(arr)));
  }

  /**
   * input : [1, 2, 3, 4, 5, 6, 7, 8]
   * output: [2, 1, 4, 3, 6, 5, 8, 7]
   *
   * iterate from start to end
   * at odd position do two steps
   *    if arr[i] > arr[i-1]  -> then swap
   *    if arr[i] < arr[i+1]  -> then swap
   * increment
   *
   */
  public int[] waveArray(int[] array){
    int i=0;
    while(i<array.length){
      if(i%2!=0){
        if(i-1>=0 && array[i]>array[i-1]){
          swap(array,i,i-1);
        }
        if(i+1<array.length && array[i]>array[i+1]){
          swap(array,i,i+1);
        }
      }
      i++;
    }

    return array;
  }

  public void swap(int[] arr,int i,int j){
    int temp=arr[i];
    arr[i]=arr[j];
    arr[j]=temp;
  }
}
