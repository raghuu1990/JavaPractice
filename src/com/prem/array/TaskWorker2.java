package com.prem.array;

import java.util.concurrent.Semaphore;

public class TaskWorker2 implements Runnable {
  private Task task;
  private Semaphore sem;
  public TaskWorker2(Task task, Semaphore sem){
    this.task=task;
    this.sem=sem;
  }

  @Override
  public void run() {
    try {
      sem.acquire();
      Thread.sleep(task.getPriority());
      task.execute();
    } catch (InterruptedException e) {
      e.printStackTrace();
    }
    sem.release();
  }
}
