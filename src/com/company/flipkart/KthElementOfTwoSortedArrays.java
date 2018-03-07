package com.company.flipkart;

import java.util.Scanner;

public class KthElementOfTwoSortedArrays {
	public static void main(String args[]) {
		Scanner in = new Scanner(System.in);
		int T = in.nextInt();
		for (int i = 0; i < T; i++) {
			int N = in.nextInt();
			int M = in.nextInt();
			int K = in.nextInt();
			int A[] = new int [N];
			int B[] = new int [M];
			for (int j = 0; j < N; j++) {
				A[j] = in.nextInt();
			}
			for (int j = 0; j < M; j++) {
				B[j] = in.nextInt();
			}
			System.out.println(calculate(A, B, K));
		}
		in.close();
	}

	private static int calculate(int[] A, int[] B, int k) {
		int result = 0;
		int a = 0;
		int b = 0;
		if(k> A.length + B.length){
			return 0;
		}
		if(0==A.length){
			return A[k-1];
		}
		if(0==B.length){
			return B[k-1];
		}
		while(k>0){
			if(a==A.length && b==B.length){
				break;
			}
			if(a==A.length && b<B.length){
				result = B[b];
				b++;
			}else if(b==B.length && a<A.length){
				result = A[a];
				a++;
			}else if(B[b]<A[a]){
				result = B[b];
				b++;
			}else if(A[a]<=B[b]){
				result = A[a];
				a++;
			}
			k--;
		}
		return result;
	}
}
