package com.designpattern.singleton;

import java.util.concurrent.Executors;
import java.util.concurrent.ScheduledExecutorService;
import java.util.concurrent.TimeUnit;


public class Singleton {
	private static Singleton instance;
	private Singleton() {}

	/*public static Singleton getInstance() {
		if(null == instance) {
			instance = new Singleton();
		}
		return instance;
	}*/

/*
	public static synchronized Singleton getInstance() {
		if(null == instance) {
			instance = new Singleton();
		}
		return instance;
	}	
*/
		
    public static Singleton getInstance() {
		if(null == instance) {
			synchronized(Singleton.class){
				if(null == instance) {
					instance = new Singleton();
				}
			}
		}
		return instance;
	}
	 
	public static void main(String[] args) {
		ScheduledExecutorService executor = Executors.newScheduledThreadPool(30);
		try{
			for(int i=0;i<30;i++){
				Runnable thread = new MultiThread(false);
				executor.schedule(thread, 0, TimeUnit.SECONDS);
			}
			executor.shutdown();
			System.out.println("Finished all threads");
		} catch (Exception ex) {
			System.out.println("Exception : " + ex.getMessage());
		}
	}
}