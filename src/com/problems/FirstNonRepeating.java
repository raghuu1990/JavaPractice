package com.problems;

import java.util.HashMap;

public class FirstNonRepeating {

	public static Character getFirstNonRepeartingChar(String s){
		HashMap<Character, Integer> map = new HashMap<Character, Integer>();
		int length = s.length();
		for(int i=0; i<length; i++){
			Character ch = s.charAt(i);
			if(map.containsKey(ch)){
				map.put(ch, map.get(ch)+1);
			}else{
				map.put(ch,1);
			}
		}

		for(int i= 0; i<length; i++){
			Character ch = s.charAt(i);
			if(map.get(ch)==1){
				return ch;
			}	
		}
		return null;
	}

	public static void main(String args[]){
		String str = "abcdefabcdef";
		System.out.println("First non-repeating character is : " +getFirstNonRepeartingChar(str));
	}
}
