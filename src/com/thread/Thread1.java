package com.thread;

public class Thread1 {

	  public static void main(String[] args){
	 /* thread2 abc = new thread2();
	  
	  abc.run();
	 */  
		System.out.println(Thread.currentThread().getName());
	   
	    for(int i=0; i<10; i++){
	    	System.out.println(i);
	    	new thread3("THREAD"+i).start();
	    }
		
		/*for(int i=0; i<10; i++){
    	System.out.println(i);
    	new Thread(""+i){
    		public void run(){
    				System.out.println("Thread: " + getName() + " running");
        	}
    	}.start();
      
        }*/
		
	  }
}

class thread2 extends Thread implements Runnable {
	public void run() {
		System.out.println("MyThread Runnable running");
	}
}

class thread3 extends Thread {
	String name;

	public thread3(String Name) {
		name = Name;
	}

	public void run() {
		System.out.println(name);
	}
}

class runnable1 extends Thread implements Runnable {
	public void run() {
		System.out.println("My Runnable running");
	}
}