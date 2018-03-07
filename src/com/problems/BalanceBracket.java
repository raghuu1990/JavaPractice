package com.problems;

import java.util.ArrayList;

// http://www.geeksforgeeks.org/minimum-swaps-bracket-balancing/
// Only continious swap allowed
// []][][ 2 swaps required
// [[][]] is already balanced.

public class BalanceBracket {
	public static void main(String[] args) {
		/*
		String s = "[]][][";
		System.out.println(swapCount(s));
		*/		
		
		String s = "]]][[]][[[";
		System.out.println(swapCount(s));
	}

	public static long swapCount(String input) {
	    // Keep track of '['
	    ArrayList<Integer> openingIndexes = new ArrayList<Integer>();
	    for (int i = 0; i < input.length(); ++i) {
	        if (input.charAt(i) == '[') {
	            openingIndexes.add(i);
	        }
	    }
 
	    if((input.length()/2)!=openingIndexes.size()) {
	    	return -1;
	    }

	    long result = 0; 			// To store result
	    int balanceDiff = 0; 		// To count number of encountered '['
	    int nextOpeningIndex = 0;  	// To track position of next '[' in pos
	   
	 
	    for (int i = 0; i < input.length(); ++i)  {
	        // Increment balanceDiff and move nextOpeningIndex to next position
	        if (input.charAt(i) == '[')  {
	            ++balanceDiff;
	            ++nextOpeningIndex;
	        } else if (input.charAt(i) == ']') {
	            --balanceDiff;
	        }
	        // We have encountered an unbalanced part of string
	        if (balanceDiff < 0) {
	            // Increment result by number of swaps required
	            // i.e. position of next '[' - current position
	            result += openingIndexes.get(nextOpeningIndex) - i;
	            input = swap(input, i, openingIndexes.get(nextOpeningIndex));
	            ++nextOpeningIndex;
	 
	            // Reset balanceDiff to 1
	            balanceDiff = 1;
	        }
	    }
	    return result;
	}
	
	public static String swap(String input, int i , int j) {
		StringBuilder sb = new StringBuilder(input);
		char c1 = input.charAt(i);
		char c2 = input.charAt(j);
		
		sb.setCharAt(i, c2);
		sb.setCharAt(j, c1);
		return sb.toString();
	}
}