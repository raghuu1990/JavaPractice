package com.bit;

import java.util.Scanner;

// https://www.hackerrank.com/challenges/xor-matrix

// TODO :

public class XorMatrix {
	public static void main(String[] args) {
		Scanner in = new Scanner(System.in);
		int c = in.nextInt();
		long r = in.nextLong();
		long[] input = new long[c];

		for (int i = 0; i < c; i++) {
			input[i] = in.nextLong();
		}
		long[] output = xorMatrix(input, r);
		printMatrix(output);
		in.close();
	}

	private static long[] xorMatrix(long[] input, long r) {
		if (r < 2) {
			return input;
		}
		int c = input.length;
		long[] output = new long[c];

		for (int j = 0; j < c; j++) {
			if (j == c - 1) {
				output[j] = input[j] ^ input[0];
			} else {
				output[j] = input[j] ^ input[j + 1];
			}
		}
		//printMatrix(output);
		return xorMatrix(output, --r);
	}
	
	private static void printMatrix(long[] input){
		int c = input.length;
		for (int i = 0; i < c; i++) {
            System.out.print(input[i]);
			if(i!=c-1) {
				System.out.print(" ");
			}
		}
		System.out.println();
	}
}