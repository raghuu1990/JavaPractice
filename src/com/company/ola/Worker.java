package com.company.ola;

import java.io.FileNotFoundException;
import java.io.IOException;

public class Worker implements Runnable {
	static HttpClient httpClient = new HttpClient();
	HttpRequest request;

	public Worker(HttpRequest request) {
		this.request = request;
	}

	@Override
	public void run() {
		Status status = request.getStatus();
		System.out.println("In Send : "+request.toShortString());
		try {
			if(status.equals(status.INQUEUE)){
				firstTry(request);
			}else if(status.equals(status.PROGRESS)){
				return;
			}else if(status.equals(status.RETRY)){
				retry(request);
			}else{
				return;
			}
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
	}

	public static void firstTry(HttpRequest request) throws InterruptedException {
		setStatus(request, State.UNCOMPLETE, Status.PROGRESS);
		int resCode = httpClient.sendData(request.getUrl(), request.getHeader(), request.getBodyObject());
		if(resCode<0){
			System.out.println(request.toShortString() + " Sender not svailable ----------------------------------");
			return;
		}
		request.setFirstResponseStatus(resCode);
		System.out.println(request.toShortString() + " First Response Code : "+resCode);

		if(resCode==request.getExpectedResponseCode()){
			setStatus(request, State.COMPLETED, Status.SUCCESS);
			System.out.println(request.toShortString() + " Response Code equal to expectedResponseCode");
		}else{
			request.setStatus(Status.RETRY);
			retry(request);
		}
	}

	public static void retry(HttpRequest request) throws InterruptedException {
		int firstResponseStatus = request.getFirstResponseStatus();
		if(firstResponseStatus==request.getExpectedResponseCode()){
			setStatus(request, State.COMPLETED, Status.SUCCESS);
			return;
		}
		request.setStatus(Status.RETRY);
		int noOfRetry = RetryConfiguration.getRetryCount(firstResponseStatus);
		request.setNoOfRetry(noOfRetry);
		System.out.println(request.toShortString() + " RetryCount : " + noOfRetry);
		if(noOfRetry==0){
			System.out.println(request.toShortString() + " No retry logic for this resCode");
			setStatus(request, State.COMPLETED, Status.UNSUCCESS);
			return;
		}
		int i=0;
		while(i<noOfRetry){
			int retryResCode = httpClient.sendData(request.getUrl(), request.getHeader(), request.getBodyObject());
			request.getRetryResponseStatus().add(retryResCode);
			if(retryResCode==request.getExpectedResponseCode()){
				System.out.println(request.toShortString() + " Response Code equal to expectedResponseCode for retry " + (i+1) );
				setStatus(request, State.COMPLETED, Status.SUCCESS);
				return;
			}
			i++;
			System.out.println(request.toShortString() + " Response Code equal to expectedResponseCode for retry " + i );
		}
		System.out.println(request.toShortString() + " unsuccessfully completed");
		setStatus(request, State.COMPLETED, Status.UNSUCCESS);
	}

	private static void setStatus(HttpRequest request, State state, Status status){
		request.setState(state);
		request.setStatus(status);
	}
	
	

	public int send(String url, String header, String bodyObject, int expectedResponseCode) throws FileNotFoundException, IOException, ClassNotFoundException, InterruptedException{

		//Some Configurations can keep in configurations or can take as user request
		String persistanceType = "inMemory"; //   = "inFile";
		int waitTime = 3000;

		//Saving Request
		HttpRequest request = new HttpRequest(url, header, bodyObject, expectedResponseCode);

		//Getting Class to save request according to persistanceType
		ISaveRequest saveFactory= Savefactory.getSavefactory(persistanceType);
		String key = "";
		if(saveFactory==null){
			System.out.println("No Savefactory found retry login will not work");
		}else{
			key = saveFactory.saveRequest(request);
		}
		//Sending First Time
		System.out.println("Request came in send : " + request.toString());
		int resCode = httpClient.sendData(request.getUrl(), request.getHeader(), request.getBodyObject());
		System.out.println("First Response Code : "+resCode);

		if(resCode==expectedResponseCode){
			System.out.println("Response Code equal to expectedResponseCode");
			return resCode;
		}else{
			//Retry case
			System.out.println("Response Code not equal to expectedResponseCode");			
			int retryCount = RetryConfiguration.getRetryCount(resCode);
			System.out.println("RetryCount : " + retryCount);
			if(retryCount==0){
				System.out.println("No retry logic for this resCode");
				return 0;
			}

			if(saveFactory!=null){
				//Fetching Request from Saved Place
				HttpRequest retryRequest = saveFactory.fetchRequest(key); 
				System.out.println("Retry request fetched : " + retryRequest.toString());

				//Retrying
				reSend(retryRequest, retryCount, waitTime);
			}
		}
		return 0;
	}

	// method to resend, max try = retryCount if fails
	private int reSend(HttpRequest retryRequest, int retryCount, int waitTime) throws InterruptedException {
		int i= 0;
		int resCode = 0;
		while(i<=retryCount){
			Thread.sleep(waitTime);
			System.out.println("Retrying : " + i + " time after wait  : " + waitTime);
			resCode = httpClient.sendData(retryRequest.getUrl(), retryRequest.getHeader(), retryRequest.getBodyObject());
			System.out.println("Retrying : " + i + " time res code : " + resCode);
			if(resCode==retryRequest.getExpectedResponseCode()){
				System.out.println("Response Code equal to expectedResponseCode");
				break;
			}
			i++;
		}
		return resCode;
	}

}
