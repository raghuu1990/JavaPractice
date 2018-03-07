package com.string;

public class ReverseString {

	public static String reverseString(String s) {
		int l = s.length();
		char[] charArray = s.toCharArray();
		for (int i = 0; i < (l + 1) / 2; i++) {
			char temp = charArray[i];
			charArray[i] = charArray[l - i - 1];
			charArray[l - i - 1] = temp;
		}
		return new String(charArray);
	}

	public static void main(String[] args) {
		String str = "leetcode";
		str = reverseString(str);
		System.out.println(str);
	}
}
