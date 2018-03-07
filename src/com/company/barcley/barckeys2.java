package com.company.barcley;
public class barckeys2 {

	public static void main(String[] args) {
		int arr[] = {-2,2,3,0,4,-7};
		int n = arr.length;
		subArraySum(arr, n);
	}
	static int subArraySum(int arr[], int n)
	{
		int value[] = new int[10];
		value[0]=arr[0];
		for (int i=1;i<n;i++){
			value[i]=value[i-1]+arr[i]; 
		}
		int total = value[n-1];
		
		int count =0;
		int sum=0;
		for (int i=0 ; i<n ; i++){
			sum=0;
			for (int j =i;j<n;j++){
				sum=sum+arr[j];
				if(sum == 0){
				count++;
			}
				System.out.println("temp "+i+"is=="+count);
			}
		}
		System.out.println(count);
		return count;
	
	}
}