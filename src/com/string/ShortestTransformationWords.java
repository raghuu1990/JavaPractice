package com.string;

import java.util.HashSet;
import java.util.Scanner;
import java.util.Set;
/*

hit
cog
5
hot
dot
dog
lot
log

*/
public class ShortestTransformationWords {
	public static void main(String[] args) {
		Scanner in = new Scanner(System.in);
		String startWord = in.nextLine();
		String targetWord = in.nextLine();
		int n = in.nextInt();
		in.nextLine();
		Set<String> words = new HashSet<String>();
		for (int i = 0; i < n; i++) {
			words.add(in.nextLine());
		}
		System.out.println(shortestTransformation(startWord, targetWord, words));
		in.close();
	}

	private static int shortestTransformation(String startWord, String targetWord, Set<String> words) {
		words.add(targetWord);
		return shortestTransformation(targetWord, words, startWord, 0);
	}
	
	private static int shortestTransformation(String targetWord, Set<String> words, String currWord, int count) {
		if(targetWord.equalsIgnoreCase(currWord)) {
			return count++;
		}

		int min = Integer.MAX_VALUE;
		Set<String> dict = diffOneDict(currWord, words);
		for(String word : dict) {
			if(targetWord.equalsIgnoreCase(word)) {
				return ++count;
			}else {
				 words.remove(word);
				 int k =  shortestTransformation(targetWord, words, word, count+1);
				 min = Math.min(min, k);
				 words.add(word);
			}
		}
		if(min>count){
			return min;
		}
		return 0;
	}
	
	private static Set<String> diffOneDict(String word, Set<String> words){
		Set<String> dict = new HashSet<String>();
		for(String w : words) {
			if(equals(word, w, 1)){
				dict.add(w);
			}
		}
		return dict;
	}
	
	static boolean equals(String word1, String word2, int mistakesAllowed) {
	    if(word1.equals(word2) || word1.length()!=word2.length()) {
	        return false;
	    }

	    if(word1.length() == word2.length()) {
	        for(int i = 0; i < word1.length(); i++) {
	            if(word1.charAt(i) != word2.charAt(i)) {
	                mistakesAllowed--;
	                if(mistakesAllowed < 0) {
	                    return false;
	                }
	            }
	        }
	    }
	    return true;
	}
}