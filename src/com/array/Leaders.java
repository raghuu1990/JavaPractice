package com.array;

import java.util.Scanner;

public class Leaders {
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
			result[i]= findLeader(arr); 
		}
		for (int i = 0; i < result.length; i++) {
			for (int j = result[i].length-1; j >=0; j--) {
			    if(result[i][j]!=-1){
				    System.out.print(result[i][j]+" ");
			    }
			}
			System.out.println();
		}
		in.close();
	}

	private static int[] findLeader(int[] arr) {
		int l = arr.length;
		int j = 1;
		int[] result = new int[l];
		for (int i = 0; i < result.length; i++) {
			result[i] = -1;
		}
		result[0] = arr[l-1];
		int max = arr[l-1];
		for (int i = l-2; i >= 0; i--) {
			if(arr[i]>max) {
				max = arr[i];
				result[j] = arr[i];
				j++;
			}
		}
		return result;
	}
}