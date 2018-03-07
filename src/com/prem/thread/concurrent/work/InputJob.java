package com.prem.thread.concurrent.work;

class InputJob<E> implements Runnable {
	private E input;

	public InputJob(E input) {
		setInput(input);
	}

	// do the job given by the thread
	public void run() {
		try {
			// your work starts here

			Thread.sleep(5000);
			System.out.println(getInput());

			// your work ends here
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
	}

	public E getInput() {
		return input;
	}

	public void setInput(E input) {
		this.input = input;
	}
}