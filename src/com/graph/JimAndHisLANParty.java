package com.graph;

import java.util.Scanner;

// https://www.hackerrank.com/challenges/jim-and-his-lan-party/problem

// TODO :

public class JimAndHisLANParty {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int N = sc.nextInt();
		int M = sc.nextInt();
		int Q = sc.nextInt();
		int[][] maping = new int[Q][2];

		int[] G = new int[N];
		for (int i = 0; i < N; i++) {
			G[i] = sc.nextInt();
		}

		for (int i = 0; i < Q; i++) {
			maping[i][0] = sc.nextInt();
			maping[i][1] = sc.nextInt();
		}
		sc.close();
	}
}