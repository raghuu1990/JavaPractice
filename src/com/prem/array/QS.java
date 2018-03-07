package com.prem.array;

/**
 * Created by lovebharti on 31/8/16.
 */
public class QS {

  public int qs(int arr[], int low, int high, int kth){

    int pv= pos(arr,low,high);

     qs(arr, pv + 1, high,kth);
      qs(arr,low,pv-1,kth);


/*
    if(pv==kth) return arr[pv];

    if(kth>pv){
      return qs(arr,pv+1,high,kth);
    }
    else if(kth<pv){
      return qs(arr,low,pv-1,kth);
    }
*/
    return 0;
  }



  public int pos(int num[],int low, int high){
    int i=low+1;
    int j=high;
    int pv=low;

    while(i<j){
      while(num[i]<num[pv] && i<=j){
        i++;
      }
      while(num[j]>num[pv] && j>=i){
        j--;
      }
      if(i<j){
        swap(num,i,j);
      }

    }

    if(num[pv]>num[j]){
      swap(num,pv,j);
    }
    return j;
  }

  public void swap(int[] arr,int i, int j){
    int temp=arr[j];
    arr[j]=arr[i];
    arr[i]=temp;
  }

  public static void main(String[] args) {
    int[] nums={4,1,6,2,9,7,0};
    QS qs= new QS();
    int k=7;
    qs.qs(nums,0,nums.length,k-1);
    for(int i:nums){
      System.out.print(i+", ");
    }
    //System.out.println(qs.qs(nums,0,nums.length-1,k-1));
  }
}