package com.company.ixigo;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;

public class Print {
	/*
	["name":"ut","ut":"th","th":"hn","name":"gh","name1":"tnjn","ut":"yh"]

	name 
	ut
	th
	hn
	yh
	gh
	name1
	tngn

	name:[ ut,gh]
	ut:[th,yh]
	th :[hn]
	name11 :[tngn]

	 */

	static void printMethod(HashMap myMap, String key){
		System.out.println(key);
		if(myMap.containsKey(key)){
			ArrayList<String> l = (ArrayList<String>) myMap.get(key);
			for(String node : l){
				printMethod(myMap, node);
			}
		}
		myMap.remove(key);
	}

	public static void main(String[] args) {
		ArrayList<String> inputList = new ArrayList<String>();
		//List inputList = new List();
		inputList.add("name:ut");
		inputList.add("ut:th");
		inputList.add("th:hn");
		inputList.add("name:gh");
		inputList.add("name1:tngn");
		inputList.add("ut:yh");

		HashMap<String, ArrayList> myMap = new HashMap <String, ArrayList>();

		for (int i=0; i< inputList.size(); i++){
			String element = inputList.get(i);
			String key = element.substring(0, element.indexOf(':'));
			String value = element.substring(element.indexOf(':')+1, element.length());

			if(myMap.containsKey(key)){
				ArrayList temp1 =  myMap.get(key);
				temp1.add(value);
				myMap.put(key, temp1);
			}else{
				ArrayList temp2 = new ArrayList();
				temp2.add(value);
				myMap.put(key, temp2);
			}

		}
		/*
		Iterator it = mp.entrySet().iterator();
	    while (it.hasNext()) {
	        Map.Entry pair = (Map.Entry)it.next();
	        System.out.println(pair.getKey() + " = " + pair.getValue());
	        it.remove(); // avoids a ConcurrentModificationException
	    }*/

		Iterator it =   myMap.entrySet().iterator();
		while(it.hasNext()) {
			Map.Entry pair = (Map.Entry)it.next();
			String key = (String) pair.getKey();
			if(myMap.containsKey(key)){
				System.out.println(key);
				ArrayList<String> l = (ArrayList<String>) myMap.get(key);
				for(String node : l){
					printMethod(myMap, node);
				}
				it.remove();
			}
		}


	}
}
