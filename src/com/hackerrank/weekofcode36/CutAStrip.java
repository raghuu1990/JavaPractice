package com.hackerrank.weekofcode36;

import java.util.Scanner;

public class CutAStrip {
	private static long result = Long.MIN_VALUE;
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        int n = in.nextInt();
        int m = in.nextInt();
        int k = in.nextInt();
        int[][] arr = new int[n][m];
        for(int i = 0; i < n; i++){
            for(int j = 0; j < m; j++){
                arr[i][j] = in.nextInt();
            }
        }
        findMaxSubMatrix1(arr, k);
        //System.out.println(result);
        in.close();
    }

    public static void findMaxSubMatrix1(int[][] a, int k) {
		int cols = a[0].length;
		int rows = a.length;
		long[] currentResult;
		long maxSum = Long.MIN_VALUE;
		int left = 0;
		int top = 0;
		int right = 0;
		int bottom = 0;

		for (int leftCol = 0; leftCol < cols; leftCol++) {
			long[] tmp = new long[rows];

			for (int rightCol = leftCol; rightCol < cols; rightCol++) {

				for (int i = 0; i < rows; i++) {
					tmp[i] += a[i][rightCol];
				}
				currentResult = kadane(tmp, k);
				if (currentResult[0] > maxSum) {
					maxSum = currentResult[0];
					left = leftCol;
					top = (int) currentResult[1];
					right = rightCol;
					bottom = (int) currentResult[2];
				}
			}
		}
		result =  Math.max(maxSum, result);

		long min = Long.MAX_VALUE;
		for (int i = top; i <= bottom; i++) {
			min= Math.min(min, minContiniousSumSubArrayHorizontal1(a, (int) i, left, right, k));
		}
		
		for (int j = left; j <= right; j++) {
			min= Math.min(min, minContiniousSumSubArrayVertical1(a, j, top, bottom, k));
		}
		System.out.println(result-min);
		// System.out.println("MaxSum: " + maxSum + ", range: [(" + left + ", " + top + ")(" + right + ", " + bottom + ")]");
	}

    public static long[] kadane(long[] a, int k) {
		// result[0] == maxSum, result[1] == start, result[2] == end;
		long[] result = new long[] { Long.MIN_VALUE, 0, -1 };
		long currentSum = 0;
		long localStart = 0;

		for (int i = 0; i < a.length; i++) {
			currentSum += a[i];
			if (currentSum < 0) {
				currentSum = 0;
				localStart = i + 1;
			} else if (currentSum > result[0]) {
				result[0] = currentSum;
				result[1] = localStart;
				result[2] = i;
			}
		}

		// all numbers in a are negative
		if (result[2] == -1) {
			result[0] = 0;
			for (int i = 0; i < a.length; i++) {
				if (a[i] > result[0]) {
					result[0] = a[i];
					result[1] = i;
					result[2] = i;
				}
			}
		}
		return result;
	}
    
    public static long minContiniousSumSubArrayHorizontal1(int[][] arr, int row, int rowStart, int rowEnd, int k) {
		long min_sum = Long.MAX_VALUE;
		long min_sum_here = 0;
		int start = rowStart, end = 0, tempStart = rowStart;

		for (int i = rowStart; i <= rowEnd; i++) {
			if(i-start>=k) {
				i = start;
				tempStart = ++start;
				min_sum_here = 0;
				continue;
			}
			min_sum_here += arr[row][i];
			if (min_sum > min_sum_here) {
				min_sum = min_sum_here;
				start = tempStart;
				end = i;
			}

			if (min_sum_here > 0) {
				min_sum_here = 0;
				tempStart = i + 1;
			}
		}
		/*//int[][] newArr  = new int[arr.length][arr[0].length];
		//Arrays.fill(newArr, arr);
		int[][] newArr = arr.clone();
		for (int i = start; i < end; i++) {
			newArr[row][i] = 0;
		}
		findMaxSubMatrix(newArr, k);*/
		// System.out.println("Starting index : " + start + " , Ending index : " + end);
		return min_sum;
	}

    public static long minContiniousSumSubArrayVertical1(int[][] arr, int col, int colStart, int colEnd, int k) {
		long min_sum = Long.MAX_VALUE;
		long min_sum_here = 0;
		int start = colStart, end = colStart, tempStart = 0;

		for (int i = colStart; i <= colEnd; i++) {
			if(i-start>=k) {
				i = start;
				tempStart = ++start;
				min_sum_here = 0;
				continue;
			}
			min_sum_here += arr[i][col];
			if (min_sum > min_sum_here) {
				min_sum = min_sum_here;
				start = tempStart;
				end = i;
			}

			if (min_sum_here > 0) {
				min_sum_here = 0;
				tempStart = i + 1;
			}
		}
		/*//int[][] newArr  = new int[arr.length][arr[0].length];
		//Arrays.fill(newArr, arr);
		int[][] newArr = arr.clone();
		for (int i = start; i < end; i++) {
			newArr[i][col] = 0;
		}
		findMaxSubMatrix(newArr, k);*/
		// System.out.println("Starting index : " + start + " , Ending index : " + end);
		return min_sum;
	}
    
    static void solve(int[][] arr, int K) {
    	int row = arr.length;
    	int col = arr[0].length;
    	long[][] sum = new long[row][col];
    	boolean[][] minimim = new boolean[row][col];
    	boolean[][] negative = new boolean[row][col];
    	
    	int min = Integer.MAX_VALUE;
    	for (int i = 0; i < col; i++) {
    		sum[0][i] =  sum[0][i-1] + arr[0][i];
    		if(arr[0][i]<0) {
    			negative[0][i] = true;
    		}
		}
    	for (int i = 0; i < row; i++) {
    		sum[i][0] =  sum[i-1][0] + arr[i][0];
    		if(arr[i][0]<0) {
    			negative[i][0] = true;
    		}
		}
    	for (int i = 0; i < row; i++) {
			for (int j = 0; j < col; j++) {
				sum[i][j] =  sum[i][j-1] + sum[i-1][j] - sum[i-1][j-1]  + arr[i][j];
				if(arr[i][j]<0) {
	    			negative[i][j] = true;
	    		}
			}
		}

    	long max = Long.MIN_VALUE;
    	for (int i = 0; i < row; i++) {
			for (int j = 0; j < col; j++) {
				for (int k = 1; k <= K; k++) {
					for (int l = 0; l < row; l++) {
						for (int m = 0; m < col; m++) {
							
						}
					}
				}
				
				for (int k = 1; k <= K; k++) {
					
				}
			}
		}
    	
    	
    }
    
    
    static void cutAStrip1(int[][] arr, int K) {
    	int count1 = 0;
    	int count2 = 0;
    	for (int k = 0; k < K; k++) {
    		for (int row = 0; row < arr.length; row++) {  // row
				for (int col = 0; col+k < arr[0].length; col++) {
					int[][] newArr = arraycopy(arr);
					for (int index = col; index <= col+k ; index++) {
						newArr[row][index] = 0;
					}
					findMaxSubMatrix(newArr, k);
					count1++;
				}
			}
    		
    	}
    	for (int k = 1; k < K; k++) {
    		for (int col = 0; col < arr[0].length; col++) {  // col
				for (int row = 0; row+k < arr.length; row++) {
					int[][] newArr = arraycopy(arr);
					for (int index = row; index <= row+k ; index++) {
						newArr[index][col] = 0;
					}
					findMaxSubMatrix(newArr, k);
					count2++;
				}
			}
		}
    	//System.out.println(count1);
    	//System.out.println(count2);
    }

    private static int[][] arraycopy(int[][] arr) {
		int [][] arr1 = new int [arr.length][arr[0].length];
		for (int i = 0; i < arr.length; i++) {
			for (int j = 0; j < arr[0].length; j++) {
				arr1[i][j] = arr[i][j];
			}
		}
		return arr1;
	}

	/*static void cutAStrip(int[][] arr, int k) {
    	for (int i = 0; i < arr.length; i++) {
    		minContiniousSumSubArrayHorizontal1(arr, i, k);
		}

    	for (int i = 0; i < arr[0].length; i++) {
    		minContiniousSumSubArrayVertical1(arr, i, k);
		}
    }*/

    
    
	public static void findMaxSubMatrix(int[][] a, int k) {
		int cols = a[0].length;
		int rows = a.length;
		long[] currentResult;
		long maxSum = Long.MIN_VALUE;
		long left = 0;
		long top = 0;
		long right = 0;
		long bottom = 0;

		for (int leftCol = 0; leftCol < cols; leftCol++) {
			long[] tmp = new long[rows];

			for (int rightCol = leftCol; rightCol < cols; rightCol++) {

				for (int i = 0; i < rows; i++) {
					tmp[i] += a[i][rightCol];
				}
				currentResult = kadane(tmp, k);
				if (currentResult[0] > maxSum) {
					maxSum = currentResult[0];
					left = leftCol;
					top = currentResult[1];
					right = rightCol;
					bottom = currentResult[2];
				}
			}
		}
		result =  Math.max(maxSum, result);
		// System.out.println("MaxSum: " + maxSum + ", range: [(" + left + ", " + top + ")(" + right + ", " + bottom + ")]");
	}
	
	
}