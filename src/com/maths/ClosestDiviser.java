package com.maths;

import java.util.Scanner;

public class ClosestDiviser {
	public static void main(String args[]) throws Exception {
		Scanner sc = new Scanner(System.in);
		int n = sc.nextInt();
		int[] a = new int[n];
		for (int i = 0; i < n; i++) {
			a[i] = sc.nextInt();
		}
		a = findClosestDiviser(a);
		for (int i = 0; i < n; i++) {
			System.out.println(a[i] + " ");
		}
		sc.close();
	}

	public static int[] findClosestDiviser(int[] a) {
		for (int i = 0; i < a.length; i++) {
			int div = -1;
			for (int j = i+1; j < a.length; j++) {
				if(a[i]%a[j]==0) {
					div = a[j];
					break;
				}
			}
			a[i]= div;
		}
		return a;
	}
}