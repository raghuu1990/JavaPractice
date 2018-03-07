package com.maths;

public class PascalsTriangle {

	public static void rotate(int[] nums, int k) {
		int[] temp = new int[k];
		int l = nums.length;
		k=k%l;

		for (int i = l - k, j = 0; i < l; i++, j++) {
			temp[j] = nums[i];
		}

		for (int i = l - 1; i > k - 1; i--) {
			nums[i] = nums[i - k];
		}

		for (int i = 0; i < k; i++) {
			nums[i] = temp[i];
		}

		System.out.print(nums[0]);

		if (l > 1) {
			for (int i = 1; i < l; i++) {
				System.out.print(",");
				System.out.print(nums[i]);
			}
		}
	}

	public static void main(String[] args) {
		int[] nums = { 1, 2, 3, 4, 5, 6, 7 };
		rotate(nums, 20);
	}
}
