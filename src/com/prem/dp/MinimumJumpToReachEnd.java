package com.prem.dp;

public class MinimumJumpToReachEnd {

  /**
   *
   * Steps are given:
   * we need to reach to end from start
   * Find min steps to find at end.
   * given steps array having how many steps can jump from ith position
   * steps : {2,3,1,1,2,4,2,0,1,1}
   *
   * Complexity: n^2
   *
   * Make a result array of same length of step array
   * 1. fill it with max value
   * 2. fill 0th position with 0
   * 3. start loop from j=1 to end
   *      inner loop will start from 0 to jth
   *
   *        if from ith step + jump can be made from ith step can be reachea at j
   *          (ie.
   *
   *
   */

  public void tempArray(int[] data,int[] result,int[] path){
    for(int i=0;i<result.length;i++){
      result[i]=Integer.MAX_VALUE-1;
    }
    result[0]=0;
    path[0]=-1;
    for(int j=1;j<data.length;j++){
      for(int i=0;i<j;i++){
        if(i+data[i]>=j){             //from current pos to given jumps step
          if(result[i]+1<result[j]){  //0+1<Integer.Max
            result[j]=result[i]+1;
            path[j]=i;
          }
        }
      }
    }
  }

  public static void main(String[] args) {
    MinimumJumpToReachEnd mjtre= new MinimumJumpToReachEnd();
    int[] arr= {2,3,1,1,2,4,2,0,1,1};
    int[] result = new int[arr.length];
    int[] path = new int[arr.length];
    mjtre.tempArray(arr,result,path);

    /*
    for(int i=0;i<result.length;i++){
      System.out.print(result[i]+", ");
    }
*/
  /*  System.out.println();
    for(int i=0;i<path.length;i++){
      System.out.print(path[i]+", ");
    }
    System.out.println();
  */  int x=arr.length-1;

    if(path[x]>0) {
      System.out.println("Min Jump required: "+result[x]);
      System.out.print("Path: "+x+", ");
      while (path[x] >= 0) {
        System.out.print(path[x] + ", ");
        x = path[x];
      }
    }
  }
}