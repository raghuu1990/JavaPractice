package com;

import java.util.Scanner;

public class Test {
	public static void main(String[] args) {
		Scanner in = new Scanner(System.in);
		int n = in.nextInt();
		int[] input = new int[n];

		for (int i = 0; i < n; i++) {
			input[i] = in.nextInt();
		}

		for (int i = input.length - 1; i >= 0; i++) {
			System.out.println(input[i]);
		}
		in.close();
	}

	
	static void cutTheSticks(int[] arr) {
		int min = Integer.MAX_VALUE;
		for (int i = 0; i < arr.length; i++) {
			min = Math.min(min, arr[i]);
		}
		
		while(true) {
			boolean flag = true;
			int count = 0;
			int tempMin = Integer.MAX_VALUE;
			for (int i = 0; i < arr.length; i++) {
				if(arr[i]>=min) {
					flag = false;
					arr[i] -= min;
					count++;
				}
				tempMin = Math.min(min, arr[i]);
			}
			min = tempMin;
			if(flag) {
				break;
			}
			System.out.println(count);
		}
    }
	
	
	public static int getlastIndex(String str) {
		int l = str.length();
		for (int i = l - 1; i >= 0; i--) {
			if (str.charAt(i) == '1') {
				return i;
			}
		}
		return -1;
	}
}
