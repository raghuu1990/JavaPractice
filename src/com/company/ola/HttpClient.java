package com.company.ola;

import java.util.Random;

public class HttpClient {
	
	Random random = new Random();
	int[] statusCodes = {200,201,204,301,302,400,401,422,204,500,502,503,-100};
	
	public int sendData(String url, String header, String bodyObject) {
		try {
			Thread.sleep(1000);
		} catch (InterruptedException e) {
			System.out.println("Exception while Send data");
		}
		return statusCodes[random.nextInt(statusCodes.length)];
	}	
}


