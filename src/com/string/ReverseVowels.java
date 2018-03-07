package com.string;

public class ReverseVowels {

	public static void main(String[] args) {
		String str = "leetcode";
		str = reverseVowels(str);
		System.out.println(str);
	}

	public static String reverseVowels(String s) {
		int l = s.length();
		char[] c = s.toCharArray();

		for (int i = 0, j = l - 1; i < j; i++) {
			if (isVowel(c[i])) {
				while (!isVowel(c[j]) && i< j) {
					j--;
				}
				if (i == j) {
					break;
				} else {
					c = interchangeChar(c, i, j);
				}
				j--;
			}
		}
		return new String(c);
	}

	public static boolean isVowel(char c) {
		if (c == 'a' || c == 'e' || c == 'i' || c == 'o' || c == 'u' || c == 'A' || c == 'E' || c == 'I' || c == 'O'
				|| c == 'U') {
			return true;
		}
		return false;
	}

	public static char[] interchangeChar(char[] charArray, int i, int j) {
		char temp = charArray[i];
		charArray[i] = charArray[j];
		charArray[j] = temp;
		return charArray;
	}
}
