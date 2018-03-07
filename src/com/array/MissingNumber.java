package com.array;

import java.util.Scanner;

public class MissingNumber {
	public static void main(String[] args) {
		Scanner in = new Scanner(System.in);
		int t = in.nextInt();
		int [] result = new int[t];
		for (int i = 0; i < t; i++) {
			int n = in.nextInt();
			int [] c = new int[n-1];
			for (int j = 0; j < n-1; j++) {
				c[j] = in.nextInt();
			}
			result[i] = getMissing(c);
		}
		for (int i = 0; i < result.length; i++) {
			System.out.println(result[i]+" ");
		}
		in.close();
	}

	@SuppressWarnings("unused")
	private static int getMissing1(int[] c) {
		int sum = (c.length+1)*(c.length+2)/2;
		for (int i = 0; i < c.length; i++) {
			sum-=c[i];
		}
		return sum;
	}

	// log(n), if in sorted order
	private static int getMissing(int[] c) {
		int l = 0;
		int r = c.length-1;
		
		while(l<=r) {
			int mid = (l+r)/2;
			if(c[mid] == mid+1) {
				l = mid+1;
			}else if(c[mid] == mid+2) {
				 if(mid==0 && c[mid]==2 || c[mid-1] == mid) {
					return mid+1;
				}
				r = mid-1;
			}else{
			    return -1;
			}
		}
		return c.length+1;
	}
}