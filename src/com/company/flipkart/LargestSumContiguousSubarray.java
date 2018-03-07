package com.company.flipkart;

public class LargestSumContiguousSubarray {
	public static void main(String[] args) {
		int a[] = {-2, -3, -4, -2, -2, -1, -5, -3};
		//int a[] =  {-2, 3, -1, 5, -2, -1, 0, -3};
		System.out.println("Maximum contiguous sum is " + maxSubArraySum1(a));
	}

	static int maxSubArraySum(int a[]) {
		int size = a.length;
		int maxSum =  a[0] , curr_max =  a[0];

		for (int i = 1; i < size; i++) {
			curr_max = Math.max(a[i], curr_max+a[i]);
			maxSum = Math.max(maxSum, curr_max);
		}
		return maxSum;
	}
	
	static int maxSubArraySum1(int a[]) {
		int size = a.length;
		int maxSum = Integer.MIN_VALUE , curr_max = 0, start = 0, end = 0, s = 0;
		 
		for (int i = 0; i < size; i++) {
			curr_max += a[i];
			if (maxSum < curr_max) {
				maxSum = curr_max;
				start = s;
				end = i;
			}

			if (curr_max < 0) {
				curr_max = 0;
				s = i + 1;
			}
		}
	    System.out.println("Start :" +start+ " , End :" + end);
		return maxSum;
	}
}
