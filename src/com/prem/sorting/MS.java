package com.prem.sorting;

/**
 * Created by lovebharti on 12/8/16.
 */
public class MS {


  public void first(int[] arr, int low, int high){
    int middle= (low+high)/2;
    if(low>=high) {
      return;
    }
      first(arr,low,middle);
      first(arr,middle+1,high);
      merge(arr,low,high);
    }

  public void merge(int[] arr,int low,int high){
    int temp[] = new int[high-low+1];
    int middle=(low+high)/2;
    int i=low;
    int j=middle+1;
    int count=0;

    while((i<=middle) && j<=high){
      if(arr[i]<arr[j]){
        temp[count++]=arr[i++];
      }
      else{
        temp[count++]=arr[j++];
      }
    }
    while(i<=middle){
      temp[count++]=arr[i++];
    }
    while(j<=high){
      temp[count++]=arr[j++];
    }
    for(int k=0;k<temp.length;k++){
      arr[low++]=temp[k];
    }
  }

  public static void main(String[] args) {
    MS ms= new MS();
    int[] arr= new int[]{26,25,24,23,22,21,20};
    ms.first(arr,0,arr.length-1);
    for(int i=0;i<arr.length;i++){
      System.out.println(arr[i]);
    }
    System.out.println(arr);
  }
}