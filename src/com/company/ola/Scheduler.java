package com.company.ola;

import java.util.concurrent.ArrayBlockingQueue;
import java.util.concurrent.BlockingQueue;

public class Scheduler implements Runnable{

	public static int SIZE = 10;
	public volatile static boolean isActive = true;
	static BlockingQueue<HttpRequest> queue;

	public Scheduler(){
		System.out.println("---------------------- In Scheduler constroctor -----------------------------");
		Scheduler.queue = new ArrayBlockingQueue<>(SIZE);
	}

	private static void scheduleRequest(HttpRequest httpRequest) {
		while(queue.size() == SIZE){}
		queue.add(httpRequest);
	}

	public static void send(String url, String header, String bodyObject, int expectedResponseCode) {
		HttpRequest httpRequest = new HttpRequest(url, header, bodyObject, expectedResponseCode);
		scheduleRequest(httpRequest);
	}

	@Override
	public void run() {
		try{
			HttpRequest httpRequest = new HttpRequest();
			while(true){
				while(isActive){
					httpRequest = queue.poll();
					if(isActive && httpRequest!=null && httpRequest.getState() != State.COMPLETED){
						Executor.submitRequestToExecutor(httpRequest);
					}else if(isActive && httpRequest!=null && httpRequest.getState() != State.UNCOMPLETE){
						queue.remove(httpRequest);
						System.out.println(httpRequest.toShortString()+ " removed from queue");
					}
				}

			}
		}catch(Exception e) {
			e.printStackTrace();
		}
	}

	public static void stop(boolean value) {
		isActive = value;
	}
}
