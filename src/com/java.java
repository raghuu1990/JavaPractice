package com;

public class java {

	public static void main(String[] args) {
		for (int i = 0; i < args.length; i++) {
			System.out.println(args[i]);
		}
	}
	public void func(String ...strings) {
	    for (String s : strings)
	         System.out.println(s);
	}
	
	public void checkPrime(int ...nums){
        for (int i = 0; i < nums.length; i++) {
			if(isPrime(nums[i])) {
				System.out.print(i+" ");
			}
		}
        System.out.println();
    }
	
	public void add(int ...nums){
		int sum = 0;
        for (int i = 0; i < nums.length; i++) {
            System.out.print(nums[i]);
        	sum+=nums[i];
            if(i<nums.length-1){
                System.out.print("+");
            }
		}
        System.out.print("=");
        System.out.println(sum);
    }
	
	public static boolean isPrime(int n) {
		if (n == 2) {
			return true;
		}
		if (n % 2 == 0) {
			return false;
		}
		for (int i = 3; i <= Math.sqrt(n); i += 2) {
			if (n % i == 0) {
				return false;
			}
		}
		return true;
	}
}
