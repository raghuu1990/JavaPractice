package com.prem.array;

public class MergeTwoSortedArray {

  /**
   * merge part of merge sort.
   * O(n+m)  n-> size of first array , m-> size of second array
   *
   * extra space of (m+n)
   *
   * take 3 pointers
   * 1 ->first array
   * 2 -> second array
   * 3 -> result array
   *
   * compare 1 and 2 which is smaller put in result array and increment
   * at end 1 or 2 array is not completely traversed.
   */
  public int[] merge(int[] arr1,int[] arr2){
    if(arr1==null || arr1.length<1){
      return arr2;
    }
    if(arr2==null || arr2.length<1){
      return arr1;
    }

    int[] arr3 = new int[arr1.length + arr2.length];
    int i=0;
    int j=0;
    int k=0;
    while(i<arr1.length && j<arr2.length){
       if(arr1[i]<arr2[j]){
         arr3[k++]=arr1[i++];
       }
       else if(arr1[i]>arr2[j]){
         arr3[k++]=arr2[j++];
       }
      else{
         arr3[k++]=arr1[i++];
         arr3[k++]=arr2[j++];
       }
    }
    while(i<arr1.length){
      arr3[k++]=arr1[i++];
    }
    while (j < arr2.length) {
      arr3[k++]=arr2[j++];
    }

    return arr3;
  }

  public static void main(String[] args) {
    MergeTwoSortedArray mtsa= new MergeTwoSortedArray();
    int[] arr1= {2,4,6,8,10,12,14,16,18,20};
    int[] arr2= {3,6,9,12,15,18,21};
    int[] arr3=mtsa.merge(arr1, arr2);
    for(int i=0;i<arr3.length;i++){
      System.out.print(arr3[i]+", ");
    }
  }
}
