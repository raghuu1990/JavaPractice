package com.array;

import java.util.ArrayList;
import java.util.List;
import java.util.TreeMap;

// Longest sum continuous subArray
public class Kadanes {
	public static void main(String[] args) {
		// int[] arr = {-3, 7, -2, 3, 5, -2};
		// int[] arr = { -2, -3, 4, -1, -2, 1, 5, -3 };
		// int[] arr = {-2, -3, -4, -1, -2, -1, -5, -3};
		 int[] arr = {-5,-2,-10};

		System.out.println(maxContiniousSumSubArray(arr));
		System.out.println(maxContiniousSumSubArrayWithIndex(arr));

		ArrayList<Integer> arrr = new ArrayList<Integer>();
		/* 
		arrr.add(1);
		arrr.add(2);
		arrr.add(5);
		arrr.add(-7);
		arrr.add(2);
		arrr.add(5);
		
		*/
		/*
		arrr.add(-1); 
		arrr.add(-1);
		arrr.add(-1);
		arrr.add(-1);
		arrr.add(-1);
		arrr.add(-1);
		 */

		/*
		arrr.add(0);
		arrr.add(0);
		arrr.add(-1);
		arrr.add(0);
		*/
		
		/*
		arrr.add(-846930886);
		arrr.add(-1714636915);
		arrr.add(424238335);
		arrr.add(-1649760492);
		*/
		  
		arrr.add(1967513926);
		arrr.add(1540383426);
		arrr.add(-1303455736);
		arrr.add(-521595368);

		System.out.println(maxNonNegativeContiniousSubSet(arrr).toString());
	}

	public static int maxContiniousSumSubArray(int[] arr) {
		int max_sum_here = arr[0];
		int max_sum = arr[0];
		for (int i = 1; i < arr.length; i++) {
			max_sum_here += arr[i];
			max_sum_here = Math.max(max_sum_here, arr[i]);
			max_sum = Math.max(max_sum_here, max_sum);
		}
		return max_sum;
	}

	public static int maxContiniousSumSubArrayWithIndex(int[] arr) {
		int max_sum = Integer.MIN_VALUE;
		int max_sum_here = 0;
		int start = 0, end = 0, tempStart = 0;

		for (int i = 0; i < arr.length; i++) {
			max_sum_here += arr[i];
			if (max_sum < max_sum_here) {
				max_sum = max_sum_here;
				start = tempStart;
				end = i;
			}

			if (max_sum_here < 0) {
				max_sum_here = 0;
				tempStart = i + 1;
			}
		}
		System.out.println("Starting index : " + start + " , Ending index : " + end);
		return max_sum;
	}
	
	/*

	A : [1, 2, 5, -7, 2, 3]
	The two sub-arrays are [1, 2, 5] [2, 3].
	The answer is [1, 2, 5] as its sum is larger than [2, 3]

	NOTE: If there is a tie, then compare with segment's length and return segment which has maximum length
	NOTE 2: If there is still a tie, then return the segment with minimum starting index
	
	*/

	public static ArrayList<Integer> maxNonNegativeContiniousSubSet(ArrayList<Integer> A) {
		long max_sum = 0;
		long max_sum_here = 0;
		int start = 0, end = 0, tempStart = 0;

		boolean isChanged = false;

		TreeMap<Long, List<Pair>> map = new TreeMap<Long, List<Pair>>();
		for (int i = 0; i < A.size(); i++) {
			max_sum_here += A.get(i);
			if (max_sum <= max_sum_here) {
				max_sum = max_sum_here;
				start = tempStart;
				end = i;
				
				if (!map.containsKey(max_sum)) {
					List<Pair> list = new ArrayList<Pair>();
					list.add(new Pair(start, end));
					map.put(max_sum, list);
				} else {
					map.get(max_sum).add(new Pair(start, end));
				}
				
				isChanged = true;
			}

			if (max_sum_here < 0 || A.get(i)<0) {
				max_sum_here = 0;
				tempStart = i + 1;
			}
		}

		ArrayList<Integer> arrr = new ArrayList<Integer>();
		if (isChanged) {
			long sum = map.lastKey();
			List<Pair> list = map.get(sum);
			Pair pair = list.get(0);
			int maxSize = pair.end - pair.start + 1;
			for (int i = 1; i < list.size(); i++) {
				Pair temp = list.get(i);
				int tempSize = (temp.end - temp.start + 1);
				if (maxSize < tempSize) {
					pair = temp;
					maxSize = tempSize;
				} else if (maxSize == tempSize) {
					if (temp.start < pair.start) {
						pair = temp;
					}
				}
			}

			for (int i = pair.start; i <= pair.end; i++) {
				arrr.add(A.get(i));
			}
		}
		
		return arrr;
	}
}

class Pair {
	int start;
	int end;

	public Pair(int start, int end) {
		this.start = start;
		this.end = end;
	}
}