package com.test;

// Hacker rank test of SaleForce
public class SaleForceTest {
	public static void main(String args[]) throws Exception {
	}

	public static int rectangularSum(int[][] matrix, String coord1, String coord2) {
        int x1 = Integer.parseInt(coord1.split(",")[0]);
		int y1 = Integer.parseInt(coord1.split(",")[1]);
		int x2 = Integer.parseInt(coord2.split(",")[0]);
		int y2 = Integer.parseInt(coord2.split(",")[1]);
		int sum = 0;
		for (int i = x1; i < matrix.length && i<=x2; i++) {
			for (int j = y1; j < matrix[0].length && j<=y2; j++) {
				sum+=matrix[i][j];
			}
		}
		return sum;
    }
	
	public static void isMajority(int x, int[] arr) {
        int index = binarySearch(x, arr);
        int count = 0;
        if(count ==-1){
            System.out.println("False");
            return;
        }
        for(int i = index; i< arr.length; i++){
            if(arr[i]==arr[index]){
                count++;
            }
        }
        if(count>(arr.length/2)){
            System.out.println("True");
        }else{
            System.out.println("False");
        }
    }

	public static int binarySearch(int x, int[] arr){
        int low = 0;
        int high = arr.length-1;
        while(low<high && low<arr.length){
            if(arr[low]<x){
                low = (low+high)/2;
            }else if(arr[low]==x){
                break;
            }
        }
        if(arr[low]==x){
            while(low>=0 && arr[low]==x){
                low--;
            }
            return low+1;
        }
        return -1;
    }
}
