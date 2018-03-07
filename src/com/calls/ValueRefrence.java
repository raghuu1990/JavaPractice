package com.calls;

public class ValueRefrence {

	public static void swap(Point arg1, Point arg2) {
		Point temp = arg1;
		arg1 = arg2;
		arg2 = temp;
	}
	
	private static void method1(Point arg1) {
		//arg1 = new Point();
		arg1.X = "a";
		arg1.Y = "b";
		/*method2(arg1);
		return arg1;*/
	}
	
	private static Point method2(Point arg1) {
		//arg1 = new Point();
		arg1.X = "a";
		arg1.Y = "b";
		return arg1;
	}

	public static void main(String [] args) {
		Point pnt1 = new Point("X1","Y1");
		System.out.println(pnt1.toString());
		//Point pnt2 = new Point("X2","Y2");
		method1(pnt1);
		//swap(pnt1, pnt2);
		//exchange(pnt1,pnt2);
		System.out.println(pnt1.toString()); 
		//System.out.println(pnt2.toString());
	}
	
	public static void exchange(Point arg1, Point arg2) {
		Point temp = new Point();  
		temp.X = arg1.X;
		temp.Y = arg1.Y;
		arg1.X = arg2.X;
		arg1.Y = arg2.Y;
		arg2.X = temp.X;
		arg2.Y = temp.Y;
	}

}
