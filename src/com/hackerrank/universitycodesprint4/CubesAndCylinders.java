package com.hackerrank.universitycodesprint4;

import java.util.Arrays;
import java.util.Scanner;

public class CubesAndCylinders {
	static int maximumPackages(int[] S, int[] K, int[] R, int[] C) {
		int count = 0;
		Cube[] cubes = new Cube[S.length];
		Cylinder[] cylinders = new Cylinder[S.length];
		for (int i = 0; i < S.length; i++) {
			cubes[i]= new Cube(S[i], K[i]);
		}
		for (int i = 0; i < R.length; i++) {
			cylinders[i] = new Cylinder(R[i], C[i]);
		}
		Arrays.sort(cubes);
		Arrays.sort(cylinders);
		
		int j = 0;
		for (int i = 0; i < cylinders.length; i++) {
			for (; j < cubes.length; j++) {
				if(cylinders[i].digonal>cubes[j].digonal && cubes[j].quantity>0 && cylinders[i].quantity>0) {
					int temp = Math.min(cubes[j].quantity, cylinders[i].quantity);
					cubes[j].quantity-= temp;
					cylinders[i].quantity-= temp;
					count+=temp;
				}
				if(cubes[j].quantity==0) {
					continue;
				}
				if(cylinders[i].quantity==0 || !(cylinders[i].digonal>cubes[j].digonal)) {
					break;
				}
			}
			if(j==cubes.length){
                break;
            }
		}

		return count;
	}

	public static void main(String[] args) {
		Scanner in = new Scanner(System.in);
		int n = in.nextInt();
		int m = in.nextInt();

		int[] S = new int[n];
		int[] K = new int[n];
		int[] R = new int[m];
		int[] C = new int[m];

		for (int i = 0; i < n; i++) {
			S[i] = in.nextInt();
		}
		in.nextLine();
		for (int i = 0; i < n; i++) {
			K[i] = in.nextInt();
		}
		in.nextLine();
		for (int i = 0; i < m; i++) {
			R[i] = in.nextInt();
		}
		in.nextLine();
		for (int i = 0; i < m; i++) {
			C[i] = in.nextInt();
		}
		in.nextLine();
		int result = maximumPackages(S, K, R, C);
		System.out.println(result);
		in.close();
	}
}

class Cylinder implements Comparable<Cylinder>{
	int radius;
	int quantity;
	Integer digonal;
	
	Cylinder(int radius, int quantity){
		this.radius = radius;
		this.quantity = quantity;
		this.digonal = 2*radius;
	}

	@Override
	public int compareTo(Cylinder o) {
		return this.digonal.compareTo(o.digonal);
	}
}

class Cube implements Comparable<Cube>{
	int edge;
	int quantity;
	Double digonal;
	
	Cube(int edge, int quantity){
		this.edge = edge;
		this.quantity = quantity;
		this.digonal = Math.sqrt(2*(edge)*(edge));
	}
	
	@Override
	public int compareTo(Cube o) {
		return this.digonal.compareTo(o.digonal);
	}
}