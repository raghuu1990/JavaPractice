package com.prem.array;

public class FindDuplicate {

  /**
   * arr={1,2,3,3,4,4,5};
   * given array containing 1 to N no., find duplicate numbers
   * output: 3,4
   * O(n)
   * Cons: using extra space
   * add +1 at element position and another loop to check
   */
  public void findDuplicateGiven1ToNno(int[] arr){
    int temp[] = new int[arr.length];
    for(int i=0;i<arr.length;i++){
      temp[arr[i]]+=1;
    }
    for(int i=0;i<temp.length;i++){
      if(temp[i]>1)
      System.out.println(i);
    }
  }

  /**
   *
   *given array containing 1 to N no.
   * arr={1,2,3,3,4,4,5};
   * given array containing 1 to N no., find duplicate numbers
   *
   * O(n)
   * adding array size to element position and another loop to check
   */
  public void findDuplicateWithoutExtraSpace(int[] arr){
    int size=arr.length;
    //add size to each
    for(int i=0;i<arr.length;i++){
      arr[arr[i]%size]+=size;  //multiple adding will give array out of bound so need to add at remainder
    }

    for(int i=0;i<arr.length;i++){
      //if more than one time size would have been added quotient will be greater than 1
      if(arr[i]/size>1){
        System.out.println(arr[i]%size);
      }
    }
  }

  public static void main(String[] args) {
    int arr[]={1,2,3,3,4,4,5};
    FindDuplicate fd= new FindDuplicate();
    fd.findDuplicateGiven1ToNno(arr);
    //fd.findDuplicateWithoutExtraSpace(arr);
  }

}
