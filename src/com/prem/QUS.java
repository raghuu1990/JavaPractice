package com.prem;


public class QUS {
	public static void main(String[] args) {
		St stack1= new St(10);
		for(int i=0;i<12;i++){
			stack1.push(i);
		}
		stack1.display();
	}
}

class St{
	private int top=-1;
	private int[] nums;
	
	
	public St(int size) {
		nums= new int[size];
	}
	
	public void push(int num){
		if(top==nums.length-1){
			System.out.println("Overflow");
		}
		else nums[++top]=num;
	}
	
	public int pop(){
		if(top==0) throw new RuntimeException("Underflow");
		return nums[top--];
	}
	
	public void display(){
		for(int i=0;i<=top;i++){
			System.out.println(nums[i]+", ");
		}
	}
}