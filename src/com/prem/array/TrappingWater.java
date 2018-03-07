package com.prem.array;


public class TrappingWater {

  /**
   * given array having length of towers
   *  to find water trapped among towers
   * O(n)
   *
   * get Max array from right -> O(n)
   * Now start to traverse from left
   * get max from left and
   *  get min of maxFromLeft and maxArray element at this index
   *  substract above from currentheight to get current holding water capapcity
   *
   *  keep totalTrapped water var global and keep adding each tower water to it.
   */
  public int trappedWater(int [] towers){
    int totalTrappedWater=0;

    int rightToLeft[]=MinMaxArray.makeMaxArray(towers);
    int maxHeightFromLeft=0;
    for(int i=0;i<towers.length;i++){
      if(towers[i]>maxHeightFromLeft){
        maxHeightFromLeft=towers[i];
      }
      totalTrappedWater+=Math.max(Math.min(maxHeightFromLeft,rightToLeft[i])-towers[i],0);
    }
    return totalTrappedWater;
  }

  public static void main(String[] args) {
    //int input[] = {0,1,0,2,1,0,1,3,2,1,2,1};
    int input[] = {1,4,0,1,0,3,4,0};
    TrappingWater tw = new TrappingWater();
    System.out.println(tw.trappedWater(input));

  }

}
