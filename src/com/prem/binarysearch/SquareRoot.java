package com.prem.binarysearch;

public class SquareRoot {

	/**
	 * get mid from low and high if mid*mid > square then high=mid-1 else
	 * low=mid+1
	 *
	 * O(logn)
	 *
	 */
	public int squareRoot(int low, int high, int num) {
		int mid = (low + high) / 2;
		if (mid * mid == num) {
			return mid;
		} else if (mid * mid > num) {
			high = mid - 1;
		} else {
			low = mid + 1;
		}
		return squareRoot(low, high, num);
	}

	public int squareRootIt(int num) {
		int low = 0;
		int high = num;
		int mid = 0;
		while (low <= high) {
			mid = (low + high) / 2;
			if (mid * mid == num) {
				break;
			} else if (mid * mid > num) {
				high = mid - 1;
			} else {
				low = mid + 1;
			}
		}
		return mid;
	}

	static int count = 0;

	public static void main(String[] args) {
		int num = 64;
		SquareRoot sq = new SquareRoot();
		// System.out.println(sq.squareRoot(0,num,num));
		System.out.println(sq.squareRootIt(num));
	}
}
