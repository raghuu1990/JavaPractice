package com.basics;

import java.util.Scanner;

public class TheLoveLetterMystery {

	public static void main(String[] args){
		/* Enter your code here. Read input from STDIN. Print output to STDOUT. Your class should be named Solution. */
		Scanner in = new Scanner(System.in);
		int t = in.nextInt();
		in.nextLine();
		String [] str = new String [t];
		for(int i=0; i<t ;i++){
			str[i] = in.nextLine();
		}
		
		for(int i=0; i<t ;i++){
			String tempStr = str[i];
			int l = tempStr.length();
			int change = 0;
			for(int j=0; j<l/2 ;j++){
				change+= absolute(tempStr.charAt(j)-tempStr.charAt(l-j-1));
			}
			System.out.println(change);
		}
	}
	
	public static int absolute(int a){
		if(a<0){
			return -1*a;
		}
		return a;
	}
}
