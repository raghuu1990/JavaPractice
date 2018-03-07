package com.company.flipkart;

import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

public class SnakeAndLadder {
	public static int max = 30;
	public static int lastSet = 1;
	public static int result = 30;
	public static int [] board = new int [30];
	public static Map<Integer, Integer> snake = new HashMap<Integer, Integer>();
	public static Map<Integer, Integer> ladder = new HashMap<Integer, Integer>();
	public static void main(String args[]) {
		Scanner in = new Scanner(System.in);
		int T = in.nextInt();
		for (int i = 0; i < T; i++) {
			int n = in.nextInt();
			int [][] snakeladder = new int [n][2];
			snake = new HashMap<Integer, Integer>();
			ladder = new HashMap<Integer, Integer>();
			for (int j = 0; j < n; j++) {
				int a = in.nextInt();
				int b = in.nextInt();
				if(isSnake(a,b)){
					snake.put(a,b);
				}else{
					ladder.put(a,b);
				}
				snakeladder[j][0] = a;
				snakeladder[j][1] = b;
			}
			board[1] = 0;
			lastSet = 0;
			calculate(2,lastSet);
			System.out.println("final : "+board[30]);
		}
		in.close();
	}

	private static void calculate(int cur, int lastSet) {
		System.out.println(result);
		int n = 0;
		for(int i=cur+1; i==30; i++) {
			if(i-lastSet<7){
				board[i] = n;
			}
			if(isSnake(i)){
				board[i]=max;
			}
			
			
			n++;
			if(max-cur<7){
				cur=max;
				if(result>n){
					result = n;
				}
				break;
			}
			cur+=i;
			cur = processSnakeAndLadder(cur);
			calculate(cur, n);
		}
	}

	static int processSnakeAndLadder(int cur) {
		while(isSnake(cur) || isLadder(cur)){
			if(isSnake(cur)){
				cur = getSnakeTail(cur);
			}
			if(isLadder(cur)){
				cur = getLadderTop(cur);
			}
		}
		return cur;
	}
	
	private static boolean isSnake(int a){
		if(snake.containsKey(a)){
			return true;
		}else{
			return false;
		}
	}

	private static Integer getSnakeTail(int a){
		if(snake.containsKey(a)){
			return snake.get(a);
		}else{
			return null;
		}
	}

	private static boolean isLadder(int a){
		if(ladder.containsKey(a)){
			return true;
		}else{
			return false;
		}
	}

	private static Integer getLadderTop(int a){
		if(ladder.containsKey(a)){
			return ladder.get(a);
		}else{
			return null;
		}
	}

	private static boolean isSnake(int a, int b){
		if(a>b){
			return true;
		}else{
			return false;
		}
	}

	private static boolean isLadder(int a, int b){
		return !isSnake(a,b);
	}
}
