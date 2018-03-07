package com.prem.thread.concurrent.work;

import java.util.Iterator;
import java.util.List;
import java.util.concurrent.CopyOnWriteArrayList;

public class ArrayListConcurrency
{

  //private List<String> list =new ArrayList<String>();
  private CopyOnWriteArrayList<String> list = new CopyOnWriteArrayList<>();

  public static void main(String[] args)
  {
      ArrayListConcurrency alc= new ArrayListConcurrency();
      alc.addElements(alc.list);
      Iterator<String> itr= alc.list.iterator();
      while(itr.hasNext()){
        alc.list.add("Hello");
        System.out.println(itr.next());      
      }
    
  }
  public void addElements(List<String> list){
    list.add("Prem");
    list.add("Rohit");
    list.add("Satish");
    list.add("Naveen");
    list.add("Mohit");
  }
  
  
}
