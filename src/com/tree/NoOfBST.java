package com.tree;

/**
*
*                   (2n)!
*  Catalan's No = __________
*                 (n+1)!(n)!
*   
*   (n=3)  ->      6!
*                ____  = 5
*                4!3!
*
*/

public class NoOfBST {
	private static int[] countCache;

	public static void main(String[] args) {
		System.out.println(getNoOfBSTs(5));
	}

	public static int getNoOfBSTs(int n) {
		countCache = new int[n + 1];
		countCache[0] = 1;
		countCache[1] = 1;
		System.out.println("0 : 0");
		for (int i = 2; i <= n; i++) {
			System.out.print(i+" : ");
			for (int j = 0; j < i; j++) {
				countCache[i] += countCache[j] * countCache[i - j - 1];
				System.out.print("("+j+" , "+(i - j - 1)+"), ");
			}
			System.out.println();
		}
		return countCache[n];
	}
}