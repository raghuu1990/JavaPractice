package com.prem.thread.concurrent.work;

import java.util.concurrent.*;

//Creates a CyclicBarrier object by passing the number of threads and the
//thread to run
//when all the threads reach the barrier
class CyclicBarrierTest {
	public static void main(String[] args) throws InterruptedException {
		System.out
				.println("All members of home will eat together when they'll finish their work.");
		CyclicBarrier barrier = new CyclicBarrier(4, new BirthdayCelebration());
		Thread.sleep(1000);
		new Members(barrier, "Prem");
		Thread.sleep(1000);
		new Members(barrier, "Satish");
		Thread.sleep(1000);
		new Members(barrier, "Naveen");
		Thread.sleep(1000);
		new Members(barrier, "Himanshu");
	}
}

// The run() method in this thread should be called only when four members are
// have done their work and ready to enjoy the birthday celebration.

class BirthdayCelebration extends Thread {
	public void run() {
		System.out
				.println("\n\nAll members completed their work.\n Start the Birthday celebration.");		
	}
}


class Members extends Thread {
	CyclicBarrier waitPoint;

	public Members(CyclicBarrier barrier, String name) {
		this.setName(name);
		waitPoint = barrier;
		this.start();
	}

	public void run() {
		System.out.println(getName() + ": Finished his work. ");
		try {
			waitPoint.await(); // await for all four members to finish their work
		} catch (BrokenBarrierException | InterruptedException exception) {
			System.out.println("An exception occurred while waiting... "
					+ exception);
		}
	}
}
