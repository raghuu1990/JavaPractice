package com.company.amazon;

import java.util.Scanner;

import com.node.StackNode;

public class Round2 {
	private static MyStack stack = new MyStack();
	public static void main(String[] args) {

		Scanner in = new Scanner(System.in);
		int T = in.nextInt();

		int[] answer = new int[T];
		int k = 0;
		for (int i = 0; i < T; i++) {
			int a = in.nextInt();
			if (a == 1) {
				int b = in.nextInt();
				stack.push(b);
			} else if (a == 2) {
				stack.pop();
			} else if (a == 3) {
				stack.max();
			}
		}
		for (int i = 0; i < k; i++) {
			System.out.println(answer[i]);
		}
		in.close();
	}
}

class MyStack{
	StackNode top;
	public StackNode push(int data) {
		StackNode newNode = new StackNode();
		newNode.data = data;
		newNode.prev = top;
		if(top==null) {
			newNode.min = data;
			newNode.max = data;
		}else {
			newNode.min = top.min;
			newNode.max = top.max;
			if(top.min>data) {
				newNode.min = data;
			}
			if(top.max<data) {
				newNode.max = data;
			}
		}
		top = newNode;
		return top;
	}

	public StackNode pop() {
		if(top==null){
            return null;
        }
		StackNode deletedNode = top;
		top = top.prev;
		return deletedNode;
	}

	public int peek() {
		if(top==null){
            return 0;
        }
		return top.data;
	}

	public int max() {
		if(top==null){
            return 0;
        }
		return top.max;
	}

	public int min() {
		if(top==null){
            return 0;
        }
		return top.min;
	}
}