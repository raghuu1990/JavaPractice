package com.company.ola;

import java.io.FileNotFoundException;
import java.io.IOException;

public class MainClass {
	public static void main(String[] args) throws FileNotFoundException, ClassNotFoundException, IOException, InterruptedException {
		
		String url = "http://www.yatra.com";
		String header = "header";
		String bodyObject = "body";
		int expectedResponseCode = 200;

		Scheduler scheduler = new Scheduler();
		Executor executor = new Executor();

		new Thread(scheduler).start();
		new Thread(executor).start();
		
		Thread.sleep(5000);
		
		System.out.println("---------------------- Project has been started -----------------------------");
		
		
		System.out.println("---------------------- Scheduler has been started -----------------------------");
		
		System.out.println("Calling 1");
		Scheduler.send(url, header, bodyObject, expectedResponseCode);
		
		Thread.sleep(10000);
		
		System.out.println("Calling 2");
		Scheduler.send(url, header, bodyObject, expectedResponseCode);
		
		Scheduler.stop(false);
		System.out.println("----------------------------- SYSTEM STOPED -----------------------------------");
		
		System.out.println("Calling 3");
		Scheduler.send(url, header, bodyObject, expectedResponseCode);
		
		System.out.println("Calling 4");
		Scheduler.send(url, header, bodyObject, expectedResponseCode);
		
		System.out.println("Calling 5");
		Scheduler.send(url, header, bodyObject, expectedResponseCode);
		
		System.out.println("Calling 6");
		Scheduler.send(url, header, bodyObject, expectedResponseCode);
		
		Scheduler.stop(true);
		System.out.println("----------------------------- SYSTEM STARTED ----------------------------------");
		
		System.out.println("Calling 7");
		Scheduler.send(url, header, bodyObject, expectedResponseCode);
		
		System.out.println("Calling 8");
		Scheduler.send(url, header, bodyObject, expectedResponseCode);

		System.out.println("Calling 9");
		Scheduler.send(url, header, bodyObject, expectedResponseCode);
		
		System.out.println("Calling 10");
		Scheduler.send(url, header, bodyObject, expectedResponseCode);

		System.out.println("Calling 11");
		Scheduler.send(url, header, bodyObject, expectedResponseCode);
		
		System.out.println("Calling 12");
		Scheduler.send(url, header, bodyObject, expectedResponseCode);

		System.out.println("Calling 13");
		Scheduler.send(url, header, bodyObject, expectedResponseCode);
		
		System.out.println("Calling 14");
		Scheduler.send(url, header, bodyObject, expectedResponseCode);
		
		System.out.println("Calling 15");
		Scheduler.send(url, header, bodyObject, expectedResponseCode);
		
		System.out.println("Calling 16");
		Scheduler.send(url, header, bodyObject, expectedResponseCode);

		System.out.println("--------------------- All request submitted successfully ----------------------");
	}
}