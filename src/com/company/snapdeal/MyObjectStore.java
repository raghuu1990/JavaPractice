package com.company.snapdeal;

import java.sql.Blob;
import java.util.HashMap;

public class MyObjectStore {

	volatile Long uniqueId = 0l;
	volatile Long key = 0l;

	MyBlobDB ObjectStore = new MyBlobDB();
	HashMap<Long, Long> keyMapper = new HashMap<Long, Long>();
	HashMap<Long, Long> keyCounter = new HashMap<Long, Long>();

	//Method returns unique id :
	// For Non duplicate : put data in to DB generate a key for data, map key to unique id for this insertion, update counter of data to  1 
	// For duplicate : get key of existing data, create a unique id and map it to existing data key, and update counter of that data key 
	public Long put(Blob blob){
		if(ObjectStore.containsKey(blob)){
			Long key = ObjectStore.getValue(blob);
			keyMapper.put(++uniqueId, key);
			keyCounter.put(key, keyCounter.get(key)+1);
			return uniqueId;
		}else{
			ObjectStore.put(blob, ++key);
			keyMapper.put(++uniqueId, key);
			keyCounter.put(key, 1l);
			return uniqueId;
		}
	}

	//Method to delete data from DB if not duplicate, otherwise remove from mapping of id and update(-1) counter of data
	public void delete(Long uniqueId){
		if(null!=keyMapper.get(uniqueId)){
			Long key = keyMapper.get(uniqueId);
			if(keyCounter.get(key)==1){
				ObjectStore.removeValue(key);
				keyCounter.remove(key);
				return;
			}
			keyCounter.put(key, keyCounter.get(key)-1);
			keyMapper.remove(uniqueId);
		}
	}

	//Method to get data from DB using unique id
	Blob get(long uniqueId){
		if(null!=keyMapper.get(uniqueId)){
			long key = keyMapper.get(uniqueId);
			Blob blob = ObjectStore.getKey(key);
			return blob;
		}
		return null;
	}

	long size(){
		return ObjectStore.size();
	}

	//Method to convert string data in to Blob
	static Blob stringToBlob(String str){
		try {
			return new javax.sql.rowset.serial.SerialBlob(str.getBytes());
		} catch (Exception e) {
			e.printStackTrace();
		}
		return null;
	}
	
	//Method to convert Blob data in to string
	static String blobToString(Blob blob){
		if(blob == null){
			return null;
		}
		try {
			return new String(blob.getBytes(1, (int) blob.length()));
		} catch (Exception e) {
			e.printStackTrace();
		}
		return null;
	}
	
	public static void main(String[] args) {
		try {

			MyObjectStore snapdealStore = new MyObjectStore();
			
			//TEST CASES 1 : Test size of Empty DB, Should return 0						
			if(snapdealStore.size()!=0)
				throw new RuntimeException("Wrong size");
			
			//TEST CASES 2 : Deleting Empty DB, Should not give any Error 
			snapdealStore.delete(1l);

			//TEST CASES 3 : Fetching data from Empty DB, Should return null
			Blob strShouldBeNull = snapdealStore.get(2);
			if(strShouldBeNull!=null)
				throw new RuntimeException("data not deleted");

			//TEST CASES 4 : Inserting data into DB, Should not give error even for duplicate or empty data 
			Blob blob1 = stringToBlob("snap");
			Blob blob2 = stringToBlob("deal");
			Blob blob3 = stringToBlob("from");
			Blob blob4 = stringToBlob("snapdeal");
			Blob blob5 = stringToBlob("");
			Blob blob6 = stringToBlob("snap");     // Duplicate
			Blob blob7 = stringToBlob("");	       // Duplicate
			Blob blob8 = stringToBlob("snap");	   // Duplicate
			Blob blob9 = stringToBlob("!!");

			//TEST CASES 5 : Fetching data from Empty DB, Should not give any Error
			Long id1 = snapdealStore.put(blob1);
			Long id2 = snapdealStore.put(blob2);
			Long id3 = snapdealStore.put(blob3);
			Long id4 = snapdealStore.put(blob4);
			Long id5 = snapdealStore.put(blob5);
			Long id6 = snapdealStore.put(blob6);
			Long id7 = snapdealStore.put(blob7);
			Long id8 = snapdealStore.put(blob8);
			Long id9 = snapdealStore.put(blob9);


			//TEST CASES 6 : Test size of Empty DB, Should return 6						
			if(snapdealStore.size()!=6)
				throw new RuntimeException("Wrong size");

			//TEST CASES 7 : Test unique Ids fetched from DB for duplicate data, Should not be same
			if (id1 == id6 || id1 == id8 || id6 == id8 || id5 == id7)
				throw new RuntimeException("Ids are equal?");

			String str1 = blobToString(snapdealStore.get(id1));
			String str6 = blobToString(snapdealStore.get(id6));
			String str8 = blobToString(snapdealStore.get(id8));

			//TEST CASES 8 : Test data fetched from DB for duplicate data, Should be same
			if (!str1.equals("snap") || !str6.equals("snap") || !str8.equals("snap"))
				throw new RuntimeException("data not same");

			//TEST CASES 9 : Delete data fetched from DB for a non duplicate entry, Size should be (6-1)=5
			snapdealStore.delete(id9);     //(Removing !!)
			if(snapdealStore.size()!=5)
				throw new RuntimeException("Wrong size");
			
			//TEST CASES 10 : Fetched deleted data from DB for a non duplicate entry, data should be null
			strShouldBeNull = snapdealStore.get(id9);
			if(strShouldBeNull!=null)
				throw new RuntimeException("data not deleted");

			//TEST CASES 11 : Delete data from DB for duplicate entry, Size should be be same
			snapdealStore.delete(id8);     //(Removing snap, id=8)
			if(snapdealStore.size()!=5)
				throw new RuntimeException("Wrong size");
			
			//TEST CASES 12 : Fetched deleted data from DB for a duplicate entry, data should be null
			strShouldBeNull = snapdealStore.get(id8);
			if(strShouldBeNull!=null)
				throw new RuntimeException("data not deleted");

			//TEST CASES 13 : Fetched data from DB for a duplicate entry one of instance is deleted, data should not be null
			if(snapdealStore.get(id1)==null || snapdealStore.get(id6)==null)
				throw new RuntimeException("data not deleted");

			//TEST CASES 14 : Delete all duplicate data from DB, data should be null
			snapdealStore.delete(id1); 
			snapdealStore.delete(id6); 
			if(snapdealStore.get(id1)!=null && snapdealStore.get(id6)!=null)
				throw new RuntimeException("data not deleted");

			//TEST CASES 15 : Test size of DB now, Should return 4						
			if(snapdealStore.size()!=4)
				throw new RuntimeException("Wrong size");

		}catch (Exception e) {
			e.printStackTrace();
		}
		System.out.println("All cases executed succesfully");
	}

}
