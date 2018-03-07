package com.prem.heap;

public class HuffmanNode<T> {
  private int freq;
  private T data;
  HuffmanNode<T> left;
  HuffmanNode<T> right;



  public int getFreq() {
    return freq;
  }

  public void setFreq(int freq) {
    this.freq = freq;
  }

  public T getData() {
    return data;
  }

  public void setData(T data) {
    this.data = data;
  }
}
