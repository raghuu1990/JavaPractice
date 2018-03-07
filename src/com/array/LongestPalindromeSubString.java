package com.array;

public class LongestPalindromeSubString {
	public static void main(String[] args) {
		char[] arr = "forgeeksskeegfor".toCharArray();
		System.out.println(longestPalindromeSubString(arr));
	}

	public static void printPalindrome(char[] arr, int start, int end){
		for (int i = start; i <= end; i++) {
			System.out.print(arr[i]);
		}
	}
	
	private static int longestPalindromeSubString(char[] arr) {
		int size = arr.length;
		int table[][] = new int[size][size];
		for (int a = 0; a < size; a++) {
			for (int b = 0; b < size; b++) {
				if (a == b) {
					table[a][b] = 1;
				} else {
					table[a][b] = 0;
				}
			}
		}

		int start = 0;
		int palMaxSize = 1;
		for (int c = 0; c < size - 1; c++) {
			if (arr[c] == arr[c+1]) {
				table[c][c + 1] = 2;
				palMaxSize = 2;
				start = c;
			}
		}

		// size = 10, i = 0-9, k=3-<=10 (<=size), for 1=0,k=3, j=2-7 (<8)(<size-k+1)
		for (int k = 3; k <= size; k++) {
			for (int i = 0; i < size - k + 1; i++) {
				int j = i + k - 1;
				if (table[i + 1][j - 1]!=0 && arr[i] == arr[j]) {
					table[i][j] = k;
					if (k > palMaxSize) {
						start = i;
						palMaxSize = k;
					}
				}
			}
		}
		printPalindrome(arr, start, start+palMaxSize-1);
		return palMaxSize;
	}
}