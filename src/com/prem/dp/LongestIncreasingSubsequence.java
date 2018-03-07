package com.prem.dp;

public class LongestIncreasingSubsequence {

  /**
   *     int[] arr= {7,5,9,1,8,2,0,4,-1,6};
   *
   * index:  0|1|2|3|4|5|6|7|8 |9|
   * array:  7|5|9|1|8|2|0|4|-1|6|
   * result: 1|1|2|1|2|2|1|3|1 |4|
   * path:   0|0|0|0|0|3|0|5|0 |7|
   * max:    4
   * Largest increasing subsequence:4
   * path: 9 7 5 3
   *
   * array contain all element
   * fill result by 1 coz each single element has one itself increasing subsequence.
   *
   * take j -> 1 to end
   *  i -> 0 to j-1
   *  if result[i]+1 > result[j] then update result[j]
   *
   *  take temp variable to keep max of result[j]
   */
  public int lis(int[] arr){
      int[] result = new int[arr.length];
      int[] path= new int[arr.length];
      int max=1;

      for(int i=0;i<result.length;i++) {
        result[i]=1;
        path[i]=0;
      }

      for(int j=1;j<arr.length;j++){
        for(int i=0;i<j;i++){
          if(arr[i]<arr[j]){
            if(result[i]+1>result[j]){
              result[j]=result[i]+1;
              path[j]=i;
              if(result[j]>max){
                max=result[j];
              }
            }
          }
        }
      }
      //back track to print position we've already found max increasing subsequence length
      int lastPos=arr.length-1;
      while(lastPos>=0){
        if(result[lastPos]==max){ //got max position
          break;
        }
        lastPos--;
      }
      while(result[lastPos]>=1){ //until reach from maxsubsequence length is 1
        System.out.print(arr[lastPos]+" ");
        lastPos=path[lastPos];
        if(result[lastPos]==1){ //
          System.out.print(arr[lastPos]+" ");
          break;
        }
      }
/*
      System.out.println();
      for(int i=0;i<result.length;i++){
        System.out.print(result[i]+"|");
      }
      System.out.println();
      for(int i=0;i<path.length;i++){
        System.out.print(path[i]+"|");
      }
*/
      return max;
    }
  public int allPossiblelisCount(int[] arr){
      int[] result = new int[arr.length];
      int max=1;
      int count=0;

      for(int i=0;i<result.length;i++) {
        result[i]=1;count+=1;
      }

      for(int j=1;j<arr.length;j++){
        for(int i=0;i<j;i++){
          if(arr[i]<arr[j]){
            if(result[i]+1>=result[j]){
              result[j]=result[i]+1;
              if(result[j]>=max){
                max=result[j];
                count+=1;
              }
            }
          }
        }
      }
      return count;
    }

  public static void main(String[] args) {
    int[] arr= {7,5,9,1,8,2,0,4,-1,6};
    int[] arr1= {1,2,3};
    LongestIncreasingSubsequence lis= new LongestIncreasingSubsequence();
    System.out.println("\nLargest increasing subsequence:"+lis.lis(arr));
    System.out.println("\nAll possible subsequence count:"+lis.allPossiblelisCount(arr1));
  }

}
