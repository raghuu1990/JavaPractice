package com.basics;

import java.util.Scanner;

public class DiagonalMatrixDifference {
	
	public static void main(String[] args) {
		Scanner in = new Scanner(System.in);
		int n = in.nextInt();
		int [][] a= new int [n][n];
		int sumD1 = 0;
		int sumD2 = 0;

		for (int i=0;i<n;i++) {
			for (int j=0;j<n;j++) {
				a[i][j] = in.nextInt();
				if(i==j){
					sumD1 +=  a[i][j];
				}
				if(i+j == (n-1)){
					sumD2 +=  a[i][j];
				}
			}
		}
		int sum = sumD1-sumD2;
		sum = (sum>-1)?sum:(-1*sum);
		System.out.println(sum);
	}
}
