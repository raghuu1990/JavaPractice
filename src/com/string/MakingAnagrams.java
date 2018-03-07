package com.string;

import java.util.Scanner;

// https://www.hackerrank.com/challenges/ctci-making-anagrams/problem

public class MakingAnagrams {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        String a = in.next();
        String b = in.next();
        System.out.println(numberNeeded(a, b));
        in.close();
    }
    
    public static int numberNeeded(String first, String second) {
		int[] freq = new int[26];
    	for (int i = 0; i < first.length(); i++) {
    		freq[first.charAt(i)-97]++;
		}
    	
    	for (int i = 0; i < second.length(); i++) {
    		freq[second.charAt(i)-97]--;
		}
    	
    	int delition = 0;
    	for (int i = 0; i < freq.length; i++) {
			if(freq[i]!=0) {
				delition+= Math.abs(freq[i]);
			}
		}
    	return delition;
    }
}
