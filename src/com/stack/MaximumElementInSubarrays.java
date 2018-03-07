package com.stack;

import java.util.Deque;
import java.util.LinkedList;
import java.util.Scanner;

// https://www.hackerrank.com/challenges/ctci-balanced-brackets

public class MaximumElementInSubarrays {
	public static void main(String[] args) {
		Scanner in = new Scanner(System.in);
		int t = in.nextInt();
		int result[][] = new int[t][];
		for (int i = 0; i < t; i++) {
			int n = in.nextInt();
			int k = in.nextInt();
			int [] arr = new int[n];
			for (int j = 0; j < n; j++) {
				arr[j] = in.nextInt();
			}
			result[i] = getMaxElement(arr, k);
		}
		for (int i = 0; i < t; i++) {
			for (int j = 0; j < result[i].length; j++) {
				if(result[i][j]!=-1){
				    System.out.print(result[i][j]+" ");
				}
			}
			System.out.println();
		}
		in.close();
	}

	private static int[] getMaxElement(int[] arr, int k) {
		Deque<Integer> q = new LinkedList<Integer>();
		int l = arr.length;
		int result[] = new int[l];
		int result_index = 0;
		for (int i = 0; i < l; i++) {
			result[i] = -1;
		}
		
		for (int i = 0; i < k; i++) {
			while(!q.isEmpty() && arr[q.getLast()]<=arr[i]) {
				q.removeLast();
			}
			q.addLast(i);
		}

		for (int i = k; i < l; i++) {
			result[result_index++] = arr[q.getFirst()];
			
			while(!q.isEmpty() && q.getFirst()<=i-k) {
				q.removeFirst();
			}
			
			while(!q.isEmpty() && arr[q.getLast()]<=arr[i]) {
				q.removeLast();
			}
			q.addLast(i);
		}
		result[result_index++] = arr[q.getFirst()];
		return result;
	}
}