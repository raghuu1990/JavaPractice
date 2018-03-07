package com.string;

import java.util.Scanner;
import java.util.TreeSet;

// http://practice.geeksforgeeks.org/problems/string-subsequence-game/0

public class StringSubsequence {
	public static void main(String[] args) {
		Scanner in = new Scanner(System.in);
		int t = in.nextInt();
		String input[] = new String[t];
		for (int i = 0; i < t; i++) {
			input[i] = in.next();
		}
		for (int j = 0; j < input.length; j++) {
			TreeSet<String> set = allSubSequesnes(input[j], "", new TreeSet<String>(), 0);
			int i = 0;
			if(set.size()==0) {
				System.out.print("-1");
			}
			for (String str : set) {
				System.out.print(str);
				i++;
				if(i<set.size()) {
					System.out.print(" ");
				}
			}
			if(j < input.length-1) {
				System.out.println();
			}
		}
		in.close();
	}

	public static TreeSet<String> findSubstrings(String str) {
		TreeSet<String> set = new TreeSet<>();
		for (int i = 0; i < str.length(); i++) {
			for (int j = i + 1; j <= str.length(); j++) {
				String st = str.substring(i, j);
				if (isVowel(st.charAt(0)) && !isVowel(st.charAt(st.length() - 1))) {
					set.add(st);
				}
			}
		}
		return set;
	}

	public static TreeSet<String> allSubSequesnes(String input, String str, TreeSet<String> set, int i) {
		if (i == input.length()) {
			if (str.length()>0 && isVowel(str.charAt(0)) && !isVowel(str.charAt(str.length() - 1))) {
				set.add(str);
			}
			return set;
		}
		allSubSequesnes(input, str + input.charAt(i), set, i + 1);
		allSubSequesnes(input, str, set, i + 1);
		return set;
	}

	public static boolean isVowel(char c) {
		if (c == 'a' || c == 'i' || c == 'e' || c == 'o' || c == 'u') {
			return true;
		}
		return false;
	}
}