package com.prem.thread.concurrent.work;

import java.util.concurrent.Callable;

/*
 * A task that returns a result and may throw an exception.
 * Implementors define a single method with no arguments called call. 
 *
 * The Callable interface is similar to java.lang.Runnable, 
 * in that both are designed for classes whose instances are potentially executed by another thread.
 * A Runnable, however, does not return a result and cannot throw a checked exception.
 *  
 */
public class CallableJob<I,O> implements Callable<O> {

	private I i;	
	public CallableJob(I i){
		setI(i);
	}
	public I getI() {
		return i;
	}
	public void setI(I i) {
		this.i = i;
	}
	@Override
	public O call() throws Exception {
		Thread.sleep(5000);
		for(int i=0;i<65000;i++){
			System.out.print("");
		}
		O o=(O) (getI()+", ");
		return o;
	}
}