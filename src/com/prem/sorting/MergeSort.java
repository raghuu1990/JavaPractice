package com.prem.sorting;

/**
 * Created by lovebharti on 14/1/17.
 */
public class MergeSort {
  public static void main(String[] args) {
    //int[] arr = {5, 3, 9, 1, 0, 8};
    int[] arr = {1,20,6,4,5};

    MergeSort ms= new MergeSort();
//    ms.mergeSort(arr,0,arr.length-1);
//    System.out.println(Arrays.toString(arr));

    int count=ms.mergeSortInversionCount(arr,0,arr.length-1);
    System.out.println(count);

  }

  public void mergeSort(int[] arr, int low ,int high){
    if(low>=high) return;

    int mid=(low+high)/2;
    mergeSort(arr,low,mid);
    mergeSort(arr,mid+1,high);
    merge(arr,low,high);
  }

  public void merge(int[] arr, int low, int high){
    int i=low;
    int mid= (high+low)/2;
    int j=mid+1;
    int temp[] = new int[high-low+1];
    int k=0;
    while(i<=mid && j<=high){
      if(arr[i]<arr[j]){
        temp[k++]=arr[i++];
      }
      else {
        temp[k++]=arr[j++];
      }
    }

    if(i<=mid){
      temp[k++]=arr[i++];
    }
    if(j<=high){
      temp[k++]=arr[j++];
    }

    for(k=0;k<temp.length;k++){
      arr[low++]=temp[k];
    }
  }

  public int mergeSortInversionCount(int[] arr, int low ,int high){
    if(low>=high) return 0;
    int inversCount=0;
    int mid=(low+high)/2;
    inversCount=mergeSortInversionCount(arr,low,mid);
    inversCount+=mergeSortInversionCount(arr,mid+1,high);
    inversCount+=mergeInversion(arr,low,high);
    return inversCount;
  }

  public int mergeInversion(int[] arr, int low, int high){
    int inversCount=0;

    int i=low;
    int mid= (high+low)/2;
    int j=mid+1;
    int temp[] = new int[high-low+1];
    int k=0;
    while(i<=mid && j<=high){
      if(arr[i]<arr[j]){
        temp[k++]=arr[i++];
      }
      else {
        temp[k++]=arr[j++];
        inversCount+= mid - i +1;
      }
    }

    if(i<=mid){
      temp[k++]=arr[i++];
    }
    if(j<=high){
      temp[k++]=arr[j++];
    }

    for(k=0;k<temp.length;k++){
      arr[low++]=temp[k];
    }
    return inversCount;
  }

}
