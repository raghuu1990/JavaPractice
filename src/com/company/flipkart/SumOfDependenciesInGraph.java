package com.company.flipkart;

import java.util.Scanner;

public class SumOfDependenciesInGraph {
	public static void main(String args[]) {
		Scanner in = new Scanner(System.in);
		int T = in.nextInt();
		for (int i = 0; i < T; i++) {
			int N = in.nextInt();
			int E = in.nextInt();
			for (int j = 0; j < E; j++) {
				int a = in.nextInt();
				int b = in.nextInt();
			}
			System.out.println(E);
		}
		in.close();
	}
}
