package com.thread;

// getName and start() methods are part of Thread class, so these methods can only called on thread created using extending Thread class.
// after creating object of thread, a name is assigned to that object,
// getName() of thread class return name of current thread or if called from thread.run return next available thread name.

public class RunStartDiff {

	public static void main(String[] args) throws InterruptedException {
		System.out.println("inside main :" + Thread.currentThread().getName());

		System.out.println();
		Thread.sleep(1000);

		Thread t1 = new ThreadA();
		//Thread t2 = new ThreadB();
		
		System.out.println();
		Thread.sleep(1000);

		new ThreadA().start();

		System.out.println();
		Thread.sleep(1000);

		new ThreadA().run();

		System.out.println();
		Thread.sleep(1000);

		// new ThreadB().start();

		System.out.println();
		Thread.sleep(1000);

		new ThreadB().run();

		System.out.println();
		Thread.sleep(1000);

		ThreadB t = new ThreadB();
		// t.start();

		System.out.println();
		Thread.sleep(1000);

		Runnable a = new ThreadA();
		a.run();

		System.out.println();
		Thread.sleep(1000);

		// a.start();

		System.out.println();
		Thread.sleep(1000);

		Runnable b = new ThreadB();
		b.run();

		System.out.println();
		Thread.sleep(1000);

		// b.start();
	}
}

class ThreadA extends Thread {
	@Override
	public void run() {
		System.out.println("inside run of threadA :" + getName());
		System.out.println("inside run of threadA :" + Thread.currentThread().getName());
	}
}

class ThreadB implements Runnable {
	@Override
	public void run() {
		// System.out.println("inside run of threadB :" + this.getName());
		System.out.println("inside run of threadB :" + Thread.currentThread().getName());
	}
}
