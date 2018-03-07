package com.sort;

import java.util.Scanner;

// https://www.hackerrank.com/challenges/ctci-bubble-sort/problem

public class BubbleSort {
	public static void main(String[] args) {
		Scanner in = new Scanner(System.in);
		int n = in.nextInt();
		int arr[] = new int[n];
		for (int i = 0; i < n; i++) {
			arr[i] = in.nextInt();
		}
		bubbleSort(arr);
		in.close();
	}

	private static void bubbleSort(int[] arr) {
		int swaps = 0;
		for (int i = 0; i < arr.length; i++) {
		    for (int j = 0; j < arr.length - 1; j++) {
		        if (arr[j] > arr[j + 1]) {
		            swap(arr, j , j+ 1);
		            swaps++;
		        }
		    }
		    
		}
		System.out.println("Array is sorted in "+swaps+" swaps.");
		System.out.println("First Element: "+arr[0]);
		System.out.println("Last Element: "+arr[arr.length-1]);
	}

	private static void swap(int[] arr, int i, int j) {
		int temp = arr[i];
		arr[i] = arr[j];
		arr[j] = temp;
	}
}