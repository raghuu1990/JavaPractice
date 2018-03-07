package com.prem.sorting;

public class CountingSort {

	
	static int nums[]={2,30,1,15,13,7,8,1,15};
	
	
	public static void main(String[] args) {
		CountingSort.countingSort(nums);
	}
	
	public static int[] countingSort(int num[]){
		
		int max=num[0];
		for(int i=0;i<num.length;i++){
			if(max<num[i])
				max=num[i];
		}
		System.out.println(max);
		int count[]= new int[max+1];
		
		for(int j=0;j<num.length;j++){
			count[num[j]]+=1;
		}
		
		int prev=0;
		for(int k=0;k< count.length;k++){
			count[k]+=prev;
			prev=count[k];
		}
		
		for(int l=0;l<count.length;l++){
			
			
			System.out.println(count[l]);
		}
		
		return num;
	}
}
