package com.prem;
public class Sorting {

	public static int nums[]={32,1,5,22,26,30,7,0,11};
	
	
	public static void main(String[] args) {

		// Arrays.sort(nums);
		// bubbleSort(num);
		Sorting.quickSort(nums,0,nums.length-1);
		display(nums);
	}
	
	
/*
	public static void quickSort(int[] nums, int low, int high){
		int pivot= low;
		while(low<high && high>0 && low<nums.length-1){
			if(nums[low]<nums[pivot]){
				low++;
			}
			if(nums[high]>nums[pivot]){
				high--;
			}

			int temp=nums[low];
			nums[low]=nums[high];
			nums[high]=temp;
		}
		int temp=nums[pivot];
		nums[pivot]=nums[high];
		nums[high]=temp;
		quickSort(nums,0,pivot-1);
		quickSort(nums,pivot+1,high);
	}
*/
	public static void bubbleSort(int num[]){
		for(int j=num.length-1;j>0;j--)
		for(int i=0;i<j;i++){
			if(num[i]>num[i+1])
				swap(num,i,i+1);
		}
	}

	public static void quickSort(int num[],int low, int high){
		int pivot = partition(num, low, high);
		if(low<pivot-1)
		quickSort(num, low, pivot-1);
		if(pivot<high)
		quickSort(num, pivot + 1, high);

	}

	//move left to forward and right to backward
	//until left data is at right place means all elements should be less that data on left side
	//and all data to left side should be on the right side.
	//so now left is on correct position and left is on it pivot position return left
	//it should be done until left<right
	public static int partition(int num[],int low, int high){
		int pivot=num[(low+high)/2];
		int left=low;
		int right=high;
		while(left<=right){
			while(num[left]<pivot){
				left++;
			}
			while(num[right]>pivot){
				right--;
			}
			if(left<=right){
				swap(num,left++,right++);
			}
		}
		return left;
	}


	public static void swap(int num[],int i,int j){
		int temp=num[i];
		num[i]=num[j];
		num[j]=temp;
	}
	
	public static void display(int num[]){
		for(int i=0;i<num.length;i++){
			System.out.print(num[i]+",");
		}
	}
}
