package com.basics;

import java.util.Scanner;

public class MakeItAnagram {

	public static void main(String[] args) {
		/* Enter your code here. Read input from STDIN. Print output to STDOUT. Your class should be named Solution. */
		Scanner myScan = new Scanner(System.in);
		String str1 = myScan.nextLine();
		String str2 = myScan.nextLine();
		
		int ans = anagramDiffrence(str1, str2);
		System.out.println(ans);
		myScan.close();
	}

	public static int anagramDiffrence(String str1, String str2){
		int [] hash1 = new int[256];
		str1 = str1.toLowerCase();
		for(int i =0 ; i<str1.length() ; i++) {
			int c = str1.charAt(i);
			hash1[c] = hash1[c]+1;
		}

		int [] hash2 = new int[256];
		str2 = str2.toLowerCase();
		for(int i =0 ; i<str2.length() ; i++) {
			int c = str2.charAt(i);
			hash2[c] = hash2[c]+1;
		}

		
		int count = 0;
		
		for(int i = 'a'; i<= 'z'; i++){
			count+= absolute(hash1[i]-hash2[i]);
		}
		return count;
	}
	
	public static int absolute(int a){
		if(a<0){
			return -1*a;
		}
		return a;
	}
}
