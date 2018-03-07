package com.matrix;

import java.util.Scanner;

// https://www.hackerrank.com/contests/w36/challenges/cut-a-strip/submissions/code/1305748962

public class MaxSumSubMatrix2 {
	private static long result = Long.MIN_VALUE;

	public static void main(String[] args) {
		Scanner in = new Scanner(System.in);
		int n = in.nextInt();
		int m = in.nextInt();
		int k = in.nextInt();
		int[][] arr = new int[n][m];
		for (int i = 0; i < n; i++) {
			for (int j = 0; j < m; j++) {
				arr[i][j] = in.nextInt();
			}
		}
		findMaxSubMatrix2(arr, k);
		System.out.println(result);
		in.close();
	}

	public static void findMaxSubMatrix2(int[][] a, int k) {
		int cols = a[0].length;
		int rows = a.length;
		long[] currentResult;
		long maxSum = Long.MIN_VALUE;
		int left = 0;
		int top = 0;
		int right = 0;
		int bottom = 0;

		for (int leftCol = 0; leftCol < cols; leftCol++) {
			int[] tmp = new int[rows];
			for (int rightCol = leftCol; rightCol < cols; rightCol++) {
				for (int i = 0; i < rows; i++) {
					tmp[i] += a[i][rightCol];
				}
				currentResult = maxContiniousSumSubArrayWithIndex(tmp);
				if (currentResult[0] >= maxSum) {
					maxSum = currentResult[0];
					left = leftCol;
					top = (int) currentResult[1];
					right = rightCol;
					bottom = (int) currentResult[2];
				}
			}
		}
		long min = Long.MAX_VALUE;
		for (int i = top; i <= bottom; i++) {
			min = Math.min(min, minContiniousSumSubArrayHorizontal(a, i, left, right, k)[0]);
		}

		for (int j = left; j <= right; j++) {
			min = Math.min(min, minContiniousSumSubArrayVertical(a, j, top, bottom, k)[0]);
		}
        result = maxSum-min;
        
        
        maxSum = Long.MIN_VALUE;
        for (int leftRow = 0; leftRow < rows; leftRow++) {
			int[] tmp = new int[cols];
			for (int rightRow = leftRow; rightRow < rows; rightRow++) {
				for (int i = 0; i < cols; i++) {
					tmp[i] += a[rightRow][i];
				}
				currentResult = maxContiniousSumSubArrayWithIndex(tmp);
				if (currentResult[0] >= maxSum) {
					maxSum = currentResult[0];
					top = leftRow;
					left = (int) currentResult[1];
					bottom = rightRow;
					right = (int) currentResult[2];
				}
			}
		}
		min = Long.MAX_VALUE;
		for (int i = top; i <= bottom; i++) {
			min = Math.min(min, minContiniousSumSubArrayHorizontal(a, i, left, right, k)[0]);
		}

		for (int j = left; j <= right; j++) {
			min = Math.min(min, minContiniousSumSubArrayVertical(a, j, top, bottom, k)[0]);
		}
		result =Math.max(result, maxSum-min);
	}
	
	public static void printMatrix (int columnStart, int rowStart, int columnSize, int rowSize, int[][] matrix, int K) {
	    if (columnStart+columnSize>matrix[0].length) return;
	    if (rowStart+rowSize>matrix.length) return;
	    long sum = 0;
	    for (int i=rowStart;i<rowStart+rowSize;i++) {
	      for (int j=columnStart;j<columnStart+columnSize;j++) {
	    	  sum+=matrix[i][j];
	      }
	    }
	    
	    long min = Long.MAX_VALUE;
		for (int i = rowStart; i < rowStart+rowSize; i++) {
			min = Math.min(min, minContiniousSumSubArrayHorizontal(matrix, i, columnStart, columnStart+columnSize-1, K)[0]);
		}

		for (int j = columnStart; j < columnStart+columnSize; j++) {
			min = Math.min(min, minContiniousSumSubArrayVertical(matrix, j, rowStart, rowStart+rowSize-1, K)[0]);
		}
		result =  Math.max(sum-min, result);
	  }

	  public static void printAllSubMatrices (int[][] matrix, int k) {
	    for (int i=0;i<matrix.length;i++) {
	      for (int m=1;m<matrix.length-i+1;m++) {
	        for (int j=0;j<matrix[0].length;j++) {
	          for (int n=1;n<matrix[0].length-j+1;n++) {
	            printMatrix(j, i, n, m, matrix, k);
	          }
	        }
	      }
	    }
	  }
	  
	public static void findMaxSubMatrix1(int[][] arr, int K) {
		int cols = arr[0].length;
		int rows = arr.length;
		
		for (int rowStart = 0; rowStart < rows; rowStart++) {
			long sum1 = 0;
			for (int rowEnd = rowStart; rowEnd < rows; rowEnd++) {
				long sum2 = 0;
				for (int colStart = 0; colStart < cols; colStart++) {
					long sum3 = 0;
					for (int colEnd = colStart; colEnd < cols; colEnd++) {
						sum3 += arr[rowEnd][colEnd];
						System.out.print(sum3+" ");
						long min = Long.MAX_VALUE;
						for (int i = rowStart; i <= rowEnd; i++) {
							min = Math.min(min, minContiniousSumSubArrayHorizontal(arr, i, colStart, colEnd, K)[0]);
						}

						for (int j = colStart; j <= colEnd; j++) {
							min = Math.min(min, minContiniousSumSubArrayVertical(arr, j, rowStart, rowEnd, K)[0]);
						}
						result =  Math.max(sum3-min, result);
					}
					sum2+=sum3;
					// System.out.println();
					// System.out.println(sum2);
				}
				sum1+=sum2;
				System.out.println();
				// System.out.println(sum1);
			}
		}
	}

	
	
	public static void findMaxSubMatrix(int[][] arr, int k) {
		int cols = arr[0].length;
		int rows = arr.length;

		for (int leftCol = 0; leftCol < cols; leftCol++) {
			int[] constantArr = new int[rows];
			int[] variableArr1 = new int[rows];
			int[] variableArr2 = new int[rows];
			for (int rightCol = leftCol; rightCol < cols; rightCol++) {
				long[] rArray = minContiniousSumSubArrayVertical(arr, rightCol, 0, rows - 1, k);
				

				for (int i = 0; i < rows; i++) {
					variableArr2[i] = variableArr1[i]+ arr[i][rightCol];
					if (i < rArray[1] || i > rArray[2]) {
						variableArr1[i] = constantArr[i] + arr[i][rightCol];
					}else {
						variableArr1[i] = constantArr[i];
					}
					constantArr[i] += arr[i][rightCol];
					
				}

				long[] currentResult = maxContiniousSumSubArrayWithIndex(variableArr1);
				result = Math.max(result, currentResult[0]);
				
				if(rightCol != leftCol) {
					currentResult = maxContiniousSumSubArrayWithIndex(variableArr2);
					result = Math.max(result, currentResult[0]);
				}
			}
		}
	}

	public static long[] maxContiniousSumSubArrayWithIndex(int[] arr) {
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
		return new long[] { max_sum, start, end };
	}

	public static long[] minContiniousSumSubArrayHorizontal(int[][] arr, int row, int rowStart, int rowEnd, int k) {
		long min_sum = Long.MAX_VALUE;
		long min_sum_here = 0;
		int start = rowStart, end = 0, tempStart = rowStart;
		long[] result = new long[] { min_sum, start, end };

		for (int i = rowStart; i <= rowEnd; i++) {
			if (i - start >= k) {
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
				result[1] = start;
			}

			if (min_sum_here > 0) {
				min_sum_here = 0;
				tempStart = i + 1;
			}
		}
		result[0] = min_sum;
		result[2] = end;
		return result;
	}

	public static long[] minContiniousSumSubArrayVertical(int[][] arr, int col, int colStart, int colEnd, int k) {
		long min_sum = Long.MAX_VALUE;
		long min_sum_here = 0;
		int start = colStart, end = colStart, tempStart = 0;
		long[] result = new long[] { min_sum, start, end };
		
		for (int i = colStart; i <= colEnd; i++) {
			if (i - start >= k) {
				i = start;
				tempStart =++start;
				min_sum_here = 0;
				continue;
			}
			min_sum_here += arr[i][col];
			if (min_sum > min_sum_here) {
				min_sum = min_sum_here;
				start = tempStart;
				end = i;
				result[1] = start;
			}

			if (min_sum_here > 0) {
				min_sum_here = 0;
				tempStart = i + 1;
			}
		}
		result[0] = min_sum;
		result[2] = end;
		return result;
	}
}