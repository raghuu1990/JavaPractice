package com.javaconcepts;

public class Equals {
	public static void main(String[] args) {
		String str1 = "adc";
		String str2 = "adc";
		String str = new String("adc");
		str = str.intern();
		
		//str.substring(beginIndex)
		
		if(str==str1){
			System.out.println("same");
		}
		
		String s = "s";
		System.out.println("s".equals(s));
		s="t";
		System.out.println("s".equals(s));
		s="ss";
		System.out.println("ss".equals(s));

		//This is a because when you create any String literal,
		//JVM first searches for that literal in String pool,
		//if it matches, same reference will be given to that new String
		
		String obj1 = new String("xyz");
		String obj2 = new String("xyz");
		
		if("xyz".equals(obj1))
			System.out.println("obj1==obj2 is TRUE");
		else
			System.out.println("obj1==obj2 is FALSE");

		
		//String obj2 = obj1;

		//obj1="xyz";
		//obj2="xyz"; 

		if(obj1 == obj2)
			System.out.println("obj1==obj2 is TRUE");
		else
			System.out.println("obj1==obj2 is FALSE");


		if(obj1.equals(obj2))
			System.out.println("obj1 equals obj2 is TRUE");
		else
			System.out.println("obj1 equals obj2 is FALSE");
		int inti = 9;
		System.out.println("a".equals("a"));
		
		Object object1 = new Object();
		Object object2 = new Object();
		
		//object2 = null;
		//object1=object2;

		boolean result = (object1==object2);
		System.out.println("Comparing two reference pointing to same Object with == operator: " + result);

		//object1 = null;
		boolean result1 = (object1.equals(object2));
		System.out.println("Comparing two reference pointing to same Object with equals method: " + result1);

		//Some of the JVM cache objects of some wrapper class e.g. Integer from -128 to 127 and return same object which if compare via “ ==” can return true but after this range this validity doesn't work and to make it worse this behavior is JVM dependent so better avoid this kind of check and use equals() method.

		Integer i1 = 260;
		Integer i2 = 260;

		if (i1 == i2) {
		    System.out.println("i1 and i2 is equal");
		} else {
		   System.out.println("i1 and i2 is not equal ");
		}

		Integer I1 = 100;
		Integer I2 = 100;

		if (I1 == I2) {
		    System.out.println("i1 and i2 is equal");
		} else {
		   System.out.println("i1 and i2 is not equal ");
		}
	}
}
