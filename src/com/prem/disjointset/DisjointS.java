package com.prem.disjointset;

import java.util.HashMap;
import java.util.Map;

/**
 *  Disjoint set is set of no. of non-overlapping/disjoint set.
 *
 *  One element of set -> disjoint node (data, rank, parent)
 *  - default rank of node is 0
 *
 *  first create
 *  # each set contains its parent/master element which represent all element in that set
 *
 *  contains mainly 3 operations:
 *  1. makeSet(data) : void            O(n) for n data
 *                     it's called first it will create multiple single disjoint node
 *                     initially each node will parent of itself.
 *                     and all elements will be added in disjoint set(map of data,dsnode).
 *  2. findSet(data) : dsNode       
 *                     it gets data and returns it's parent node
 *
 *                     first get dsnode from hashmap using data as key.
 *                     if data and it's parent's data same then return node
 *                     else recursively pass node's parent data
 *  3. union(data1, data2): void
 *                     it puts two data under same disjoint node using union and sets new parent
 *     get data1-> parent , data2-> parent if both are same then no need to union coz they are
 *                                                          under same parent
 *     else
 *      check if parent1 and parent2 rank are same
 *        if same then increment rank of one parent (parent1) and make parent2 child of parent1
 *      if not same then smaller parent rank will become child of greater rank parent
 *
 *
 *      application: kruksal's algorithm
 */
public class DisjointS {

  private Map<Long,DsNode> disjointSets= new HashMap<>();


  public static void main(String[] args) {
    DisjointS dj= new DisjointS();
    for(int i=1;i<8;i++){
      dj.makeSet(i);
    }
    for(int i=1;i<8;i++){
      System.out.println(i+" , parent:"+dj.findSet(i).data);
    }
    dj.union(3,4);
    dj.union(5,6);
    for(int i=1;i<8;i++){
      System.out.println(i+" , parent:"+dj.findSet(i).data);
    }

  }

  public void makeSet(long element){
    DsNode set= new DsNode(element);
    set.rank=0;
    set.parent=set;
    disjointSets.put(element,set);

  }

  public int sizeOfElementSet(long element){
    return findSet(element).size;
  }

  public DsNode findSet(long element){
    DsNode node=disjointSets.get(element);
    if(node.parent.data!=element){ // if element's parent is self element
      return findSet(node.parent.data);
    }
    else{
      return node;
    }

  }
  public void union(long element1, long element2){
    DsNode parent1 = findSet(element1);
    DsNode parent2 = findSet(element2);
    //if both element's parent are same then they are in same set not need of union
    if(parent1.data!=parent2.data){
        if(parent1.rank>=parent2.rank){//set having more rank merge another element into that
          parent1.rank= parent1.rank==parent2.rank? parent1.rank+1:parent1.rank;
          parent2.parent=parent1;
          parent1.size+=parent2.size;
        }
        else{
          parent1.parent=parent2;
          parent2.size+=parent1.size;
        }
    }
  }
}