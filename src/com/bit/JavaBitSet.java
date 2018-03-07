package com.bit;

import java.util.BitSet;
import java.util.Scanner;

// https://www.hackerrank.com/challenges/java-bitset/problem

public class JavaBitSet {

	public static void main(String[] args) {
		Scanner in = new Scanner(System.in);
		int m = in.nextInt();
		int n = in.nextInt();
		BitSet bs1 = new BitSet(m);
		BitSet bs2 = new BitSet(m);
		for (int i = 0; i < n; i++) {
			String opr = in.next();
			int s1 = in.nextInt();
			int s2 = in.nextInt();
			operation(bs1, bs2, opr, s1, s2);
		}
		in.close();
	}

	public static void operation(BitSet bs1, BitSet bs2, String opr, int a, int b) {
		if ("AND".equalsIgnoreCase(opr)) {
			if (a == 1) {
				bs1.and(bs2);
			} else {
				bs2.and(bs1);
			}
		} else if ("OR".equalsIgnoreCase(opr)) {
			if (a == 1) {
				bs1.or(bs2);
			} else {
				bs2.or(bs1);
			}
		} else if ("SET".equalsIgnoreCase(opr)) {
			if (a == 1) {
				bs1.set(b);
			} else {
				bs2.set(b);
			}
		} else if ("FLIP".equalsIgnoreCase(opr)) {
			if (a == 1) {
				bs1.flip(b);
			} else {
				bs2.flip(b);
			}
		} else if ("XOR".equalsIgnoreCase(opr)) {
			if (a == 1) {
				bs1.xor(bs2);
			} else {
				bs2.xor(bs1);
			}
		}
		System.out.println(bs1.cardinality() + " " + bs2.cardinality());
	}
}