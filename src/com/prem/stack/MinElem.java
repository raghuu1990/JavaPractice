package com.prem.stack;

import java.util.Stack;

public class MinElem {

   private int[] elements= {4,9,1,7,2,3,5,0,10};

   private Stack<Integer> stack= new Stack<>();
   private Stack<Integer> minStack= new Stack<>();


  public void push(int element){
    stack.push(element);
    if(!minStack.isEmpty()){
      if(element<minStack.peek()){
        minStack.push(element);
      }
    }
    else{
      minStack.push(element);
    }
  }

  public int pop(){
    if(!stack.isEmpty()){
      int removed=stack.pop();
      if(!minStack.isEmpty() && minStack.peek()==removed){
        minStack.pop();
      }
      return removed;
    }
    return -1;
  }

  public int getMin(){
    if(!minStack.isEmpty()){
      return minStack.peek();
    }
    return -1;
  }

  public static void main(String[] args) {
        MinElem minElem = new MinElem();
    for(int i=0;i<minElem.elements.length;i++){
      minElem.push(minElem.elements[i]);
      System.out.println("-"+minElem.getMin());

    }
  }
}