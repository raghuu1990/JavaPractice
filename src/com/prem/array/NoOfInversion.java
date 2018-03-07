package com.prem.array;

import java.util.Arrays;

public class NoOfInversion {

  static int[] array=new int[]{5,1,6,2,3};

  public static void main(String[] args) {

    int[] indexes= new int[array.length];
    int count=0;
    //int[] maxArray= getMaxFromLeft(array);
    //System.out.println(Arrays.toString(maxArray));
    System.out.println(Arrays.toString(array));
    for(int i=1;i<array.length;i++){
      int k=i-1;
      while(array[i]<array[indexes[k]]){

        count++;
//        indexes[i]=k-1;

        if(k==0) break;
        k=indexes[k-1];
      }
    }

    System.out.println(count);


  }

  public static int[] getMaxFromLeft(int[] arr){
    for(int i=1;i<arr.length;i++){
      if(arr[i]<arr[i-1]){
        arr[i]=arr[i-1];
      }
    }
    return arr;
  }

}
