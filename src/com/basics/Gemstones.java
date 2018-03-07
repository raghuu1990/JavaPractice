package com.basics;

import java.util.Scanner;

public class Gemstones {

	public static void main(String[] args) {
		/* Enter your code here. Read input from STDIN. Print output to STDOUT. Your class should be named Solution. */
		Scanner in = new Scanner(System.in);
		int t = in.nextInt();
		in.nextLine();
		String [] str = new String [t];
		int counter = 0;
		for(int i=0; i<t ;i++){
			str[i] = in.nextLine();
		}

		for(int i='a' ; i<='z' ; i++){
			int temp = 0;
			for(int j=0 ; j<t ; j++){
				String s = str[j];
				if(s.contains(((char)i+""))){
					temp++;
				}
			}
			if(temp == t){
				counter++;
			}
		}
		System.out.println(counter);
	}
}					
