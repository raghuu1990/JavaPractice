package com.prem.heap;

import java.util.Comparator;

public class HuffmanNodeComparator<T> implements Comparator<HuffmanNode<T>> {
  @Override
  public int compare(HuffmanNode<T> node1, HuffmanNode<T> node2) {
    if(node1.getFreq()>=node2.getFreq()){
      return 1;
    }
    else{
      return -1;
    }
  }
}
