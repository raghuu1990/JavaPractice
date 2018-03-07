package com.company.ola;

import java.util.concurrent.ArrayBlockingQueue;
import java.util.concurrent.BlockingQueue;
import java.util.concurrent.Executors;
import java.util.concurrent.ScheduledExecutorService;
import java.util.concurrent.TimeUnit;

public class Executor  implements Runnable {
	private static BlockingQueue<HttpRequest> queue;
	public static int SIZE = 6;
	public Executor(){
		System.out.println("---------------------- In Executor constroctor -----------------------------");
		Executor.queue = new ArrayBlockingQueue<>(SIZE);
	}

	public static void submitRequestToExecutor(HttpRequest httpRequest){
		while(queue.size() == SIZE){}
		queue.add(httpRequest);
		
	}

	public void run(){
		ScheduledExecutorService executor = Executors.newScheduledThreadPool(3);
		HttpRequest httpRequest = new HttpRequest();
		while(true){
			httpRequest = queue.poll();
			if(httpRequest!=null && httpRequest.getState() != State.COMPLETED){
				Runnable worker = new Worker(httpRequest);
				executor.schedule(worker, 0, TimeUnit.SECONDS);
			}
			if(!Scheduler.isActive){
				System.out.println("----------------------------------Executor Stoped---------------------------------------");
				break;
			}
		}
		executor.shutdown();
		while (!executor.isTerminated()) {
		}
		System.out.println("Finished all threads");
	}
}