package com.company.zapstitch;

import java.util.Scanner;

public class KingsLand {

	public static void main(String args[]) throws Exception {
		Scanner in = new Scanner(System.in);
		int T = in.nextInt();
		for (int i = 1; i <= T; i++) {
			int N = in.nextInt();
			int a[][] = new int[N][4];
			int area = 0;
			for (int j = 0; j < N; j++) {
				a[j][0] = in.nextInt();
				a[j][1] = in.nextInt();
				a[j][2] = in.nextInt();
				a[j][3] = in.nextInt();
			}
		}
		in.close();
	}

	public static int unionArea() {
		return 0;
	}
}
