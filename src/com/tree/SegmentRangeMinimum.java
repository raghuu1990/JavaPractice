package com.tree;

//childs : l/r : 2n+1, 2n+2 || parent : (n-1)/2 where n is current index
/*                 
				   36 
                  /  \
			   	 /    \
		    	/      \
		       9        27
		      / \      /  \
		     4   5    16  11
		    / \      /  \
		   1   3    7    9

*/

public class SegmentRangeMinimum {
	public static int st[];

	public static void main(String args[]) {
		int arr[] = { 1, 3, 5, 7, 9, 11 };
		// [1, 1, 7, 1, 2, 7, 11, 1, 3, 0, 0, 7, 9, 0, 0]

		// int arr[] = { 2, 5, 1, 4, 9, 3 };
		// [1, 1, 3, 2, 1, 4, 3, 2, 5, 0, 0, 4, 9, 0, 0]

		int n = arr.length;
		constructST(arr, n);

		int qs = 0;
		int qe = 5;
		System.out.println("Minimum of values in range [" + qs + ", " + qe + "] is = " + rangeMinimumQuery(n, qs, qe));
		updateValue(arr, n, 0, 2);
		System.out.println("Minimum of values in range [" + qs + ", " + qe + "] is = " + rangeMinimumQuery(n, qs, qe));
	}

	public static void constructST(int arr[], int n) {
		int x = (int) (Math.ceil(Math.log(n) / Math.log(2)));
		int max_size = 2 * (int) Math.pow(2, x) - 1;
		st = new int[max_size];
		constructSTUtil(arr, 0, n - 1, 0);
	}

	public static int constructSTUtil(int arr[], int ss, int se, int si) {
		if (ss == se) {
			st[si] = arr[ss];
			return arr[ss];
		}

		int mid = getMid(ss, se);
		st[si] = minVal(constructSTUtil(arr, ss, mid, si * 2 + 1), constructSTUtil(arr, mid + 1, se, si * 2 + 2));
		return st[si];
	}

	public static int getMid(int s, int e) {
		return s + (e - s) / 2;
	}

	public static int minVal(int x, int y) {
		return (x < y) ? x : y;
	}

	public static int rangeMinimumQuery(int n, int qs, int qe) {
		if (qs < 0 || qe > n - 1 || qs > qe) {
			System.out.println("Invalid Input");
			return -1;
		}
		return rangeMinimumQueryUtil(0, n - 1, qs, qe, 0);
	}

	public static int rangeMinimumQueryUtil(int ss, int se, int qs, int qe, int index) {
		if (qs <= ss && qe >= se) {
			return st[index];
		}
		if (se < qs || ss > qe) {
			return Integer.MAX_VALUE;
		}
		int mid = getMid(ss, se);
		return minVal(rangeMinimumQueryUtil(ss, mid, qs, qe, 2 * index + 1),
				rangeMinimumQueryUtil(mid + 1, se, qs, qe, 2 * index + 2));
	}

	public static void updateValue(int arr[], int n, int i, int new_val) {
		if (i < 0 || i > n - 1) {
			System.out.println("Invalid Input");
			return;
		}
		int diff = new_val - arr[i];
		arr[i] = new_val;
		updateValueUtil(0, n - 1, i, diff, 0);
	}

	public static void updateValueUtil(int ss, int se, int i, int diff, int si) {
		if (i < ss || i > se) {
			return;
		}

		st[si] = st[si] + diff;
		if (se != ss) {
			int mid = getMid(ss, se);
			updateValueUtil(ss, mid, i, diff, 2 * si + 1);
			updateValueUtil(mid + 1, se, i, diff, 2 * si + 2);
		}
	}
}