package com.test;

import java.util.Scanner;

public class Test2 {

	public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
		
		int n = in.nextInt();
		in.nextLine();
		for (int i = 0; i < n; i++) {
			String str = in.nextLine();
            print(str);
		}
        
    }
    
    public static void print(String str) {
		for (int i = 0; i < str.length(); i++) {
			if(i%2==0) {
				System.out.print(str.charAt(i));
			}
		}
		System.out.print(" ");
		for (int i = 0; i < str.length(); i++) {
			if(i%2!=0) {
				System.out.print(str.charAt(i));
			}
		}
        System.out.println();
	}
}
