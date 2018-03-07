package com.javaconcepts;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;
import java.util.concurrent.CompletableFuture;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

import com.prem.tree.BST;
import com.prem.tree.Node;

public class CFD {

  public static void main(String[] args) {

    List<CompletableFuture<String>> tasks = new ArrayList<>();
    Random random = new Random();
    ExecutorService service= Executors.newFixedThreadPool(50);

    long start= System.currentTimeMillis();
    Node root= new Node(-1);

    for(int i=0;i<1000;i++){
      CompletableFuture<String> taskResult= CompletableFuture.supplyAsync(() ->{
/*
        try {
          Thread.sleep(200);
        } catch (InterruptedException e) {
          e.printStackTrace();
        }
*/
//        return nameProvider(random.nextInt(50)+"");
        return someWork(root,5000);
    },service);
      tasks.add(taskResult);
    }

    List<String> acc = new ArrayList<>();
    for(CompletableFuture<String> result:tasks){
      try {
        acc.add(result.get());
      } catch (InterruptedException e) {
        e.printStackTrace();
      } catch (ExecutionException e) {
        e.printStackTrace();
      }
    }


/*
    for(int i=0;i<500;i++){
      Future<String> taskResult= service.submit(()-> {
          try {
            Thread.sleep(200);
          } catch (InterruptedException e) {
            e.printStackTrace();
          }
          return nameProvider(random.nextInt(50)+"");
      });
      tasks.add(taskResult);
    }

    List<String> acc = new ArrayList<>();
    for(Future<String> result:tasks){
      try {
        acc.add(result.get());
      } catch (InterruptedException e) {
        e.printStackTrace();
      } catch (ExecutionException e) {
        e.printStackTrace();
      }
    }
*/

    System.out.println(acc);
    System.out.println("Time elapsed:"+(System.currentTimeMillis()-start));
  }

  public static String nameProvider(String name){
    return "Mr. "+name;
  }

  public static String someWork(Node node,int limit){
    Random random = new Random();
    //Node node = new Node(random.nextInt(5000));
    BST bst= new BST();
    for(int i=0;i<limit;i++) {
      bst.insert(node, random.nextInt(limit));
    }
    return "done";
  }
}