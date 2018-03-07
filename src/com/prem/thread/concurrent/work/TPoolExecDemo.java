package com.prem.thread.concurrent.work;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Iterator;
import java.util.List;
import java.util.concurrent.Callable;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.Future;

public class TPoolExecDemo {
	public static void main(String[] args) throws Exception {
		TPoolExecDemo classObj = new TPoolExecDemo();
		// classObj.useCallableThreadService();
		// classObj.useSingleRunnableThreadService();
		classObj.useCachedThreadPool();
	}

	public void useRunnableThreadService() {
		ExecutorService tService = Executors.newFixedThreadPool(5);
		List<String> inputs = Arrays.asList("Satish", "Prem", "Naveen", "Himanshu", "Gaurav");
		Iterator<String> itr = inputs.iterator();
		while (itr.hasNext()) {
			tService.submit(new Thread(new MyRunnableJob(itr.next())));
		}
		tService.shutdown();
	}

	/**
	 * Creates a thread pool that reuses a fixed number of threads operating off
	 * a shared unbounded queue. At any point, at most nThreads threads will be
	 * active processing tasks. If additional tasks are submitted when all
	 * threads are active, they will wait in the queue until a thread is
	 * available. If any thread terminates due to a failure during execution
	 * prior to shutdown, a new one will take its place if needed to execute
	 * subsequent tasks. The threads in the pool will exist until it is
	 * explicitly shutdown.
	 * 
	 * @throws InterruptedException
	 * @throws ExecutionException
	 */
	public void useCallableThreadService() throws InterruptedException,
			ExecutionException {
		ExecutorService tService = Executors.newFixedThreadPool(5);
		List<String> inputs = Arrays.asList("Satish", "Prem", "Naveen",
				"Himanshu", "Gaurav");
		List<Future<String>> outputs = new ArrayList<Future<String>>();
		Iterator<String> itr = inputs.iterator();
		while (itr.hasNext()) {
			outputs.add(tService.submit(new MyCallableJob(itr.next())));
		}
		tService.shutdown();

		Iterator<Future<String>> itr2 = outputs.iterator();
		while (itr2.hasNext()) {
			System.out.println(itr2.next().get());
		}
	}

	/**
	 * Creates a thread pool that creates new threads as needed, but will reuse
	 * previously constructed threads when they are available. These pools will
	 * typically improve the performance of programs that execute many
	 * short-lived asynchronous tasks. Calls to execute will reuse previously
	 * constructed threads if available. If no existing thread is available, a
	 * new thread will be created and added to the pool. Threads that have not
	 * been used for sixty seconds are terminated and removed from the cache.
	 * Thus, a pool that remains idle for long enough will not consume any
	 * resources. Note that pools with similar properties but different details
	 * (for example, timeout parameters) may be created using ThreadPoolExecutor
	 * constructors.
	 * 
	 * @throws ExecutionException
	 * @throws InterruptedException
	 */
	public void useCachedThreadPool() throws InterruptedException,
			ExecutionException {
		ExecutorService tService = Executors.newCachedThreadPool();
		List<String> inputs = Arrays.asList("Satish", "Prem", "Naveen",
				"Himanshu", "Gaurav");

		Iterator<String> itr = inputs.iterator();
		List<Callable<String>> callableList = new ArrayList<>();

		while (itr.hasNext()) {
			callableList.add(new MyCallableJob(itr.next()));
		}
		List<Future<String>> outputs = tService.invokeAll(callableList);
		Iterator<Future<String>> itr2 = outputs.iterator();
		tService.shutdown();
		while (itr2.hasNext()) {
			System.out.println(itr2.next().get());
		}
	}
	


	public void useSingleRunnableThreadService() {
		ExecutorService tService = Executors.newSingleThreadExecutor();
		tService.submit(new Thread(new MyRunnableJob("Single Input")));
		tService.shutdown();
	}

	class MyRunnableJob implements Runnable {
		private String input;

		public MyRunnableJob(String input) {
			this.input = input;
		}

		@Override
		public void run() {
			try {
				Thread.sleep(5000);
			} catch (InterruptedException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			System.out.println(input);

		}
	}

	class MyCallableJob implements Callable<String> {
		private String input;

		public MyCallableJob(String input) {
			this.input = input;
		}

		@Override
		public String call() throws Exception {
			synchronized (this) {
				Thread.sleep(1000);
				return this.input + ",";
			}

		}
	}
}
