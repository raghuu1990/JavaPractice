package com.bigdatastructure;

import java.math.BigDecimal;
import java.util.Arrays;
import java.util.Collections;
import java.util.Comparator;
import java.util.Scanner;

// https://www.hackerrank.com/challenges/java-biginteger/problem

public class JavaBigDecimal {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int n = sc.nextInt();
		String[] s = new String[n + 2];
		for (int i = 0; i < n; i++) {
			s[i] = sc.next();
		}

		Arrays.sort(s, 0, n, Collections.reverseOrder(new Comparator<String>() {
			@Override
			public int compare(String s1, String s2) {
				BigDecimal a = new BigDecimal(s1);
				BigDecimal b = new BigDecimal(s2);
				return a.compareTo(b);
			}
		}));

		// Output
		for (int i = 0; i < n; i++) {
			System.out.println(s[i]);
		}
		sc.close();
	}
}