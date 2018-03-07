package com.problems;

//Find the max difference of any pair of numbers such that 
//the largest element in the pair occur a higher index in array then the smaller integer 

public class MaxPairDiffrence {

	public static int MaxDiffrence(int[] arr){
		int maxDiff = 0;
		int indexOfmax = getIndexOfMax(arr);
		for(int i=0; i< indexOfmax; i++){
			int diff = arr[indexOfmax] - arr[i];
			if(diff>maxDiff){
				maxDiff = diff;
			}
		}
		return maxDiff;
	}
	
	public static int getIndexOfMax(int[] arr){
		int index = 0;
		int max = arr[0]; 
		for(int i=0; i< arr.length; i++){
			if(arr[i]>max){
				max = arr[i];
				index = i;
			}
		}
		return index;
	}
	
	public static void main(String[] args) {
		int arr[] = {2,3,10,2,4,8,1}; 
		//int arr[] = {7,9,5,6,3,2};
		int maxDiff = MaxDiffrence(arr);
		System.out.println("Max Diffrence : "+maxDiff);
	}
}
