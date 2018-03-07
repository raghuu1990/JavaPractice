package com.basics;

public class JavaIO {

	static long add(int a, long sum) {
		return a+sum;
	}
	
	static int add(int a, int sum) {
		return a+sum;
	}

	public static void main(String[] args) {
		/*
		Scanner in = new Scanner(System.in);
		int a = in.nextInt();
		int b = in.nextInt();
		int sum = add(a, b);
		System.out.println(sum);
		*/
		
		/*
		Scanner in = new Scanner(System.in);
        int t  = in.nextInt();
        for (int i=0;i<t;i++) {
        	int a = in.nextInt();
        	int b = in.nextInt();
            int sum = add(a, b);
            System.out.println(sum);
        }
        */
		/*
        Scanner in = new Scanner(System.in);
        int t  = in.nextInt();
        long sum = 0;
        for (int i=0;i<t;i++) {
        	int a = in.nextInt();
            sum += a;
        }
        System.out.println(sum);
        */
	}
}


