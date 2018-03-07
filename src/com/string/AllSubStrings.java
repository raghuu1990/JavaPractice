package com.string;

import java.util.ArrayList;

public class AllSubStrings {

	public static ArrayList<String> allSubString(String str) {
		ArrayList<String> subStrings = new ArrayList<String>();
	    for (int len = 1; len <= str.length(); len++) {    
	        for (int i = 0; i <= str.length() - len; i++){
	            //  Print characters from current starting point to current ending point.  
	            subStrings.add(str.substring(i, i + len));
	        }
	    }
	    return subStrings;
	}

	public static ArrayList<String> allSubStrings(String str) {
		ArrayList<String> subStrings = new ArrayList<String>();
		for (int i = 0; i < str.length(); i++) {
			for (int j = i + 1; j <= str.length(); j++) {
				subStrings.add(str.substring(i, j));
			}
		}
		return subStrings;
	}

	public static void main(String[] args) {
		String str = "abc";
		ArrayList<String> subStrings = allSubStrings(str);
		//ArrayList<String> subStrings = allSubString(str);
		for (int i = 0; i < subStrings.size(); i++) {
			System.out.println(subStrings.get(i));
		}
	}
}