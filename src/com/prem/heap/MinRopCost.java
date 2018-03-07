package com.prem.heap;

import java.util.PriorityQueue;

/**
 * Connect n ropes with minimum cost
 *
 * roaps with length {4,3,2,6}
 * cost to connect two roap = sum of length of both roap
 *
 * Ex 1 : 4+3 = 7
 *        7,2,6 ->  7+2 = 9
 *        9,6 -> 9+6 = 15
 *        Total cost to connect rope = 7 + 9 + 15 = 31
 * Ex 2 : 2+3 = 5
 *        5,4,6 -> 4+5 = 9
 *        9,6 -> 9+6 = 15
 *        Total cost -> 5+9+15 = 29 (min cost)
 *  Create a min heap -> take two elements out -> minimum + second minimum
 *  add sum again in heap until you get heap size =1
 *  Keep adding cost each time and return sum at end.
 *
 */
public class MinRopCost {

  PriorityQueue<Integer> heap = new PriorityQueue<>();


  public int ropeBindingCost(int[] ropesLen){
    if(ropesLen.length<2){
      return 0;
    }
    for(int i=0; i<ropesLen.length;i++){
      heap.add(ropesLen[i]);
    }
    int cost=0;
    while(heap.size()!=1){
      int first=heap.poll();
      int second=heap.poll();
      int sum=first+second;
      cost+=sum;
      heap.offer(sum);
    }
    return cost;

  }

  public static void main(String[] args) {
    int ropeLen[]={4,3,2,6};
    MinRopCost mrc= new MinRopCost();
    System.out.println(mrc.ropeBindingCost(ropeLen));
  }
}
