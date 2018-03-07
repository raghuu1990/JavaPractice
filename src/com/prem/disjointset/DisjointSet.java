package com.prem.disjointset;

import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;

public class DisjointSet {

  private Map<Integer,DSet<Integer>> disjointSets;

  public DisjointSet() {
    disjointSets = new HashMap<>();
  }


  public void createSet(int element){
    DSet<Integer> disjointSet= new DSet<>();

    disjointSet.setRepr(element); //adding representative
    Set<Integer> elements = new HashSet<>();
    elements.add(element);
    disjointSet.setdSet(elements); // adding elements

    disjointSets.put(element,disjointSet); // adding in disjoint list
  }


  public int findSet(int element){
    if(disjointSets.containsKey(element)) return element;
    for(DSet<Integer> dset:disjointSets.values()){
      Set<Integer> elements= dset.getdSet();
      if(elements.contains(element)){
        return dset.getRepr();
      }
    }
    return -1;
  }

  public void union(int first,int second){
    int firstRepr = findSet(first);
    int secondRepr = findSet(second);
    //if both representative are not same (both elements are not in same set)
    // then merge them into one
    if(firstRepr!=secondRepr || firstRepr!=-1 || secondRepr != -1 ) {
      Set<Integer> unionValues = disjointSets.get(firstRepr).getdSet();
      unionValues.addAll(disjointSets.get(secondRepr).getdSet());
      disjointSets.get(firstRepr).setdSet(unionValues);
      disjointSets.remove(secondRepr);
    }
  }

  public static void main(String[] args) {
    DisjointSet ds= new DisjointSet();

    for(int i=0;i<8;i++){
      ds.createSet(i);
      System.out.println("Element :"+i+" Representative:"+ ds.findSet(i));
    }
    ds.union(2,3);
    ds.union(6,7);

    System.out.println("After union of 2,3 and 6,7");
    for(int i=0;i<8;i++){
      System.out.println("Element :"+i+" Representative:"+ ds.findSet(i));
    }
  }
}