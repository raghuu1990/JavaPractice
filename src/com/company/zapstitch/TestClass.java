package com.company.zapstitch;

import java.util.Scanner;

public class TestClass {

	public static int map[][]= new int [10000][10000];
	
	public static void main(String args[] ) throws Exception {
		Scanner in = new Scanner(System.in);
		
		int N = in.nextInt();
		int a[] = new int [N+1];
		for (int i = 1; i <= N; i++) {
			a[i] = in .nextInt();
		}

		int T = in.nextInt();
		int result[] = new int[T+1];

		for (int i = 1; i <= T+1 ; i++) {
			int T1 = in.nextInt();
			int T2 = in.nextInt();
			int T3 = in.nextInt();

			if(T1==1){
				a[T2] = T3;
			}else if(T1==2){
				LCM(a, T2, T3);
			}
		}
		in.close();

	}
	
	private static void LCM(int[] arr, int a, int b) {
		int lcm = arr[a];
		for (int i = a+1; i <= b; i++) {
			if(lcm%arr[i]!=0){
				lcm = LCM(lcm, arr[i]);
			}
		}
		lcm = lcm % 1000000007;
		System.out.println(lcm);
	}
	
	private static int gcf(int a, int b){
	    while (a != b){
	        if (a > b) a -= b;
	        else b -= a;
	    }
	    return a;
	}
	
	private static int LCM(int a, int b) {
		if(a<10000 && b< 10000){
			if(0!=map[a][b]){
				return map[a][b]; 
			}else{ 
				map[a][b] =  (a * b) / gcf(a, b);
				return map[a][b]; 
			}
		}else{
			map[a][b] =  (a * b) / gcf(a, b);
			return map[a][b]; 
		}
	}
}