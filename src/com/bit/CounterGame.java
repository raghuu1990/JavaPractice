package com.bit;

import java.util.Scanner;

// https://www.hackerrank.com/challenges/counter-game

public class CounterGame {// Louise=0 , Richard=1
	public static void main(String[] args) {
		Scanner in = new Scanner(System.in);
		int t = Integer.parseInt(in.next());
		int [] result = new int[t];
		for (int i = 0; i < t; i++) {
			Long a = in.nextLong();
			result[i] = getWinner(a, 0);
		}
		for (int i = 0; i < result.length; i++) {
			if(result[i]==0) {
				System.out.println("Louise");
			}else {
				System.out.println("Richard");
			}
		}
		in.close();
	}

	private static int getWinner(Long n, int player) {
		if(n==1) {
			return player;
		}
        if(isPowerOfTwo(n)) {
			n = n>>1;
		}else {
			n = n - getNumber(n);
		}
		if(n==1) {
			return player;
		}
		return getWinner(n, 1-player);
	}

	// most significant bit of xor of a and b
	private static boolean isPowerOfTwo(long n) {
		for (int i = 63; i > 0; i--) {
			if (((((long)1)<<i) & n) == n) {
				return true;
			}
		}
		return false;
	}
	
	// get greatest no less than n, which is power of 2
	private static Long getNumber(long n) {
		for (int i = 63; i > 0; i--) {
			if (((((long)1)<<i) & n) == (((long)1)<<i)) {
				if((((long)1)<<i) < n) {
					return (long) ((((long)1)<<i));
				}
			}
		}
		return (long) 1;
	}
}