package com.random;

// Random no bw (0, i-1) inclusive  (int)(Math.random()*(i))
// Random no bw (0, i) inclusive  (int)(Math.random()*(i+1))
// Random no bw (1, i) inclusive  (int)(Math.random()*i)+1

// Random no bw (1,10)
// System.out.print((int)(Math.random()*10) + 1 + " ");

public class ShuffleArray {

	public static void shuffle(int arr[]) {
		for (int i = arr.length - 1; i >= 0; i--) {
			double ran = Math.random();
			int random = (int) (ran * (i + 1));
			swap(arr, random, i);
		}
	}

	private static void swap(int arr[], int a, int b) {
		int temp = arr[a];
		arr[a] = arr[b];
		arr[b] = temp;
	}

	public static void main(String args[]) {
		int arr[] = { 1, 2, 3, 4, 5, 6, 7, 8 };
		shuffle(arr);
		System.out.println();
		for (int i = 0; i < arr.length; i++) {
			System.out.print(arr[i] + " ");
		}
		System.out.println();
		for (int i = 1; i < arr.length; i++) {
			System.out.print(i + " ");
			// Random no bw (0, i)
			System.out.print((int) (Math.random() * (i + 1)) + " ");
			// Random no bw (0, i)
			System.out.print((int) (Math.random() * (i) + 1) + " ");
			// Random no bw (1,10)
			System.out.print((int) (Math.random() * 10) + 1 + " ");
			System.out.println();
		}
	}
}