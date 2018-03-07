package com.prem.thread.concurrent.work;

import java.util.concurrent.ArrayBlockingQueue;
import java.util.concurrent.BlockingQueue;

public class ProducerConsumer {

	private static int CAPACITY = 4;
	private BlockingQueue<String> queue = null;

	public ProducerConsumer() {
		queue = new ArrayBlockingQueue<>(ProducerConsumer.CAPACITY);
	}

	public static void main(String[] args) throws InterruptedException {
		ProducerConsumer pc = new ProducerConsumer();
		Producer producer = new Producer(pc.queue);
		Consumer consumer = new Consumer(pc.queue);

		new Thread(producer).start();
		new Thread(consumer).start();
	}
}

class Producer implements Runnable {
	protected BlockingQueue<String> queue = null;

	public Producer(BlockingQueue<String> queue) {
		this.queue = queue;
	}

	@Override
	public void run() {
		try {
			if (queue.remainingCapacity() != 0) {
				queue.put("Prem");
				System.out.println("Prem Added");
				Thread.sleep(2000);
				
				queue.put("Bharti");
				System.out.println("Bharti Added");
				Thread.sleep(2000);
				
				queue.put("Love");
				System.out.println("Love Added");
			} else {
				System.out.print("Queue is Full");
			}
		} catch (InterruptedException ie) {
		}
	}
}

class Consumer implements Runnable {
	protected BlockingQueue<String> queue = null;

	public Consumer(BlockingQueue<String> queue) {
		this.queue = queue;
	}

	@Override
	public void run() {
		try {
			if (!queue.isEmpty()) {
				System.out.println(queue.take()+ " Removed");
				Thread.sleep(2000);
				System.out.println(queue.take()+ " Removed");
				Thread.sleep(2000);
				System.out.println(queue.take()+ " Removed");
			} else {
				System.out.println("Queue is empty");
			}
		} catch (InterruptedException e) {
			System.out.println("Interrupted");
			e.printStackTrace();
		}
	}

}