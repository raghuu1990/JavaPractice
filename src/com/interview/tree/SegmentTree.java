package com.interview.tree;

/**
 * Video link - https://youtu.be/ZBHKZF5w4YU
 *
 * A segment tree is a tree data structure for storing intervals, or segments.
 * It allows for faster querying (e.g sum or min) in these intervals. Write a
 * program to support these operations for sum createSegmentTree(int arr[]) -
 * create segment tree query(int segment[], int startRange, int endRange) -
 * query in this range
 * 
 * Similar segment trees can be created for min or max.
 * 
 * Time complexity to create segment tree is O(nlogn) Space complexity to create
 * segment tree is O(nlogn) Time complexity to search in segment tree is O(logn)
 * 
 * References
 * http://www.geeksforgeeks.org/segment-tree-set-1-sum-of-given-range/
 * http://www.geeksforgeeks.org/segment-tree-set-1-range-minimum-query/
 */

public class SegmentTree {
	public static void main(String args[]) {
		SegmentTree segTree = new SegmentTree();
		Operation sumOp = new SumOperation();
		Operation minOp = new MinOperation();

		int arr1[] = { 1, 3, 5, 7, 9, 11 };
		int segArr1[] = segTree.createTree(arr1, sumOp);
		for (int i = 0; i < segArr1.length; i++) {
			System.out.print(segArr1[i] + " ");
		}
		int arr2[] = { 3, 4, 2, 1, 6, -1 };
		int segArr2[] = segTree.createTree(arr2, minOp);
		for (int i = 0; i < segArr2.length; i++) {
			System.out.print(segArr2[i] + " ");
		}

		segTree.updateValueForSumOperation(arr1, segArr1, 0, 0);
		System.out.println();
		for (int i = 0; i < segArr1.length; i++) {
			System.out.print(segArr1[i] + " ");
		}
	}

	public int[] createTree(int arr[], Operation operation) {
		int height = (int) Math.ceil(Math.log(arr.length) / Math.log(2));
		int segArr[] = new int[(int) (Math.pow(2, height + 1) - 1)];
		constructTree(segArr, arr, 0, arr.length - 1, 0, operation);
		return segArr;
	}

	private void constructTree(int segArr[], int arr[], int low, int high, int pos, Operation operation) {
		if (low == high) {
			segArr[pos] = arr[low];
			return;
		}
		int mid = (low + high) / 2;
		constructTree(segArr, arr, low, mid, 2 * pos + 1, operation);
		constructTree(segArr, arr, mid + 1, high, 2 * pos + 2, operation);
		segArr[pos] = operation.perform(segArr[2 * pos + 1], segArr[2 * pos + 2]);
	}

	public int rangeQuery(int[] segArr, int qlow, int qhigh, int len, Operation operation) {
		return rangeQuery(segArr, 0, len - 1, qlow, qhigh, 0, operation);
	}

	private int rangeQuery(int segArr[], int low, int high, int qlow, int qhigh, int pos, Operation operation) {
		if (qlow <= low && qhigh >= high) {
			return segArr[pos];
		}
		if (qlow > high || qhigh < low) {
			return 0;
		}
		int mid = (low + high) / 2;
		return operation.perform(rangeQuery(segArr, low, mid, qlow, qhigh, 2 * pos + 1, operation),
				rangeQuery(segArr, mid + 1, high, qlow, qhigh, 2 * pos + 2, operation));
	}

	public void updateValueForSumOperation(int arr[], int segArr[], int newVal, int index) {
		int diff = newVal - arr[index];
		arr[index] = newVal;
		updateVal(segArr, 0, arr.length - 1, diff, index, 0);
	}

	private void updateVal(int segArr[], int low, int high, int diff, int index, int pos) {
		if (index < low || index > high) {
			return;
		}
		segArr[pos] += diff;
		if (low >= high) {
			return;
		}
		int mid = (low + high) / 2;
		updateVal(segArr, low, mid, diff, index, 2 * pos + 1);
		updateVal(segArr, mid + 1, high, diff, index, 2 * pos + 2);
	}
}

// Provides interface to perform operations on range queue like sum or min

interface Operation {
	int perform(int a, int b);
}

class SumOperation implements Operation {
	@Override
	public int perform(int a, int b) {
		return a + b;
	}
}

class MinOperation implements Operation {
	@Override
	public int perform(int a, int b) {
		return Math.min(a, b);
	}
}