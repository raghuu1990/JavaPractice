package com.company.housing;

import java.util.Scanner;

// Panagram : string which contain all alphabet a-z 
public class Panagram {
	private static String isPanagram(String inputString) {
		if (inputString.length()<26) {
			return "not pangram";
		}
		inputString = inputString.toLowerCase();
		for (char i = 'a'; i <= 'z'; i++) {
			if (!(inputString.contains(i + ""))) {
				System.out.println(isPanagram(i+""));
				return "not pangram";
			}
		}
		return "pangram";
	}

	public static void main(String args[]){
		/* Enter your code here. Read input from STDIN. Print output to STDOUT. Your class should be named Solution. */
		Scanner in = new Scanner(System.in);
		String str = in.nextLine();
		//String str = "asdfghjkl zxcvbnm qwertyuiop";
		System.out.println(isPanagram(str));
	}
}





