package com.maths;

/*
Precision and Scale :

These are important terms to understand when formatting your output:

Precision refers to the number of significant digits in a number.
For example, the numbers 123.45 and 0.012345 both have a precision of 5.

Scale refers to the number of significant digits to the right of the decimal point.
For example, the number 123.45 has a scale of 2 decimal places.
This term is sometimes mis represented as precision in documentation.

You can use the printf method, like so: System.out.printf("%.2f", val);

In short, the %.2f syntax tells Java to return your variable (val) with 2 decimal places (.2)
in decimal representation of a floating-point number (f) from the start of the format specifier (%).
There are other conversion characters you can use besides f:

    d: decimal integer
    o: octal integer
    e: floating-point in scientific notation


*/
public class Format {
	public static void main(String[] args) {
		 float floatMean = 1;
		 System.out.printf("%.2f", floatMean);
		 
		 double doubleMean = 1.00d;
		 // System.out.printf("%.2d", doubleMean);
		 
		 System.out.format("%.3f", floatMean);
		 System.out.println(Math.round(doubleMean*1000)/1000.0);
		 
		 String s1 = "123456789012345";
		 int x = 10;
		 
		 // - for right align or left allign
		 // %n for new line
		 // %0 for fill zero
		 System.out.format("%-15s%03d%n", s1, x);
		 System.out.format("%-15s%03d%n", s1, x);
	}
}
