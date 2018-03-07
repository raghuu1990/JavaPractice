package com.string;

import java.util.Scanner;

// https://www.hackerrank.com/challenges/java-string-tokens

public class Split {
	public static void main(String[] args) {
		Scanner scan = new Scanner(System.in);
        String s = scan.nextLine();
        if (s.length() == 0 || s.trim().length() == 0) {
            System.out.println("0");
        }else{
            String[] ar = s.trim().split("[ .,@_'?!]+");
            System.out.println(ar.length);
            for(String m : ar){
                System.out.println(m);
            }
       }
       scan.close();
	}
}