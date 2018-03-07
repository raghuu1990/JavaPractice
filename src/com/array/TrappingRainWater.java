package com.array;

import java.util.Scanner;

// http://practice.geeksforgeeks.org/problems/trapping-rain-water/0

/*
1
12
0 1 0 2 1 0 1 3 2 1 2 1
			  
       	     |#|   
     |#|* * *|#|#|*|#|
_|#|*|#|#|*|#|#|#|#|#|#|

Output : 6

*/

public class TrappingRainWater {
	public static void main(String[] args) {
		Scanner in = new Scanner(System.in);
		int t = in.nextInt();
		int [] result = new int[t];
		for (int i = 0; i < t; i++) {
			int n = in.nextInt();
			int [] arr = new int[n];
			for (int j = 0; j < n; j++) {
				arr[j] = in.nextInt();
			}
			result[i]= getMaxWater(arr); 
		}
		for (int i = 0; i < result.length; i++) {
			System.out.println(result[i]);
		}
		in.close();
	}

	private static int getMaxWater(int[] arr) {
		int l = arr.length;
		int water = 0;
		int maxLeft = Integer.MIN_VALUE;
		int maxRight = Integer.MIN_VALUE;
		int left = 0;
		int right = l-1;
		while(left<=right) {
			if(arr[left]<=arr[right]) {
				if(maxLeft<arr[left]) {
					maxLeft=arr[left];
				}
				water += maxLeft-arr[left];
				left++;
			}else {
				if(maxRight<arr[right]) {
					maxRight=arr[right];
				}
				water += maxRight-arr[right];
				right--;
			}
		}
		return water;
	}

	@SuppressWarnings("unused")  // Extra space
	private static int getMaxWater1(int[] arr) {
		int l = arr.length;
		int maxLeft = arr[0];
		int maxRight = arr[l - 1];
		
		int[] left = new int[l];
		int[] right = new int[l];
		
		left[0] = maxLeft;
		right[l-1] = maxRight;
		
		for (int i = 1; i < l; i++) {
			if (maxLeft < arr[i]) {
				maxLeft = arr[i];
			}
			left[i] = maxLeft;
		}

		for (int i = l - 1; i >= 0; i--) {
			if (maxRight < arr[i]) {
				maxRight = arr[i];
			}
			right[i] = maxRight;
		}
		
		int water = 0;
		for (int i = 0; i < l; i++) {
			water += Math.min(left[i], right[i])-arr[i];
		}
		return water;
	}
}