package com.company.housing;

public class NumberBinaryComplement {

	
	public static void main(String args[]){
		String str =  Integer.toBinaryString(100);
		System.out.println(str);
		str = str.replace('1', '2');
		str = str.replace('0', '1');
		str = str.replace('2', '0');
		System.out.println(str);
		int abc = Integer.parseInt((str),2);
	    System.out.println(abc);
	}
}
