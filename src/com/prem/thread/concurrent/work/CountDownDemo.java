package com.prem.thread.concurrent.work;

import java.util.concurrent.CountDownLatch;

public class CountDownDemo {

	public static void main(String[] args) throws InterruptedException {
		CountDownLatch counter = new CountDownLatch(5);
		// count from 5 to 0 and then start the race
		// instantiate three runner threads
		new Thread(new Runner(counter, "Prem")).start();
		new Thread(new Runner(counter, "Satish")).start();
		new Thread(new Runner(counter, "Naveen")).start();
		System.out.println("Starting the countdown ");
		long countVal = counter.getCount();
		while (countVal > 0) {
			Thread.sleep(1000); // 1000 milliseconds = 1 second
			System.out.println(countVal);
			if (countVal == 1) {
				// once counter.countDown(); in the next statement is called,
				// Count down will reach zero; so shout "Start"
				System.out.println("Start");
			}			
			counter.countDown(); // count down by 1 for each second/decreases by 1
			countVal = counter.getCount();
		}
	}
}

// this Runner class simulates a track runner in a 100-meter dash race. The
// runner waits until the
// count down timer gets to zero and then starts running
class Runner implements Runnable {
	private CountDownLatch timer;
	private String name;
	public Runner(CountDownLatch timer,String name) {
		this.timer = timer;
		this.name=name;
		System.out.println(getName()
				+ " ready and waiting for the count down to start");	
		
	}

	public String getName() {
		return name;
	}

	public void run() {
		try {
			// wait for the timer count down to reach 0
			timer.await();
		} catch (InterruptedException ie) {
			System.err.println("interrupted -- can't start running the race");
		}
		System.out.println(getName() + " started running");
	}
}