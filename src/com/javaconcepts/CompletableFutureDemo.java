package com.javaconcepts;

import java.util.Arrays;
import java.util.List;
import java.util.concurrent.Callable;
import java.util.concurrent.CompletableFuture;
import java.util.concurrent.ExecutionException;
import java.util.function.Supplier;

public class CompletableFutureDemo {

  public static void main(String[] args) throws ExecutionException, InterruptedException {

    List<String> names= Arrays.asList("Prem","Ashish","Gaurav","xyz");

    Supplier<XX> supplier= new Supplier<XX>() {
      @Override
      public XX get() {
        return new XX();
      }
    };

    //ExecutorService service= Executors.newFixedThreadPool(Runtime.getRuntime().availableProcessors()+1);

    //1. Create a task
    CompletableFuture<String> firstNameProvider= CompletableFuture.supplyAsync(()->{
      try {
        Thread.sleep(500);
      } catch (InterruptedException e) {
        e.printStackTrace();
      }
      return "Prem";
    //},service);
    });

    //2. put a callback
    firstNameProvider.thenAccept(name -> log(name));

    //start the task
    //firstNameProvider.get();


    //1. Create a task
    CompletableFuture<String> lastNameProvider= CompletableFuture.supplyAsync(()->{
      try {
        Thread.sleep(500);
      } catch (InterruptedException e) {
        e.printStackTrace();
      }
      return "Bharti";
    //},service);
    });

    //2. put a callback
    lastNameProvider.thenAccept(name -> log(name));

    //start the task
    //lastNameProvider.get();


    //1. Create a task
    CompletableFuture<String> fullNameProvider= firstNameProvider.thenCombine(lastNameProvider, (firstName,lastName)->print(firstName,lastName));
    long start= System.currentTimeMillis();

    System.out.println(fullNameProvider.get());
    System.out.println("Time diff:"+ (System.currentTimeMillis()-start));
  }


  public String nameDecorator(String title){
    return "Mr. " +title;
  }


  public static void log(String name){
    System.out.println(name);
  }

  public static String print(String a, String b){
    return a+" "+b;
  }
}

class XX implements Callable<String> {
  public String call() {
    return "Prem";
  }
}