package com.company.flipkart;

import java.util.Scanner;

public class GoldMineProblem {
	public static void main(String args[]) {
		Scanner in = new Scanner(System.in);
		int T = in.nextInt();
		for (int i = 0; i < T; i++) {
			int n = in.nextInt();
			int m = in.nextInt();
			int [][] nm = new int [n][m]; 
			for (int j = 0; j < n; j++) {
				for (int k = 0; k < m; k++) {
					nm[j][k] = in.nextInt();
				}
			}
			calculate(nm, n, m);
			int max = 0;
			for (int l = 0; l < n; l++) {
				int c = nm[l][0];
				if(c>max){
					max = c;
				}
			}
			System.out.println(max);
		}
		in.close();
	}
	
	public static void calculate(int[][] nm, int n, int m){
		for (int j = m-2; j >-1 ; j--) {
			for (int i = 0; i < n; i++) {
				int a = i==0 ? 0 : nm[i-1][j+1];
				int b = nm[i][j+1];
				int c = i==n-1 ? 0 : nm[i+1][j+1];
				nm[i][j] = nm[i][j] + Math.max(a, Math.max(b, c));
			}
		}
	}
}
