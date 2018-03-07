package com.string;

public class StringPool {
	public static void main(String[] args) {
		String s1 = "abc";
		String s2 = "abc";
		String s3 = new String("abc");
		
		String s4 = new String("abcd");
		String s5 = "abcd";
		String s6 = new String("abcd");
		
		String s7 = "abcde";
		String s8 = new String("abcde").intern();
		String s9 = "abcde";
		
		String s10 = new String("abcdef").intern();
		String s11 = "abcdef";

		System.out.println(s1.hashCode());
		System.out.println(s2.hashCode());
		System.out.println(s3.hashCode());
		System.out.print(s1==s2); System.out.println(" , "+ s1.equals(s2));
		System.out.print(s2==s3);	System.out.println(" , "+ s2.equals(s3));
		System.out.println();
		
		System.out.println(s4.hashCode());
		System.out.println(s5.hashCode());
		System.out.println(s6.hashCode());
		System.out.print(s4==s5);	System.out.println(" , "+ s4.equals(s5));
		System.out.print(s4==s6);	System.out.println(" , "+ s4.equals(s6));
		System.out.println();
		
		System.out.println(s7.hashCode());
		System.out.println(s8.hashCode());
		System.out.println(s9.hashCode());
		System.out.print(s7==s8);	System.out.println(" , "+ s7.equals(s8));
		System.out.print(s7==s9);	System.out.println(" , "+ s7.equals(s9));
		System.out.println();

		System.out.println(s10.hashCode());
		System.out.println(s11.hashCode());
		System.out.print(s10==s11);	System.out.println(" , "+ s10.equals(s11));
		System.out.println();
	}
}