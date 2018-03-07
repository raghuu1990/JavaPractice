package com.thread;

public class PrintEvenOdd {
	public static boolean flag = false;

	public static void main(String[] args) {
		int[] arr = { 2, 1, 1, 2, 3, 4, 4, 6, 7, 9, 10, 11, 11 };
		//int[] arr = { 1, 2, 3, 4, 5, 6, 7, 8, 9, 10, 11, 12 };
		Input input = new Input(arr, 0);
		new Thread(new OddPrinter(input)).start();
		new Thread(new EvenPrinter(input)).start();
	}
}

class OddPrinter implements Runnable {
	Input input;

	public OddPrinter(Input input) {
		this.input = input;
	}

	@Override
	public void run() {
		synchronized (PrintEvenOdd.class) {
			for (; input.i < input.arr.length;) {
				try {
					if (input.arr[input.i] % 2 == 1) {
						System.out.println(input.arr[input.i] + " ");
						input.i++;
					} else {
						PrintEvenOdd.class.notify();
						PrintEvenOdd.class.wait();
					}
				} catch (InterruptedException e) {
				}
			}
		}
	}
}

class EvenPrinter implements Runnable {
	Input input;

	public EvenPrinter(Input input) {
		this.input = input;
	}

	@Override
	public void run() {
		synchronized (PrintEvenOdd.class) {
			for (; input.i < input.arr.length;) {
				try {
					if (input.arr[input.i] % 2 == 0) {
						System.out.println(input.arr[input.i] + " ");
						input.i++;
					} else {
						PrintEvenOdd.class.notify();
						PrintEvenOdd.class.wait();
					}
				} catch (InterruptedException e) {
				}
			}
		}
	}
}

class Input {
	int[] arr;
	Integer i;

	public Input(int[] arr, int i) {
		this.i = i;
		this.arr = arr;
	}
}