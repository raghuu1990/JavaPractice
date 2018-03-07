package com.bit;

import java.util.Scanner;

// https://www.hackerrank.com/challenges/maximizing-xor

public class MaximizingXOR {
	
	public static void main(String[] args) {
		Scanner in = new Scanner(System.in);
		int l = in.nextInt();
		int r = in.nextInt();
		System.out.println(maxXor(l, r));
		in.close();
	}

	private static int maxXor(int min, int max) {
        int x = indexOfFirstOneBitFromLeft(min ^ max);
        return x == -1 ? 0 : (1<<(x+1)) - 1;
    }

    private static int indexOfFirstOneBitFromLeft(int n) {
        for (int i = 62; i >= 0; i--) {
            if (((1<<i) & n) == (1<<i)) {
                return i;
            }
        }
        return -1;
    }
}