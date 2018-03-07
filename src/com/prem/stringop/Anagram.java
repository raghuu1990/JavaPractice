package com.prem.stringop;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

public class Anagram {

	private static final String[] words= {"Prem","merp", "erpm","pmre","marp"};
	
	public static void main(String[] args) {
		
		System.out.println(isAnagram(words[0], words[4]));
		System.out.println(isAnagram2(words[1],words[4]));
		System.out.println(isAnagram3(words[2],words[3]));
	}
	public static boolean isAnagram(String word1,String word2){
		//false if word1 and word2 are null or not of same size
		if(null==word1 || null==word2 || word1.length()!=word2.length())
			return false;
		//true if both are equal
		else if(word1.equalsIgnoreCase(word2))
			return true;

		char[] w1= word1.toLowerCase().toCharArray();
		char[] w2=word2.toLowerCase().toCharArray();
//-------------starts from here

		//sort both of them
		Arrays.sort(w1);
		Arrays.sort(w2);
		System.out.println(w1);
		System.out.println(w2);
		
		//now match if both are same
		return Arrays.equals(w1, w2);
	}

	//not for ignoring cases.
	public static boolean isAnagram2(String word1, String word2){
		if(null==word1||null==word2 || word1.length()!=word2.length()){
			return false;
		}
		//if they are same
		else if(word1.equals(word2))
		{
			return true;
		}
		char[] w1= word1.toCharArray();
		char[] w2= word2.toCharArray();
//-------------starts from here

		//make array of 256 boolean characters to store each ascii chars
		boolean tracker[] = new boolean[256];

		//get ascii value of each character and make that index true in array
		for(int i=0; i<w1.length;++i){
			tracker[w1[i]]=true;
		}
		//now check for all characters if indexes are true for their ascii value
		for(int i=0;i<w2.length;++i){
			if(!tracker[w2[i]]) return false;
		}
		return true;
	}


	public static boolean isAnagram3(String word1,String word2){
		if(null==word1||null==word2 || word1.length()!=word2.length()){
			return false;
		}
		//if they are same
		else if(word1.equals(word2))
		{
			return true;
		}
		char[] w1= word1.toCharArray();
		char[] w2= word2.toCharArray();

		//------------starts from here

		Map<Character,Integer> charMap= new HashMap<>();
		//in charMap put first array entry by char frequency
		for(int i=0;i<w1.length;i++) {
			if (charMap.containsKey(w1[i])) {
				charMap.put(w1[i], charMap.get(w1[i]) + 1);
			} else {
				charMap.put(w1[i], 1);
			}
		}
		//now check each char in charMap for second array and reduce char frequency
		//remove if char frequency remains one and remove entry
		for(int i=0;i<w2.length;i++){
			if(charMap.containsKey(w2[i])){
				if(charMap.get(w2[i])==1){
					charMap.remove(w2[i]);
				}
				else {
					charMap.put(w2[i],charMap.get(w2[i])-1);
				}
			}
		}
		//if all are removed it's anagram
		return charMap.isEmpty() ? true:false;
	}
}