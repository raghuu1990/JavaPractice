package com.array;

// http://codingbat.com/prob/p125819
public class ModifyArray {
	public static void main(String args[]) throws Exception {
		int[] arr = { 5, 4, 9, 4, 9, 5 };
		for (int i = 0; i < arr.length; i++) {
			System.out.print(arr[i]+" ");
		}
		System.out.println();
		arr = fix45(arr);
		for (int i = 0; i < arr.length; i++) {
			System.out.print(arr[i]+" ");
		}
	}

	public static int[] fix45(int[] a) {
		int i = 0, j = 0;
		int n = a.length;

		while (i + 1 < n && j < n) {
			while (i + 1 < n && (a[i] != 4 || (a[i] == 4 && a[i + 1] == 5))) {
				i++;
			}

			while (j < n && (a[j] != 5 || (j > 0 && a[j] == 5 && a[j - 1] == 4))) {
				j++;
			}

			if (i + 1 < n && j < n) {
				swap(a, i + 1, j);
			}
			i = i + 2;
			j++;
		}
		return a;
	}

	public static void swap(int[] arr, int a, int b) {
		int t = arr[a];
		arr[a] = arr[b];
		arr[b] = t;
	}
}