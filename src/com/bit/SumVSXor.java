package com.bit;

import java.util.Scanner;

// https://www.hackerrank.com/challenges/sum-vs-xor

public class SumVSXor {
	public static void main(String[] args) {
		Scanner in = new Scanner(System.in);
		long t = in.nextLong();
        System.out.println((long) Math.pow(2, findNoOfZero(t)));
		in.close();
	}
	
	private static long findNoOfZero(long x){
		long count = 0;
		for (int i = 62; i >= 0; i--) {
            if((((long)1)<<i) < x) {
                if (((((long)1)<<i) & x) == 0) {
				    count++;
                }
			}
		}
	    return count;
	}
}