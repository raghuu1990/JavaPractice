package com.array;

public class PalindromeCheck {

	public static boolean isPal(char[] arr) {
		int l = arr.length;
		if (l == 1) {
			return true;
		}
		int b = l - 1;
		int a = 0;

		while (a != b && b > a) {
			if (arr[a] != arr[b]) {
				return false;
			}
			a++;
			b--;
		}
		return true;
	}

	public static void main(char[] args) {
		char[] arr = "12321".toCharArray();
		boolean isPal = isPal(arr);
		System.out.println(isPal);
	}
}
