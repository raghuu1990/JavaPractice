package com.prem.thread.concurrent.work;

import java.util.Arrays;
import java.util.List;
import java.util.Map;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

public class ConcurrentHashMapDemo implements Runnable
{
  
  List<Integer> keys=Arrays.asList(1,2,3,4,5);
  List<String>  values=Arrays.asList("prem","satish","naveen","gaurav","monika");

  public static void main(String[] args)
  {
      ConcurrentHashMapDemo chmd= new ConcurrentHashMapDemo();
      ExecutorService service= Executors.newFixedThreadPool(5);
      service.execute(chmd);
  }

  public void addConcurrentEntry(String key, String value)
  {
   // cMap.put(key, value);
  }

  public void addEntry(String key, String value)
  {

  }

  @Override
  public void run()
  {
    addConcurrentEntry("1", "Prem0");
    addConcurrentEntry("2", "Prem1");
    addConcurrentEntry("3", "Prem2");
    addConcurrentEntry("4", "Prem3");
    addConcurrentEntry("5", "Prem4");
  }

}
class EntryFeeder implements Runnable{
  private Map map;
  private String key;
  private String value;
  public EntryFeeder(Map map,String key,String value)
  {
    this.map=map;
    this.key=key;
    this.value=value;
      
  }
  @Override
  public void run()
  {
    this.map.put(this.key, this.value);
    
  }
  
}
