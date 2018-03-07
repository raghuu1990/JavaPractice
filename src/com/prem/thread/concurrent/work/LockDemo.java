package com.prem.thread.concurrent.work;

import java.util.concurrent.TimeUnit;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

public class LockDemo {
	public static void main(String[] args) {
		Resource resource= new Resource();
		Lock lock= new ReentrantLock();
		Thread first=new Thread(new MyLockJob(resource,lock));
		first.start();
		Thread second=new Thread(new MyLockJob(resource,lock));
		second.start();
	}
}

class MyLockJob implements Runnable {

	private Resource resource;
	private Lock lock;

	public MyLockJob(Resource r,Lock lock) {
		this.resource = r;
		this.lock = lock;
	}

	@Override
	public void run() {
		try {
			lock.lock();
			if (lock.tryLock(5, TimeUnit.SECONDS)) {
				resource.doSomething();
				//lock.unlock();
			}
		} catch (InterruptedException e) {
			e.printStackTrace();
		} finally {
			// release lock
			lock.unlock();
		}
		//resource.doLogging();
	}

}

class Resource {
	public void doSomething() throws InterruptedException {
		System.out.println("Doing Something");
		Thread.sleep(1000);
		System.out.println("Done Something");
	}

	public void doLogging() {
		System.out.println("Logging....!!");
	}
}