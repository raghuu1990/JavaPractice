package com.basics;

import java.util.Scanner;

public class LibraryFine {
	public static boolean isBefore(int d1, int m1, int y1, int d2, int m2, int y2) {
		if (!(y1 > y2)) {
			if (y1 < y2) {
				return true;
			}
			if (!(m1 > m2)) {
				if (m1 < m2) {
					return true;
				}
				if (!(d1 > d2)) {
					return true;
				}
			}
		}
		return false;
	}

	public static void main(String[] args) {
		Scanner in = new Scanner(System.in);
		int d1 = in.nextInt();
		int m1 = in.nextInt();
		int y1 = in.nextInt();
		int d2 = in.nextInt();
		int m2 = in.nextInt();
		int y2 = in.nextInt();

		if (isBefore(d1, m1, y1, d2, m2, y2)) {
			System.out.println(0);
		} else {
			if (y1 > y2) {
				System.out.println(10000);
			} else if (m1 > m2) {
				System.out.println(500 * (m1 - m2));
			} else if (d1 > d2) {
				System.out.println(15 * (d1 - d2));
			} else {
				System.out.println(0);
			}
		}
		in.close();
	}
}