package com.company.snapdeal;

import java.sql.Blob;
import java.util.HashMap;

// This class is to save data using two HashMap, exposing some methods to put, remove (by Value/Key), size, contains, get (by Value/Key)
public class MyBlobDB{

	HashMap<Blob, Long> KV = new HashMap<Blob, Long>();
	HashMap<Long, Blob> VK = new HashMap<Long, Blob>();

	public boolean containsKey(Blob key) {
		return KV.containsKey(key);
	}
	
	public void put(Blob key, Long value) {
		KV.put(key, value);
		VK.put(value, key);
	}
	
	public void removeKey(Blob key) {
		VK.remove(KV.get(key));
		KV.remove(key);
	}
	
	public void removeValue(Long value) {
		KV.remove(VK.get(value));
		VK.remove(value);
	}
	
	public Blob getKey(Long value) {
		return VK.get(value);
	}
	
	public Long getValue(Blob key) {
		return KV.get(key);
	}

	public long size() {
		return KV.size();
	}
}
