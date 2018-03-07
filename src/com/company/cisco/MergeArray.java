package com.company.cisco;

import java.util.Scanner;

public class MergeArray {
	public static void main(String[] args) {
		Scanner s = new Scanner(System.in);
		int m = s.nextInt();

		int a[] = new int[m];
		int b[] = new int[m];
		for (int i = 0; i < m; i++) {
			a[i] = s.nextInt();
		}
		m = s.nextInt();
		for (int i = 0; i < m; i++) {
			b[i] = s.nextInt();
		}
		int c[] = mergeArrays(a, b);
		for (int i = 0; i < m*2; i++) {
			System.out.println(c[i]);
		}
		s.close();
	}

	public static int[] mergeArrays(int[] a, int[] b) {
		int m = a.length+b.length;
		int c[] = new int[m];
		int i = 0;
		int j = 0;
		int k = 0;
		while (i < a.length && j < b.length) {
			if (a[i] < b[j]) {
				c[k] = a[i];
				i++;
			} else {
				c[k] = b[j];
				j++;
			}
			k++;
		}

		while (i < a.length) {
			c[k] = a[i];
			i++;
			k++;
		}

		while (j < b.length) {
			c[k] = b[i];
			j++;
			k++;
		}
		return c;
	}
}