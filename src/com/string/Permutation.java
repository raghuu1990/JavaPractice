package com.string;

public class Permutation {

	public static void permuteString(String pre, String str) {
		if (0 == str.length()) {
			System.out.println(pre);
		} else {
			for (int i = 0; i < str.length(); i++) {
				permuteString(pre + str.charAt(i), str.substring(0, i) + str.substring(i + 1));
			}
		}
	}

	public static void main(String[] args) {
		String str = "123";
		permuteString("", str);
	}
}