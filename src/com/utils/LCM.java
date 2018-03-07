package com.utils;

public class LCM {
	
	public static int map[][]= new int [10000][10000];
	
	public static void main(String[] args) {
		int a[] = {1,2,3,4,5,6};
		//LCM(a, 0, 5);
		System.out.println(hcf(7,21));
		//System.out.println(lcm(21,0));
	}

	private static int HCF(int a, int b){
		while (a != b){
			if (a > b) a -= b;
			else b -= a;
		}
		return a;
	}

	private static int hcf(int a, int b) {
        if (a == 0 || b == 0)
           return 0;
      
        if (a == b)
            return a;
      
        if (a > b)
            return hcf(a-b, b);
        return hcf(a, b-a);
    }
	
	private static int hcf1(int a, int b) {
		if (b == 0)
			return a;
		else
			return hcf(b, a % b);
	}
	
	private static int lcm(int a, int b) {
		return a*b/hcf(a, b);
	}
	 
	private static int LCM(int a, int b) {
		if (a < 10000 && b < 10000) {
			if (0 != map[a][b]) {
				return map[a][b];
			} else {
				map[a][b] = (a * b) / hcf(a, b);
				return map[a][b];
			}
		} else {
			map[a][b] = (a * b) / hcf(a, b);
			return map[a][b];
		}
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
}
