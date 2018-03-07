package com.company.mmt;

import java.util.Iterator;
import java.util.LinkedHashSet;

public class OrderedSet {

	public static void main(String[] args) {
		LinkedHashSet<Character> set = new LinkedHashSet<Character>();
		set.add('a');
		set.add('b');
		set.add('c');
		set.add('d');
		set.add('e');
		String str1 = "1a2b3c4d5e6f";
		String str2 = "1a2b3c4e5d6f";
		String str3 = "mnopabcdxyz";
		isContainAll(set, str1);
		isContainAllInOrder(set, str2);
		isContainAllInOrderContinueous(set, str3);
	}

	private static void isContainAll(LinkedHashSet<Character> set, String str) {
		Iterator<Character> it = set.iterator();
		while(it.hasNext()){
			if(!str.contains(it.next().toString())){
				System.out.println("Not contains");
				return;
			}
		}
		System.out.println("Contains All");
	}

	private static void isContainAllInOrder(LinkedHashSet<Character> set, String str) {
		Iterator<Character> it = set.iterator();
		while(it.hasNext()){ 
			String c = it.next().toString();
			int p = str.indexOf(c);
			str = str.substring(p+1);
			if(p==-1){
				return;
			}
		}
		System.out.println("Contains all in order");
	}

	private static void isContainAllInOrderContinueous(LinkedHashSet<Character> set, String str) {
		String temp = "";
		Iterator<Character> it = set.iterator();
		while(it.hasNext()){ 
			temp += it.next().toString();
		}
		if(str.contains(temp)){
			System.out.println("Contains all in continueous order");
		}else {
			System.out.println("Not contains all in continueous order");
		}
	}
}
