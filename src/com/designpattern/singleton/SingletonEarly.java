package com.designpattern.singleton;

import java.util.concurrent.Executors;
import java.util.concurrent.ScheduledExecutorService;
import java.util.concurrent.TimeUnit;

public class SingletonEarly {

	private static SingletonEarly instance = new SingletonEarly();

	private SingletonEarly(){}

	public static SingletonEarly getInstance(){
		return instance;
	}

	public static void main(String[] args) {
		ScheduledExecutorService executor = Executors.newScheduledThreadPool(30);
		try{
			for(int i=0;i<30;i++){
				Runnable thread = new MultiThread(true);
				executor.schedule(thread, 0, TimeUnit.SECONDS);
			}
			executor.shutdown();
			System.out.println("Finished all threads");
		} catch (Exception ex) {
			System.out.println("Exception : " + ex.getMessage());
		}
	}
}