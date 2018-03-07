package com.prem.stackQueue;

import java.util.concurrent.ArrayBlockingQueue;
import java.util.concurrent.BlockingQueue;

/**
 * Using two queue provide functionality of stack i.e. push(element) and pop()
 *
 * Push:
 * 		if any of queue is not empty and filled totally the throw OverFlow exception
 * 	otherwise:
 * 		check if any queue which is not empty
 * 			add element in that queue
 *
 * 	Pop:
 * 		if both of the queue is empty then throw UnderFlow Exception. You can't pop now
 *  		which ever queue has element dequeue all elements from that until
 *  		one element left and then enqueue to other queue.
 *
 *      now return the last element which has to be popped.
 */
public class StackUsingQueue<E> {

	private static final int MAX_SIZE=5;
	private BlockingQueue<E> queue1=new ArrayBlockingQueue<E>(MAX_SIZE);
	private BlockingQueue<E> queue2=new ArrayBlockingQueue<E>(MAX_SIZE);

	
	public void push(E a) {
		//check for overflow
		if((!queue1.isEmpty() && queue1.size()==MAX_SIZE) || (!queue2.isEmpty() && queue2.size()==MAX_SIZE))
			throw new RuntimeException("Overflow case, can't push now");
		//whichever queue contains element push in that queue
		if (!queue1.isEmpty()) {
			queue1.add(a);
		} else {
			queue2.add(a);
		}
	}

	public E pop() {
		//check for underflow
		if(queue1.isEmpty() && queue2.isEmpty()){
			throw new RuntimeException("UnderFlow, can't pop now");
		}
		
		//which ever queue has element dequeue all elements from that until
		// one element left and then enqueue to other queue.
		if (!queue1.isEmpty()) {
			while(queue1.size()!=1){
				queue2.add(queue1.poll());
			}
			if (queue1.size() > 0) {
				return queue1.remove();
			}
		}
		else{
			while(queue2.size()!=1){
				queue1.add(queue2.poll());
			}
			if (queue2.size() > 0) {
				return queue2.remove();
			}
		}
		return null;
	}

	
	public void display(){
		if(!queue1.isEmpty()){
			for(E x:queue1){
				System.out.print(x+" ");
			}
			System.out.println();
		}
		if(!queue2.isEmpty()){
			for(E x:queue2){
				System.out.print(x+" ");
			}
			System.out.println();
		}
	}
	
	public static void main(String[] args) {
		StackUsingQueue<String> suq= new StackUsingQueue<String>();
		suq.push("A");
		suq.push("B");
		suq.push("C");
		suq.push("D");
		suq.push("E");
		//suq.push("F");
		
		
		//suq.display();
		suq.pop();
		suq.pop();
		suq.pop();
		suq.display();
		suq.pop();
		suq.display();
		suq.pop();
		suq.display();
		suq.pop();
		suq.display();
		
		
	}
	
	public BlockingQueue<E> getQueue1() {
		return queue1;
	}

	public void setQueue1(ArrayBlockingQueue<E> queue1) {
		this.queue1 = queue1;
	}

	public BlockingQueue<E> getQueue2() {
		return queue2;
	}

	public void setQueue2(ArrayBlockingQueue<E> queue2) {
		this.queue2 = queue2;
	}
}