package com.basics;

import java.util.Scanner;

public class IsCommonSubString {

	public static void main(String[] args) {
		/* Enter your code here. Read input from STDIN. Print output to STDOUT. Your class should be named Solution. */
		Scanner in = new Scanner(System.in);
		int t = in.nextInt();
		in.nextLine();
		
		String [] str1 = new String [t];
		String [] str2 = new String [t];

		for(int i=0;i<t;i++){
			str1[i] = in.nextLine();
			str2[i] = in.nextLine();
		}

		for(int i=0; i<t; i++){
			int k = 0;
			String s1 = str1[i];
			String s2 = str2[i];
			for(int j=0; j<256; j++){
				if(s1.contains((char)j+"") && s2.contains((char)j+"")){
					k=1;
					break;
				}
			}
			if(k==1){
				System.out.println("YES");
			}else{
				System.out.println("NO");
			}
		}
	}
}
