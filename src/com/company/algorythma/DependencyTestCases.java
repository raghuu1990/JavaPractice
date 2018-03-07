package com.company.algorythma;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Scanner;

public class DependencyTestCases {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int n = sc.nextInt();
		int m = sc.nextInt();
		int[] a = new int[n];
		HashMap<Integer, ArrayList<Integer>> map = new HashMap<Integer, ArrayList<Integer>>();
		
		for (int i = 0; i < n; i++) {
			a[i] = sc.nextInt();
			map.put(i+1, new ArrayList<Integer>());
		}
		
		for (int i = 0; i < m; i++) {
			int u = sc.nextInt();
			int v = sc.nextInt();
			map.get(u).add(v);
		}
		
		for (int j = 1; j <= a.length; j++) {
			System.out.println(isTested(j, a, map));
		}
		sc.close();
	}

	private static String isTested(int j, int[] a, HashMap<Integer, ArrayList<Integer>> map) {
		if(a[j-1]==0) {
			return "NO";
		}
		ArrayList<Integer> list = map.get(j);
		for(int i : list) {
			if(isTested(i, a, map).equalsIgnoreCase("NO")) {
				return "NO";
			}
		}
		return "YES";
	}
}