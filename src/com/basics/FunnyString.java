package com.basics;

import java.util.Scanner;

public class FunnyString {

	public static int absolute(int a){
		if(a<0){
			return -1*a;
		}
		return a;
	}

	public static void main(String args[]){
		Scanner in = new Scanner(System.in);
		int t = in.nextInt();
		in.nextLine();
		String [] str = new String [t];
		byte [] result = new byte[t];
		for(int i=0; i<t ;i++){
			str[i] = in.nextLine();
		}

		for(int i=0; i<t; i++){
			String s = str[i];
			int l = s.length();
			for(int j=1; j<l ;j++){
				result[i] = 1;
				if((absolute(s.charAt(j)-s.charAt(j-1))-absolute(s.charAt(l-j)-s.charAt(l-j-1)))!=0){
					result[i] = 0;
					break;
				}
			}
		}

		for(int i=0; i<t ;i++){
			if(result[i]==0){
				System.out.println("Not Funny");
			}else{
				System.out.println("Funny");
			}
		}
	}
}
