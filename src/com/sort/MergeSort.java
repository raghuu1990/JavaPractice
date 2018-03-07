package com.sort;

public class MergeSort {

	public static void main(String[] args) {
		int arr[] = { 170, 45, 75, 90, 802, 24, 2, 66 };
		mergeSort(arr,  new int[arr.length], 0, arr.length-1);
		print(arr);
	}

	private static void mergeSort(int[] arr, int[] outPut, int low, int high) {
		if (low >= high) {
			return;
		}
		int mid = (low + high) / 2;
		mergeSort(arr, outPut, low, mid);
		mergeSort(arr, outPut, mid + 1, high);
		mergeArrays(arr, outPut, low, high);
	}

	private static void mergeArrays(int[] arr, int[] outPut, int low, int high) {
		int mid = (low + high) / 2;
		
		int leftStart = low;
		int leftEnd = mid;
		int rightStart = mid+1;
		int rightEnd = high;
		int index = low;

		while(leftStart<=leftEnd && rightStart<=rightEnd) {
			if(arr[leftStart]<=arr[rightStart]) {
				outPut[index] = arr[leftStart];
				leftStart++;
				index++;
			}else{
				outPut[index] = arr[rightStart];
				rightStart++;
				index++;
			}
		}
		
		for(int i=leftStart;i<=leftEnd;i++) {
			outPut[index] = arr[leftStart];
			leftStart++;
			index++;
		}
		
		for(int i=rightStart;i<=rightEnd;i++) {
			outPut[index] = arr[rightStart];
			rightStart++;
			index++;
		}

		for(int i=low;i<=high;i++) {
			arr[i] = outPut[i];
		}
	}

	public static void print(int[] arr) {
		for (int i = 0; i < arr.length; i++) {
			System.out.print(arr[i] + " ");
		}
		System.out.println();
	}
}
