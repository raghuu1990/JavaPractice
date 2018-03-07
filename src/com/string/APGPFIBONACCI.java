package com.string;

public class APGPFIBONACCI {
	public static void main(String[] args) {
		int arr1[] = {1,2,3,5,8,13};
		int arr2[] = {1,2,4,8,16,32};
		int arr3[] = {1,12,23,34,45,56};
		System.out.println("IS FIBONACCI : "+isFIBONACCI(arr1));
		System.out.println("IS GP : "+isGP(arr2));
		System.out.println("IS AP : "+isAP(arr3));
	}

	private static boolean isFIBONACCI(int[] arr) {
		for (int i = 2; i < arr.length; i++) {
			if(arr[i]!=arr[i-1]+arr[i-2]){
				return false;
			}
		}
		return true;
	}

	private static boolean isGP(int[] arr) {
		int r = arr[1]/arr[0];
		for (int i = 2; i < arr.length; i++) {
			if(arr[i]/arr[i-1]!=r){
				return false;
			}
		}
		return true;
	}

	private static boolean isAP(int[] arr) {
		int r = arr[1]-arr[0];
		for (int i = 2; i < arr.length; i++) {
			if(arr[i]-arr[i-1]!=r){
				return false;
			}
		}
		return true;
	}
}
