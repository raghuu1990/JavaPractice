package com.basics;

import java.util.Scanner;

public class AnagramOfPalindrome {


	public static void main(String[] args) {
		/* Enter your code here. Read input from STDIN. Print output to STDOUT. Your class should be named Solution. */
		Scanner myScan = new Scanner(System.in);
		String inputString = myScan.nextLine();
		String ans = isAnagramOfPalindrome(inputString);
		System.out.println(ans);
		myScan.close();
	}

	public static String isAnagramOfPalindrome( String inputString){
		int [] hash = new int[256];
		int count = 0;
		inputString = inputString.toLowerCase();
		for(int i =0 ; i<inputString.length() ; i++) {
			int c = inputString.charAt(i);
			hash[c] = hash[c]+1;
		}

		for(int i = 'a'; i<= 'z'; i++){
			if(hash[i]%2==1){
				++count;
			}
			if(count>1){
				break;
			}
		}

		if(count>1){
			return "NO";
		}else{
			return "YES";
		}
	}
}
