package com.calls;

public class Point{	
	public String X;
	public String Y;

	public Point() {
		this.X="";
		this.Y="";
	}
	
	public Point(String X, String Y){
		this.X=X;
		this.Y=Y;
	}
	
	@Override
	public String toString(){
		return "X: " + this.X + ", Y: " +this.Y; 
	}
	
	/*public static void main(String args[]) {

		Double d1 = new Double(12.0);
		Double d2 = d1;
		d1 = d1 + 1;
		System.out.println(d1 == d2);
		System.out.println(d1);
		System.out.println(d2);

	}
*/
}
