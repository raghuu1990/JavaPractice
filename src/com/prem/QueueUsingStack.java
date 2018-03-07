package com.prem;
public class QueueUsingStack {

	Stack stack1 = new Stack();
	Stack stack2 =  new Stack();
	
	
	public static void main(String[] args) {
		QueueUsingStack qus= new QueueUsingStack();
		qus.enqueue(1);
		qus.display();
		qus.enqueue(2);
		qus.display();
		qus.enqueue(3);
		qus.enqueue(4);
		qus.enqueue(5);
		qus.display();
		qus.dequeue();
		qus.dequeue();
		
		qus.display();
	}
	public void enqueue(int num){
		try{
			System.out.println("--1"+num);
			if(!stack1.isEmpty()){
				stack1.push(num);
			}
			else{
				stack2.push(num);
			}
		}
		catch(Exception e){
			System.out.println(e);
		}
	}

	public void display(){
		if(!stack1.isEmpty()){
			stack1.display();
		}
		else if(!stack2.isEmpty()){
			stack2.display();
		}
	}
	
	public void dequeue(){
		if(!stack1.isEmpty()){
			while(stack1.isEmpty()){
				stack2.push(stack1.pop());
			}
			//return stack2.pop();
		}
		else{
			while(stack2.isEmpty()){
				stack1.push(stack2.pop());
			}
			//return stack1.pop();
		}
	}
}

class Stack{
	private int MAX_SIZE=5;
	private int[] array=new int[MAX_SIZE];
	private int top=-1;
	
	public void push(int num){
		if(top==MAX_SIZE-1){
			throw new RuntimeException("Overflow case, can't add more element now");
		}
		else if(top<0){
			top++;
		}
		else{
			System.out.println("--3"+top);
			array[top++]=num;
			System.out.println("Value at:"+top+":"+this.array[top]);
		}
	}

	public int pop(){
		if(top<0){
			throw new RuntimeException("Underflow exception case, can't remove more elements");
		}
		else{
			return array[top--];
		}
	}
	
	public void display(){
		for(int i=0;i<top;i++){
			System.out.print(i+" ");
		}
		System.out.println();
	}
	
	public boolean isEmpty(){
		return top<0;
	}
}