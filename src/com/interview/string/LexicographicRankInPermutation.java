package com.interview.string;

import com.utils.MathUtils;

public class LexicographicRankInPermutation {

	// You can create a AVL tree to efficiently find total number of smaller characters.
	// You can keep size of subtree at root and keep moving left or right depending on the character you looking for

	// This is O(n^2) solution
	private int numberOfSmallerCharactersOnRight(int index, char[] str) {
		int count = 0;
		for (int i = index + 1; i < str.length; i++) {
			if (str[i] < str[index]) {
				count++;
			}
		}
		return count;
	}

	public int rank(char[] str) {
		int rank = 0;
		for (int i = 0; i < str.length; i++) {
			int num = numberOfSmallerCharactersOnRight(i, str);
			rank += MathUtils.factorial(str.length - i - 1) * num;
		}
		return rank + 1;
	}

	public static void main(String args[]) {
		LexicographicRankInPermutation lrp = new LexicographicRankInPermutation();
		int rank = lrp.rank("STRING".toCharArray());
		//int rank = lrp.rank("bab".toCharArray());
		System.out.println(rank);
	}
}