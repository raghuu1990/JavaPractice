package com.prem.concurrency;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

public class ReentrantLockDemo {
	private Lock lock = new ReentrantLock(true);
	private Counter counter = new Counter(0);

	public static void main(String[] args) {
		ReentrantLockDemo rl = new ReentrantLockDemo();

		for (int i = 1; i <= 400; i += 4) {
			new Thread(new Adder(rl.counter, rl.lock, "thread" + i)).start();
			new Thread(new Adder(rl.counter, rl.lock, "thread" + (i + 1))).start();
			new Thread(new Adder(rl.counter, rl.lock, "thread" + (i + 2))).start();
			new Thread(new Substractor(rl.counter, rl.lock, "thread" + (i + 3))).start();
		}
/*
		ExecutorService pool = Executors.newFixedThreadPool(1);
		for (int i = 1; i <= 400; i += 4) {
			Runnable w1 = new Adder(rl.counter, rl.lock, "thread" + i);
			pool.execute(w1);
			Runnable w2 = new Adder(rl.counter, rl.lock, "thread" + (i + 1));
			pool.execute(w2);
			Runnable w3 = new Adder(rl.counter, rl.lock, "thread" + (i + 2));
			pool.execute(w3);
			Runnable w4 = new Substractor(rl.counter, rl.lock, "thread" + (i + 3));
			pool.execute(w4);
		}
		pool.shutdown();*/
		/*try {
			Thread.currentThread().wait(5000);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}*/
		System.out.println("All Done");
	}
}

final class Counter {
	private int count;

	public Counter(int count) {
		this.count = count;
	}

	public int getCount() {
		return count;
	}

	public void setCount(int count) {
		this.count = count;
	}
}

class Adder implements Runnable {
	private Counter counter;
	private Lock lock;
	String name;

	public String getName() {
		return name;
	}

	public Adder(Counter Counter, Lock lock, String name) {
		this.counter = Counter;
		this.lock = lock;
		this.name = name;
	}

	public void run() {
		if (lock.tryLock()) {
			// lock.lock();
			counter.setCount(counter.getCount() + 1);
			System.out.println("Adder Count:" + counter.getCount() + " , " + getName());
			lock.unlock();
		}else {
			System.out.println("Could't acquire lock");
		}
	}
}

class Substractor implements Runnable {
	private Counter Counter;
	private Lock lock;
	String name;

	public String getName() {
		return name;
	}

	public Substractor(Counter Counter, Lock lock, String name) {
		this.Counter = Counter;
		this.lock = lock;
		this.name = name;
	}

	public void run() {
		if (lock.tryLock()) {
			// lock.lock();
			Counter.setCount(Counter.getCount() - 1);
			System.out.println("Substractor Count:" + Counter.getCount() + " , " + getName());
			lock.unlock();
		}else {
			System.out.println("Could't acquire lock");
		}
	}
}