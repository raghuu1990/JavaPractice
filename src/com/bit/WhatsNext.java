package com.bit;

import java.util.ArrayList;
import java.util.Scanner;

// https://www.hackerrank.com/challenges/whats-next

public class WhatsNext {
	public static void main(String[] args) {
		Scanner in = new Scanner(System.in);
		int T = in.nextInt();
		for (int j = 0; j < T; j++) {
			int n = in.nextInt();
			ArrayList<Long> input = new ArrayList<Long>();
			for (int i = 0; i < n; i++) {
				input.add(in.nextLong());
			}
			ArrayList<Long> output = whatsNext(input);
			print(output);
		}
		in.close();
	}

	private static ArrayList<Long> whatsNext(ArrayList<Long> input) {
		int inputSize = input.size();
        if(inputSize==1) {
			if(input.get(0)==1) {
				input.add(1, (long)1);
			}else {
				input.add(1, (long)1);
				input.add(2, input.get(0)-1);
				input.set(0, (long)1);
			}
			return input;
		}
		
		if(inputSize==2) {
			if(input.get(0)==1) {
				input.set(1, input.get(1)+1);
			}else {
				input.add(2, input.get(0)-1);
				input.set(1, input.get(1)+1);
				input.set(0, (long)1);
			}
			return input;
		}
		
		/*if(inputSize==3) {
			if(input.get(1)==1) {
				input.set(0, input.get(0)+1);
				if(input.get(2)-1!=0) {
					input.set(2, input.get(2)-1);
				} else {
					input.remove(2);
				}
			}else {
				input.set(1, input.get(1)-1);
				input.add(3, (long)1);
				if(input.get(2)-1!=0) {
					input.add(4, input.get(2)-1);
				}
				input.set(2, (long)1);
			}
			return input;
		}*/
        
		int lastEven = (inputSize-1)%2==0?inputSize-1:inputSize-2;
		int lastOdd = (inputSize)%2==0?inputSize-1:inputSize-2;
		int lastOddBeforeEven = lastEven-1;
		boolean isEvenIsLast = false;
		if(lastOdd==lastOddBeforeEven) {
			isEvenIsLast = true;
		}
		
		if(isEvenIsLast) {
			if(input.get(lastEven)>1) {
				if(input.get(lastOddBeforeEven)>1) {
					input.add(lastEven+1, (long)1);
					input.add(lastEven+2, input.get(lastEven)-1);
                    input.set(lastEven, (long)1);
					input.set(lastEven-1, input.get(lastEven-1)-1);
				}else {
					input.set(lastEven, input.get(lastEven)-1);
					input.set(lastEven-1, (long)1);
					input.set(lastEven-2, input.get(lastEven-2)+1);
				}
			}else {
				if(input.get(lastOddBeforeEven)>1) {
					input.add(lastEven+1, (long)1);
					input.set(lastEven, (long)1);
					input.set(lastEven-1, input.get(lastEven-1)-1);
				}else {
					input.set(lastEven-1, (long)1);
					input.set(lastEven-2, input.get(lastEven-2)+1);
					input.remove(lastEven);
				}
			}
		}else {
			if(input.get(lastEven)>1) {
				if(input.get(lastOddBeforeEven)>1) {
					long temp1 = input.get(lastEven+1);
					long temp = input.get(lastEven);
					input.set(lastEven+1, temp1+1);
					input.add(lastEven+2, temp-1);
					input.set(lastEven, (long)1);
					input.set(lastEven-1, input.get(lastEven-1)-1);
				}else {
					input.set(lastEven, input.get(lastEven)-1);
					input.set(lastEven-1, input.get(lastEven+1)+1);
					input.set(lastEven-2, input.get(lastEven-2)+1);
					input.remove(lastEven+1);
				}
			}else {
				if(input.get(lastOddBeforeEven)>1) {
					input.set(lastEven+1, input.get(lastEven+1)+1);
					input.set(lastEven, (long)1);
					input.set(lastEven-1, input.get(lastEven-1)-1);
				}else {
					input.set(lastEven-1, input.get(lastEven+1)+1);
					input.set(lastEven-2, input.get(lastEven-2)+1);
					input.remove(lastEven+1);
					input.remove(lastEven);
				}
			}
		}
		return input;
	}
	
	private static void print(ArrayList<Long> arr){
		int c = arr.size();
		System.out.println(c);
		for (int i = 0; i < c; i++) {
			System.out.print(arr.get(i)+ " ");
		}
		System.out.println();
	}
}