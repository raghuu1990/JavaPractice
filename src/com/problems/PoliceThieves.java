package com.problems;

import java.util.ArrayList;

// http://www.geeksforgeeks.org/policemen-catch-thieves/
public class PoliceThieves {

	public static void main(String args[]) {
		int distance;

		char arr1[] = new char[] { 'P', 'T', 'T', 'P', 'T' };
		distance = 2;
		System.out.println("Maximum thieves caught: " + policeThief(arr1, distance));

		char arr2[] = new char[] { 'T', 'T', 'P', 'P', 'T', 'P' };
		distance = 2;
		System.out.println("Maximum thieves caught: " + policeThief(arr2, distance));

		char arr3[] = new char[] { 'P', 'T', 'P', 'T', 'T', 'P' };
		distance = 3;
		System.out.println("Maximum thieves caught: " + policeThief(arr3, distance));
	}

	public static int policeThief(char arr[], int distance) {
		ArrayList<Integer> thieves = new ArrayList<Integer>();
		ArrayList<Integer> police = new ArrayList<Integer>();

		int length = arr.length;
		for (int i = 0; i < length; i++) {
			if (arr[i] == 'P') {
				police.add(i);
			} else if (arr[i] == 'T') {
				thieves.add(i);
			}
		}

		int t = 0, p = 0, result = 0;
		while (t < thieves.size() && p < police.size()) {
			if (Math.abs(thieves.get(t) - police.get(p)) <= distance) {
				result++;
				t++;
				p++;
			}

			// increment the minimum index
			else if (thieves.get(t) < police.get(p)) {
				t++;
			} else {
				p++;
			}
		}
		return result;
	}
}