package com.prem.graph;

import java.util.HashMap;
import java.util.Map;
import java.util.PriorityQueue;

/* * Data structure to support following operations
 * extracMin - O(logn)
 * addToHeap - O(logn)
 * containsKey - O(1)
 * decreaseKey - O(logn)
 * getKeyWeight - O(1)
 * */
public class BinaryMinHeap<T> {

  private PriorityQueue<Node<T>> heap = new PriorityQueue<>();
  private Map<T, Integer> nodePosition = new HashMap<>();

  public void addToHeap(int weight, T key) {
    heap.add(new Node(weight,key));
    nodePosition.put(key,heap.size()-1);
  }

  /**
   * Checks where the key exists in heap or not
   */
  public boolean containsData(T key){
    return nodePosition.containsKey(key);
  }

  /**
   * Get the heap min without extracting the key
   */
  public T min(){
    return heap.peek().key;
  }

  /**
   * Decreases the weight of given key to newWeight
   */
  public void decrease(T data, int newWeight) {
    //heap.
  }


    public class Node<T> {
    int weight;
    T key;

    public Node(int weight,T key){
      this.weight=weight;
      this.key=key;
    }
    public int getWeight() {
      return weight;
    }

    public void setWeight(int weight) {
      this.weight = weight;
    }

    public T getKey() {
      return key;
    }

    public void setKey(T key) {
      this.key = key;
    }
  }



}

