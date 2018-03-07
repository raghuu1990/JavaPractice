package com.prem.thread.concurrent.work;

public class Job implements Runnable {
	// do the job given by the thread
	public void run() {
		try {
			// your work starts here
			Thread.sleep(7000);
			System.out.println(" I am working");

			// your work ends here
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
	}
}