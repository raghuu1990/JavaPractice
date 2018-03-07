package com.prem.array;

import java.util.Arrays;

public class InversionCount {

//  static int count=0;
  public static void main(String[] args) {
    InversionCount ic= new InversionCount();
    //int[] array= new int[]{1,9,4,3,8,6};
    int[] array= new int[]{5,1,6,2,3};
    //int[] array= new int[]{3,9,1,8,4,5,0};
    System.out.println(ic.mergeSort(array,0,array.length-1));
    System.out.println(Arrays.toString(array));
    //System.out.println(count);
  }

  public int mergeSort(int[] array, int low, int high){
    int count=0;
    if(low<high){
      int mid= (low+high)/2;
      count=mergeSort(array,low,mid);
      count+=mergeSort(array,mid+1,high);
      count+=merge(array,low,high);
    }
    return count;
  }

  public int merge(int[] array,int low, int high){
    int inversion=0;
    int middle=(low+high)/2;
    int i=low;
    int j=middle+1;
    int k=0;
    int temp[] = new int[high-low+1];

    while(i<=middle && j<=high){
      if(array[i]<array[j]){
        temp[k++]=array[i++];
      }
      else{
        inversion+=middle-i;  //tricky part
        temp[k++]=array[j++];
      }
    }
    while(i<=middle){
      temp[k++]=array[i++];
      //count++;
    }
    while(j<=high){ temp[k++]=array[j++];}

    for(k=0;k<temp.length;k++){
      array[low++]=temp[k];
    }
    return inversion;
  }
}
