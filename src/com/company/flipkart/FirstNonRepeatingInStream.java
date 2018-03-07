package com.company.flipkart;

import java.util.HashMap;
import java.util.Scanner;

public class FirstNonRepeatingInStream {
	public static void main(String args[]) {
		Scanner in = new Scanner(System.in);
		int t = in.nextInt();
		for (int i = 0; i < t; i++) {
			int a = in.nextInt();
			HashMap<Character, Integer> map = new HashMap<Character, Integer>();
			String str = "";
			for (int j = 0; j < a; j++) {
				str = str + in.next();
				Character c = getFirstNonRepeartingChar(str, map);
				if (c == null) {
					System.out.print("-1");
				} else {
					System.out.print(c);
				}
				System.out.print(" ");
			}
			System.out.println("");
		}
		in.close();
	}

	private static Character getFirstNonRepeartingChar(String str, HashMap<Character, Integer> map) {
		int length = str.length();
		Character ch = str.charAt(length - 1);
		if (map.containsKey(ch)) {
			map.put(ch, map.get(ch) + 1);
		} else {
			map.put(ch, 1);
		}

		for (int i = 0; i < length; i++) {
			Character c = str.charAt(i);
			if (map.get(c) == 1) {
				return c;
			}
		}
		return null;
	}
}