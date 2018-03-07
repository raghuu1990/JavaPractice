package com.hackerrank.hack101;

import java.util.Scanner;

public class TrainTicket {
	public static void main(String[] args) {
		Scanner in = new Scanner(System.in);
		int n = in.nextInt();
		//System.out.println(berthType(n));
		in.close();
		for (int i = 0; i < 72; i++) {
			System.out.println(i+" : "+berthType(i));
		}
	}
	
	static String berthType(int n) {
        if(n%8==0) {
        	return "SUB";
        }else if(n%7==0) {
        	return "SLB";
        }else if(n%8==1 || n%8==4) {
        	return "LB";
        }else if(n%8==2 || n%8==5) {
        	return "MB";
        }else if(n%8==3 || n%8==6) {
        	return "UB";
        }
		return "";
    }
}
