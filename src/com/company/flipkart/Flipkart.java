package com.company.flipkart;

import java.util.HashMap;
import java.util.Map;
import java.util.Map.Entry;
import java.util.Set;
import java.util.concurrent.ConcurrentHashMap;

public class Flipkart {

	public static void main(String[] args) {
		String[] entities;
		/*
		entities = new String[2];
		entities[0] = "<!ENTITY a1 10>";
		entities[1] = "<!ENTITY a2 a1;a1>";
		entityExpansion(5, entities);
		*/
		/*
		entities = new String[2];
		entities[0] = "<!ENTITY a1 10>";
		entities[1] = "<!ENTITY a1 10>";
		entityExpansion(9, entities);
		*/
		entities = new String[3];
		entities[0] = "<!ENTITY a0 a1;a2>";
		entities[1] = "<!ENTITY a1 a2;a2>";
		entities[2] = "<!ENTITY a2 10>";
		entityExpansion(1, entities);
	}
	
	static long count = 0;
	static long max = 1000000000000000000l;
	static HashMap<String, Long> map = new HashMap<String, Long>();
	static ConcurrentHashMap<String, String[]> equation = new ConcurrentHashMap<String, String[]>();
	
	static void getString(String str) {
		str = str.replace("<!ENTITY", "");
		str = str.replace(">", "");
		str = str.trim();
		String[] keyValue = str.split(" ");

		if(keyValue[1].contains(";")) {
			long c = 0;
			boolean isComplete = true;
			String[] values = keyValue[1].split(";");
			for (int i = 0; i < values.length; i++) {
				if(map.containsKey(values[i])) {
					c += map.get(values[i]);
				}else {
					isComplete =false;
					break;
				}
			}
			if(!isComplete) {
				equation.put(keyValue[0], values);
			}else {
				count+=c;
				map.put(keyValue[0], c);
			}
		}else {
			count++;
			map.put(keyValue[0], 1l);
		}
    }
	
	static void entityExpansion(long l, String[] entities) {
		for (int i = 0; i < entities.length; i++) {
			getString(entities[i]);
		}
		
		equation();
		if(count>max) {
			System.out.println(0);
		}else {
			if(count>l) {
				System.out.print(0);
			}else {
				System.out.print(1);
			}
			System.out.print(" ");
			System.out.print(count);
		}
    }

	private static boolean containsAll(String key, String[] values) {
		long c = 0;
		for(String str : values) {
			if(!map.containsKey(str)) {
				return false;
			}else {
				c+=map.get(str);
			}
		}
		count +=c;
		map.put(key, c);
		return true;
	}

	private static void equation() {
		while(equation.size()>0) {
			Set<Map.Entry<String, String[]>> entrySet = equation.entrySet();
			for (Entry<String, String[]> entry : entrySet) {
				String[] values = entry.getValue();
				if(containsAll(entry.getKey(), values)) {
					entrySet.remove(entry);
				}
			}
		}
	}
}