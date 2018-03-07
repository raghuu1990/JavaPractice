package com.company.mmt;

public class FindNumber {

	public static void main(String[] args) {
		int num = 28;
		int[][] arr = {	{ 1, 6,12,17,25,32},
						{ 2, 7,14,18,26,33},
						{ 5, 8,15,27,28,34},
						{ 8, 9,17,28,29,35},
						{13,17,22,29,30,37},
						{20,25,40,42,47,50}	
					};
		findNumber(arr, 6, 6, num);
	}

	private static void findNumber(int[][] arr, int a, int b, int n) {
		int i =a-1;
		int j= 0;
		
		while(i>-1 && j<6){
			if(arr[i][j]==n){
				System.out.println("i="+i+", j="+j);
				break;
			}else if(arr[i][j]>n){
				i--;
			}else if(arr[i][j]<n){
				j++;
			}else{}
		}
		
		if((i<0 || j>=b)){
			System.out.println("Not Found");
		}
	}
}
