package com.prem.array;

public class MinDistanceBetweenTwoNumbers {

  /**
   * given unsorted array -> find min distance b/w two given number
   * {7,4,1,5,6,9,10,4,6,8}
   *
   * find min distance b/w 4 and 9 -> 2
   *
   * O(n)
   *
   *
   */
  public int findMinDistance(int[] arr,int a, int b) {
    int firstFound = -1;
    int secondFound = -1;
    int minDistance=-1;
    int captured=0; //not found any 0 , found first 1, found second 2

    for (int i = 0; i <arr.length;i++){
      if(arr[i]==a||arr[i]==b){
        if(arr[i]==a){
          firstFound=i;

          // so first found and if second is already captured then
          // either both not found -> minDistance=-1 or already found then check
          // distance and update
          if(captured==2 && (minDistance==-1 || firstFound-secondFound<minDistance)){
            minDistance=firstFound-secondFound;
          }
          captured=1;
        }
        else{
          secondFound=i;
          if(captured==1 && (minDistance==-1 || secondFound-firstFound<minDistance)){
            minDistance=secondFound-firstFound;
          }
          captured=2;
        }
      }
    }
    return minDistance;
  }

  public static void main(String[] args) {
    int input[] = {7,4,1,5,6,9,10,4,6,8};
    MinDistanceBetweenTwoNumbers mbtn= new MinDistanceBetweenTwoNumbers();
    System.out.println(mbtn.findMinDistance(input,4,9));
  }


}
