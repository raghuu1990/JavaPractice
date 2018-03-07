package com.company.ola;

import java.util.HashMap;
import java.util.Random;

//Class to save request inMemory (Hashmap) : 
public class SaveInMemory implements ISaveRequest {
	private volatile int KeyCounter = 0;
	private static HashMap<String, HttpRequest> store = new HashMap<String ,HttpRequest>();
	@Override
	public String saveRequest(HttpRequest request) {
		System.out.println("Saving Request : inMemory (HashMap) ");
		Random random = new Random();	
		random.nextInt(10);
		String key = "key"+(++KeyCounter);
		store.put(key, request);
		return key;
	}

	@Override
	public HttpRequest fetchRequest(String Key) {
		System.out.println("Fetching Request from : inMemory (HashMap) ");
		return store.get(Key);
	}
}
