package com.prem.thread.concurrent.work;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.concurrent.Callable;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.Future;

//import thread.experiment.CallableJob;

public class Workers<I, O> {
	// list to hold threads
	private List<Thread> threadList;

	// private List<E> inputs = new ArrayList<E>();

	/**
	 * It will create no. of threads as input.length
	 * create new worker thread, assigns job to worker and start them
	 */
	public void work(List<I> inputs) {
		threadList = new ArrayList<Thread>();
		Iterator<I> itr = inputs.iterator();
		// create new thread and add job to it with input one by one from
		// iterator
		while (itr.hasNext()) {
			threadList.add(new Thread(new InputJob<I>(itr.next())));
		}
		// start every thread to work
		for (Thread t : threadList) {
			t.start();
		}
	}

	/**
	 * No. of threads will be given by you and 
	 * @param inputs : List<I> inputs will be given for executing different tasks requires different inputs.
	 * @param noOfThreads : No. of threads we want to create in threadPool
	 * @return results : List<Future<O>> puts all result in Future<O> and get them using future's get method by iterating list.
	 * @throws InterruptedException
	 * @throws ExecutionException
	 */
	public List<Future<O>> work(List<I> inputs, int noOfThreads)
			throws InterruptedException, ExecutionException {
		ExecutorService pool = Executors.newFixedThreadPool(noOfThreads);
		List<Future<O>> results = new ArrayList<>();
		Iterator<I> itr = inputs.iterator();
		while (itr.hasNext()) {
			Callable<O> worker = new CallableJob<I, O>(itr.next());
			results.add(pool.submit(worker));
		}
		pool.shutdown();
		return results;
	}

	/**
	 * Each and every thread works same as written in Job run method.
	 * 
	 * @param nThreads
	 *            : No. of threads on which you want to work
	 */
	public void work(int nThreads) {
		int i = 0;
		threadList = new ArrayList<Thread>();
		while (i++ < nThreads)
			threadList.add(new Thread(new Job()));
		// start every thread to work
		for (Thread t : threadList) {
			t.start();
		}
	}

	/**
	 * @return true: if passed thread completes it's task under patienceTime <br/>
	 *         false: if passed thread doesn't completes it's task under
	 *         patienceTime
	 * @param t
	 *            : pass a thread which you need to check whether thread's work
	 *            is completed or not.
	 * @param checkTime
	 *            : interval of time you'll check continuously whether thread
	 *            completed it's task or not. (in millisecond)
	 * @param patienceTime
	 *            : Maximum patience time you want this thread to complete it's
	 *            task otherwise break; (in millisecond)
	 */
	public boolean hasThreadCompletedWork(Thread t, int checkTime,
			long patienceTime) {
		long startTime = System.currentTimeMillis();
		while (t.isAlive()) {// thread still working ?
			try {
				t.join(checkTime);// wait checkTime ms for t thread to completed
									// it's work
				if (((System.currentTimeMillis() - startTime) > patienceTime)
						&& t.isAlive()) {
					t.interrupt(); // end this thread's work sends to catch
					// t.join();
				}
			} catch (InterruptedException ie) {
				return false;
			}
		}
		return true;
	}
}
