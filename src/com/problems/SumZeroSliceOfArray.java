package com.problems;

public class SumZeroSliceOfArray {

	private static int MaxSlice(int[] A, int N) {
		int slices = 0;
		for(int i=0; i<N; i++){
			int sum = 0;			
			for (int j=i; j<N; j++){
				sum += A[j];
				if(sum==0){
					slices++;
					System.out.println("("+i+","+j+")");
				}
			}
		}
		return slices;
	}
	
	
	public static void main(String[] args) {
		//int arr[] = {2,-2,3,0,4,-7};         //4
		int arr[] = {2,-2,3,0,4,-7,2,-2};      //4
		//int arr[] = {2,-2,3,0,0,4,-7,2,-2};  //7
		int slice = MaxSlice(arr, arr.length);
		System.out.println("Max Slice : "+slice);
	}
}
