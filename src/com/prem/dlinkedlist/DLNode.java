package com.prem.dlinkedlist;

public class DLNode<T> {
  DLNode next;
  DLNode prev;
  T data;

  public DLNode(T data){
    this.next=null;
    this.prev=null;
    this.data=data;
  }

  public DLNode(){}
}
