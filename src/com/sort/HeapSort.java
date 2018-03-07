package com.sort;

// childs : l/r : 2n+1, 2n+2 || parent : (n-1)/2 where n is current index
public class HeapSort {
	public static void main(String[] args) {
		int [] arr = {9,1,10,2,11,3,12,4,5,6,7,8};
		print(arr);
		heapSort(arr);
		print(arr);
	}

	private static void heapSort(int[] arr) {
		for (int i = (arr.length/2 -1); i >=0; i--) {
			heapfy(arr, arr.length, i);
		}
		print(arr);
		for (int i = arr.length-1; i >=0 ; i--) {
			swap(arr, 0, i);
			heapfy(arr, i, 0);
		}
	}

	private static void heapfy(int[] arr, int max, int index) {
		int higher = index;
		int l = 2*index+1;
		int r = 2*index+2;
		
		if(l<max && arr[l]>arr[higher]) {
			higher = l;
		}
		
		if(r<max && arr[r]>arr[higher]) {
			higher = r;
		}
		
		if(higher!=index) {
			swap(arr, index, higher);
			heapfy(arr, max, higher);
		}
	}
	
	public static void swap(int[] arr, int i, int j) {
		int temp = arr[i];
		arr[i] = arr[j];
		arr[j] = temp;
	}

	public static void print(int[] arr) {
		for (int i = 0; i < arr.length; i++) {
			System.out.print(arr[i] + " ");
		}
		System.out.println();
	}
}