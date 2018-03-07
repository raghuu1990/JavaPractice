package com.array;

import java.util.Collections;
import java.util.PriorityQueue;
import java.util.Scanner;

public class KthSmallestElement {
	private static PriorityQueue<Integer> maxHeap = new PriorityQueue<Integer>(Collections.reverseOrder());
	public static void main(String args[]) throws Exception {
		Scanner in = new Scanner(System.in);
		int t = in.nextInt();
		int []result = new int[t];
		for (int i = 0; i < t; i++) {
			int n = in.nextInt();
			int [] arr = new int[n];
			for (int j = 0; j < n; j++) {
				arr[j] = in.nextInt();
			}
			int k = in.nextInt();
			result[i]= kthSmallestElement(arr, k); 
		}
		for (int i = 0; i < result.length; i++) {
		    System.out.println(result[i]);
		}
		in.close();
	}

	private static int kthSmallestElement(int[] arr, int k) {
		int l = arr.length;
		for (int i = 0; i < l; i++) {
			if(maxHeap.size()==k && maxHeap.peek()>arr[i]) {
				maxHeap.poll();
				maxHeap.add(arr[i]);
			}else if (maxHeap.size()<k){
				maxHeap.add(arr[i]);
			}
		}
		return maxHeap.poll();
	}
}