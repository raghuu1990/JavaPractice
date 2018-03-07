package com.designpattern.singleton;

public class MultiThread implements Runnable {

	volatile boolean isEarly;
	
	public MultiThread(boolean isEarly) {
		this.isEarly = isEarly;
	}
	
	@Override
	public void run() {
		if(isEarly){
			System.out.println("Running Thread Early : "+ Thread.currentThread().getId() +" hashcode : "+ SingletonEarly.getInstance().hashCode());
		}else{
			System.out.println("Running Thread : "+ Thread.currentThread().getId() +" hashcode : "+ Singleton.getInstance().hashCode());
		}
	}
}