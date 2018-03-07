package com.array;

import java.util.Scanner;

public class ReverseArrayInGroups {
	public static void main(String args[]) throws Exception {
		Scanner in = new Scanner(System.in);
		int t = in.nextInt();
		int [][] result = new int[t][];
		for (int i = 0; i < t; i++) {
			int n = in.nextInt();
			int [] arr = new int[n];
			for (int j = 0; j < n; j++) {
				arr[j] = in.nextInt();
			}
			int k = in.nextInt();
			result[i] = reverseArrayInGroups(arr, k); 
		}
		for (int i = 0; i < result.length; i++) {
			for (int j = 0; j < result[i].length; j++) {
			    System.out.print(result[i][j]+" ");
			}
		    System.out.println();
		}
		in.close();
	}

	private static int[] reverseArrayInGroups(int[] arr, int k) {
		for (int i = 0; i< (arr.length/k)+1; i++) {
			if((i+1)*k-1> arr.length-1) {
				reverseArrayInGroups(arr, i*k, arr.length-1);
			}else {
				reverseArrayInGroups(arr, i*k, (i+1)*k-1);
			}
		}
		return arr;
	}
	
	private static int[] reverseArrayInGroups(int[] arr, int start, int end) {
		int j = end;
		for (int i = start; i!=j && i<j; i++, j--) {
			int temp = arr[i];
			arr[i]= arr[j];
			arr[j] = temp;
		}
		return arr;
	}
	
}