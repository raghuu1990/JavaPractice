package com.prem;

/**
 * Created by lovebharti on 19/7/16.
 */
public class DArray {
	private int[] nums = { 7, 2, 8, 1, 3, 10, 9 };

	public static void main(String[] args) {
		DArray da = new DArray();
		System.out.println("Element:" + da.rearrange(da.nums));
		da.display(da.nums);
	}

	public void display(int nums[]) {
		for (int i = 0; i < nums.length; i++) {
			System.out.print(nums[i] + ",");
		}
	}

	public int rearrange(int[] nums) {
		int pivot = 3;
		int i = 0;
		int j = nums.length - 1;
		
		while (i < j) {
			while (nums[i] < nums[pivot]) {
				i++;
			}
			while (nums[j] > nums[pivot]) {
				j--;
			}
			if (i < j)
				swap(nums, i, j);

		}

		swap(nums, j, pivot);
		return pivot;
	}

	public void swap(int[] nums, int i, int j) {
		int temp = nums[i];
		nums[i] = nums[j];
		nums[j] = temp;
	}
}
