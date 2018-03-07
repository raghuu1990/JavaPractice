package com.array;

import java.util.Scanner;

// Longest sum continuous subArray
public class AllLeftSmallAllRightLarge {
	public static void main(String args[]) throws Exception {
		Scanner in = new Scanner(System.in);
		int t = in.nextInt();
		int[] result = new int[t];
		for (int i = 0; i < t; i++) {
			int n = in.nextInt();
			int [] arr = new int[n];
			for (int j = 0; j < n; j++) {
				arr[j] = in.nextInt();
			}
			result[i]= find(arr); 
		}
		for (int i = 0; i < result.length; i++) {
		    System.out.println(result[i]);
		}
		in.close();
	}

	private static int find(int[] arr) {
		int l = arr.length;
		
		boolean [] left = new boolean [l];
		boolean [] right = new boolean [l];

		int leftMax = arr[0];
		for (int i =1; i < arr.length-1; i++) {
			if(leftMax<=arr[i]) {
				left[i] = true;
				leftMax=arr[i];
			}else {
				left[i] = false;
			}
		}
		
		int rightMin = arr[l-1];
		for (int i = arr.length-2; i > 0; i--) {
			if(rightMin>=arr[i]) {
				right[i] = true;
				rightMin=arr[i];
			}else {
				right[i] = false;
			}
		}
		
		for (int i = 1; i < l-1; i++) {
			if(right[i]==left[i] && left[i]==true) {
				return arr[i];
			}
		}
		return -1;
	}
}