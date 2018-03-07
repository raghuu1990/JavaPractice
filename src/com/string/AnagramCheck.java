package com.string;

import java.util.HashMap;
import java.util.Scanner;

// https://www.hackerrank.com/challenges/java-anagrams/problem

public class AnagramCheck {
	public static void main(String[] args) {
		Scanner scan = new Scanner(System.in);
		String a = scan.next();
		String b = scan.next();
		scan.close();
		boolean ret = isAnagram(a, b);
		System.out.println((ret) ? "Anagrams" : "Not Anagrams");
	}

	static boolean isAnagram(String a, String b) {
		if (!(a.length() == b.length())) {
			return false;
		}

		HashMap<Character, Integer> map = new HashMap<Character, Integer>();

		for (char c : a.toCharArray()) {
			c = Character.toLowerCase(c);
			if (map.containsKey(c)) {
				map.put(c, map.get(c) + 1);
			} else {
				map.put(c, 1);
			}
		}

		for (char c : b.toCharArray()) {
			c = Character.toLowerCase(c);
			if (map.containsKey(c)) {
				if (map.get(c) != 1) {
					map.put(c, map.get(c) - 1);
				} else {
					map.remove(c);
				}
			} else {
				return false;
			}
		}
		return true;
	}
}