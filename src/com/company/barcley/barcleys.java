package com.company.barcley;

public class barcleys {
	
	static int getAdjacent(int[] A){
		 int count = 0;
		 for(int i = 0; i < A.length-1; i++) {
		        if(A[i] == A[i+1]) {
		        	count ++;
		        }
		 }
		 return count++;
	}
	
	static int solution(int[] A, int N){
		int max = 0;
		for(int j = 0; j < N; j++) {
			 if(A[j]==0){
				A[j]=1;
			 }else{
				A[j]=0;
			 }
			 int count = getAdjacent(A);
			 if(count > max){
			    	max= count;
			 }
			 if(A[j]==0){
					A[j]=1;
				}else{
					A[j]=0;
			 }
		}
		return max;
	}
	
	public static void main(String [] args){
		int[] A ={1,1,1,0,1,1,0,0,0,1,1,1,0,1};
		int count = solution(A, A.length);
		System.out.println("Count: " + count);
	}
}