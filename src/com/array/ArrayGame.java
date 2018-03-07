package com.array;

import java.util.Scanner;

// https://www.hackerrank.com/challenges/java-1d-array/problem

public class ArrayGame {
	public static void main(String[] args) {
		Scanner scan = new Scanner(System.in);
		int q = scan.nextInt();
		while (q-- > 0) {
			int n = scan.nextInt();
			int leap = scan.nextInt();
			int[] game = new int[n];
			boolean[] visited = new boolean[n];
			for (int i = 0; i < n; i++) {
				game[i] = scan.nextInt();
			}
			System.out.println((canWin(leap, game, 0, visited)) ? "YES" : "NO");
		}
		scan.close();
	}
	
	public static boolean canWin(int leap, int[] game, int index, boolean[] visited) {
		if(index<0) {
			return false;
		}
		if(index>=game.length) {
			return true;
		}
        if(visited[index]) {
			return false;
		}else {
			visited[index] = true;
		}
		if(game[index]!=0) {
			return false;
		}
		if(canWin(leap, game, index-1, visited)) {
			return true;
		}
		if(canWin(leap, game, index+1, visited)) {
			return true;
		}
		if(canWin(leap, game, index+leap, visited)) {
			return true;
		}
		return false;
	}
}
