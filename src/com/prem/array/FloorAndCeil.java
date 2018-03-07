package com.prem.array;

/**
 * Created by lovebharti on 22/9/16.
 */
public class FloorAndCeil {

//        int input[] = {1,2,5,6,11,15};

  public int getFloor(int num,int[] arr,int low, int high){
    int mid=(low+high)/2;
    if((mid==0 && arr[mid]<num)||(mid==arr.length-1 && num<arr[mid])){
      return arr[mid];
    }

    if(arr[mid]>=num){

      high=mid-1;
    }
    else{
      low=mid+1;
    }

  return  -1;

  }

}
