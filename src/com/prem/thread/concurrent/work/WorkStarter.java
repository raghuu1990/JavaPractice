package com.prem.thread.concurrent.work;

import java.util.Arrays;
import java.util.Iterator;
import java.util.List;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.Future;

public class WorkStarter {

	public static void main(String[] args) throws InterruptedException,
			ExecutionException {

		/*
		 * Thread t = new Thread(new Job()); t.start();
		 * 
		 * if (new Workers().hasThreadCompletedWork(t, 1000, 7000)) { new
		 * Workers<String,Object>().work(Arrays.asList(new String[] { "prem",
		 * "Satish", "naveen", "hitesh" })); }
		 * System.out.println("Main method");
		 */

		/* new Workers<String>().work(5); */
		List<Future<String>> results = new Workers<String, String>().work(
				Arrays.asList(new String[] { "prem", "Satish", "naveen",
						"hitesh", "prem", "Satish", "naveen", "hitesh" }), 8);
		Iterator<Future<String>> itr = results.iterator();

		while (itr.hasNext()) {
			System.out.println(itr.next().get());
		}
	}
}
