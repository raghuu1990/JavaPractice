package com.exception;

// try must catch exception or  declare throws exception on method 
// try must contain one of catch or finally 

class TestFinallyBlock {
	public static void main(String args[]) {
		try {
			int data = 25 / 0;
			System.out.println(data);
		} catch (NullPointerException e) {
			System.out.println(e);
		} catch (ArithmeticException e) {
			//System.out.println(e);
			e.printStackTrace();
		} finally {
			System.out.println("finally block is always executed");
		}
		System.out.println("rest of the code...");
	}
}
