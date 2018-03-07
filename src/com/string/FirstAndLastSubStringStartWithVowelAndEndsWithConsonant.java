package com.string;

import java.util.Collections;
import java.util.PriorityQueue;
import java.util.TreeSet;

public class FirstAndLastSubStringStartWithVowelAndEndsWithConsonant {
	public static void main(String[] args) {
		//String str = "abuac";
		//String str = "aab";
		 String str = "aba";
		findSubstrings(str);
	}
	
	public static TreeSet<String> findSubstrings(String str) {
		TreeSet<String> set = new TreeSet<>();
		PriorityQueue<String> min = new PriorityQueue<String>();
		PriorityQueue<String> max = new PriorityQueue<String>(Collections.reverseOrder());
		for (int i = 0; i < str.length(); i++) {
			if (isVowel(str.charAt(i))) {
				for (int j = i + 1; j <= str.length(); j++) {
					String st = str.substring(i, j);
					if (isVowel(st.charAt(0)) && !isVowel(st.charAt(st.length() - 1))) {
						set.add(st);
						min.add(st);
						max.add(st);
						if (min.size() > 0) {
							min.poll();
						}
						if (max.size() > 0) {
							max.poll();
						}
					}
				}
			}
		}
		System.out.println(set.first());
		System.out.println(set.last());
		return set;
    }
	

	public static boolean isVowel(char c) {
		if (c == 'a' || c == 'i' || c == 'e' || c == 'o' || c == 'u') {
			return true;
		}
		return false;
	}
	
	// Some other Problem Solution
	public static String winner(int[] andrea, int[] maria, String s) {
		long a_sum = 0;
		long m_sum = 0;
		int min_length = Math.min(andrea.length, maria.length);
		
        if(s.equalsIgnoreCase("Even")){
            for (int i = 0; i <= min_length-1; i=i+2) {
            	a_sum += andrea[i];
            	m_sum += maria[i];
			}
        }else if(s.equalsIgnoreCase("Odd")){
        	  for (int i = 1; i <= min_length-1; i=i+2) {
              	a_sum += andrea[i];
              	m_sum += maria[i];
  			}
        }
        if(a_sum==m_sum){
            return "Tie";
        }
        return a_sum>m_sum?"Andrea":"Maria";
    }
}