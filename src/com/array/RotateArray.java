package com.array;

import com.utils.ArrayUtils;

// O(n) time, O(n) space complexity, Support negative shifting too
public class RotateArray {
	public static void main(String[] args) {
		int[] inputArray = { 1, 2, 3, 4, 5, 6, 7 };
		int[] shiftedArray = rotateArrayInorder(inputArray, 20);
		ArrayUtils.print(shiftedArray);
	}

	public static int getShiftCount(int arraylength, int shiftCount)  {
		shiftCount = shiftCount % arraylength;
		if (shiftCount < 0) {
			shiftCount = arraylength - Math.abs(shiftCount);
		}
		return shiftCount;
	}

	// O(n) time, O(n) space complexity
	public static int[] rotateArray(int[] array, int shiftCount) {
		int arraylength = array.length;
		shiftCount = getShiftCount(arraylength, shiftCount);

		int[] shiftedArray = new int[arraylength];
		for (int oldIndex = 0; oldIndex < arraylength; oldIndex++) {
			int newIndex = (oldIndex + shiftCount) % arraylength;
			shiftedArray[newIndex] = array[oldIndex];
		}
		return shiftedArray;
	}

	// O(k*n) time, O(1) space complexity
	public static int[] rotateArrayInorder(int[] array, int shiftCount) {
		int arraylength = array.length;
		shiftCount = getShiftCount(arraylength, shiftCount);
		while(shiftCount>0) {
			shiftRight(array);
			shiftCount--;
		}
		return array;
	}
	
	public static int[] shiftRight(int[] array) {
		int length = array.length;
		int temp = array[length - 1];
		for (int i = length - 1; i > 0; i--) {
			array[i] = array[i - 1];
		}
		array[0] = temp;
		return array;
	}
}