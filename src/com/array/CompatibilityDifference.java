package com.array;

// http://www.geeksforgeeks.org/find-compatibility-difference-two-arrays/
public class CompatibilityDifference {
	public static void main(String args[]) {
		/*
		int a1[] = { 3, 1, 2, 4, 5 };
		int a2[] = { 3, 2, 4, 1, 5 };
		*/
		int a1[] = {5, 3, 1, 2, 4};
		int a2[] = {3, 1, 2, 4, 5};
		
		System.out.println(findDifference(a1, a2));
	}

	private static int findDifference(int[] a1, int[] a2) {
		int n = a1.length;
		int i;
		for (i = 0; i < n; i++) {
			if (a1[i] != a2[i]) {
				break;
			}
		}

		i++;
		int d = 0;
		while (i<n && a1[i]!=a2[i]) {
			i++;
			d++;
		}
		return d;
	}
}
