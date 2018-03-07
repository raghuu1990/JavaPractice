package com.array;

import java.util.PriorityQueue;
import java.util.Scanner;

// http://practice.geeksforgeeks.org/problems/kth-largest-element-in-a-stream/0

public class KthLargestElement {
	private static PriorityQueue<Integer> minHeap = new PriorityQueue<Integer>();
	public static void main(String args[]) throws Exception {
		Scanner in = new Scanner(System.in);
		int t = in.nextInt();
		int [][] result = new int[t][];
		for (int i = 0; i < t; i++) {
			int k = in.nextInt();
			int n = in.nextInt();
			int [] arr = new int[n];
			for (int j = 0; j < n; j++) {
				arr[j] = in.nextInt();
			}
			result[i] = kthlargestElement(arr, k); 
		}
		for (int i = 0; i < result.length; i++) {
			for (int j = 0; j < result[i].length; j++) {
				System.out.print(result[i][j]+" ");
			}
			System.out.println();
		}
		in.close();
	}

	private static int[] kthlargestElement(int[] arr, int k) {
		int l = arr.length;
		int [] result = new int[l];
		int resultIndex = 0;
		for (int i = 0; i < l; i++) {
			if(minHeap.size()==k && minHeap.peek()<arr[i]) {
				minHeap.poll();
				minHeap.add(arr[i]);
				result[resultIndex++]=minHeap.peek();
			}else if(minHeap.size()==k) {
				result[resultIndex++]=minHeap.peek();
			} else if (minHeap.size()<k){
				minHeap.add(arr[i]);
				if(minHeap.size()==k) {
					result[resultIndex++]=minHeap.peek();
				}else{
				    result[resultIndex++]=-1;
				}
			}
		}
		return result;
	}
}