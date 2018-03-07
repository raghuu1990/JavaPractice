package com.company.bankbazzar;

import java.util.HashMap;
import java.util.Scanner;

public class Bankbazaar {

	static int countDuplicates(int[] numbers) {

		HashMap<Integer, Integer> map = new HashMap<Integer, Integer>();
		int count  = 0;

		for (int i = 0; i < numbers.length; i++) {
			if(!map.containsKey(numbers[i])){
				map.put(numbers[i], 1);
			}else{
				map.put(numbers[i], (map.get(numbers[i])+1));
			}
		}

		for(Integer key : map.keySet()) {
			if(map.get(key)>1){
				count++;
			}
		}

		return count;
	}

	public static void main(String[] args) {
		Scanner in = new Scanner(System.in);
		int t = in.nextInt();
		in.nextLine();
		int [] str = new int [t];
		for(int i=0; i<t ;i++){
			str[i] = in.nextInt();
		}
		countDuplicates(str);
		in.close();
	}

}
