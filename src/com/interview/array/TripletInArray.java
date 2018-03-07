package com.interview.array;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

// http://www.geeksforgeeks.org/find-a-triplet-that-sum-to-a-given-value/
// https://leetcode.com/problems/3sum/

public class TripletInArray {

	public static void main(String args[]) {
		int arr1[] = { 1, 2, 9, 9, 11, 18, 26, 28 };
		int sum = 22;
		System.out.println(findTriplet(arr1, sum));
		// No duplicate
		int arr2[] = { 0, 2, 6, 9, -15, 18, -3, -3 , 3};
		System.out.println(threeSum(arr2));
	}

	public static Triplet findTriplet(int arr[], int sum) {
		Arrays.sort(arr);
		for (int i = 0; i < arr.length - 2; i++) {
			int start = i + 1;
			int end = arr.length - 1;
			int new_sum = sum - arr[i];
			while (start < end) {
				if (new_sum == arr[start] + arr[end]) {
					Triplet t = new Triplet();
					t.a = arr[i];
					t.b = arr[start];
					t.c = arr[end];
					return t;
				}
				if (new_sum > arr[start] + arr[end]) {
					start++;
				} else {
					end--;
				}
			}
		}
		return null;
	}

	public static List<List<Integer>> threeSum(int[] arr) {
		Arrays.sort(arr);
		List<List<Integer>> result = new ArrayList<>();
		for (int i = 0; i < arr.length - 2; i++) {
			if (i != 0 && arr[i] == arr[i - 1]) {
				continue;
			}
			int start = i + 1;
			int end = arr.length - 1;
			while (start < end) {
				if (arr[i] + arr[start] + arr[end] == 0) {
					List<Integer> r = new ArrayList<>();
					r.add(arr[i]);
					r.add(arr[start]);
					r.add(arr[end]);
					result.add(r);
					start++;
					end--;
					while (start < arr.length && arr[start] == arr[start - 1]) {
						start++;
					}
					while (end >= 0 && arr[end] == arr[end + 1]) {
						end--;
					}
				} else if (arr[i] + arr[start] + arr[end] < 0) {
					start++;
				} else {
					end--;
				}
			}
		}
		return result;
	}

	static class Triplet {
		int a;
		int b;
		int c;

		public String toString() {
			return a + " " + b + " " + c;
		}
	}
}