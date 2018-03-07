package com.hash;


import java.util.HashMap;
import java.util.Scanner;

// https://www.hackerrank.com/challenges/30-dictionaries-and-maps/problem

public class DictionariesAndMaps {
	private static HashMap<String, Integer> map = new HashMap<String, Integer>();
	
	public static void main(String[] argh) {
		Scanner in = new Scanner(System.in);
		int n = in.nextInt();
		for (int i = 0; i < n; i++) {
			String name = in.next();
			int phone = in.nextInt();
			if(!map.containsKey(name)) {
				map.put(name, phone);
			}
		}
		while (in.hasNext()) {
			String s = in.next();
			if(map.containsKey(s)) {
				System.out.println(s+"="+map.get(s));
			}else {
				System.out.println("Not found");
			}
		}
		in.close();
	}
}
