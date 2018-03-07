package com.problems;

import java.util.HashSet;

public class FirstRepeating {
	
	public static Character getFirstRepeartingChar(String s){
		HashSet<Character> set = new HashSet<Character>();
		int length = s.length()-1;
		Character c = null;
		for(int i=length; i>=0; i--){
			Character ch = s.charAt(i);
			if(set.contains(ch)){
				set.add(ch);
				c = ch;
			}else{
				set.add(ch);
			}
		}
		
		if(c!=null){
			return c;
		}
		return null;
	}

	public static void main(String args[]){
		String str = "abbacde";
		System.out.println("First repeating character is : " +getFirstRepeartingChar(str));
	}
}