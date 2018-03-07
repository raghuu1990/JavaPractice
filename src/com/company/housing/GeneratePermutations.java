package com.company.housing;
import java.util.Arrays;
import java.util.TreeSet;

public class GeneratePermutations {
	static int telephoneNumberSize = 0;
	public static char keys[][] = {
		{'0','0','0'},
		{'1','1','1'},
		{'A','B','C'},
		{'D','E','F'},
		{'G','H','I'},
		{'J','K','L'},
		{'M','N','O'},
		{'P','R','S'},
		{'T','U','V'},
		{'W','X','Y'}
	};

	private static char getCharKey(int telephoneKey, int place) {
		if(place<1 || place >3){ throw new IllegalArgumentException("Place must be between 1-3 (Inclusive)");}
		if(telephoneKey<0 || telephoneKey>9){ throw new IllegalArgumentException("TelephoneKey must be between 0-9 (Inclusive)");}
		return keys[telephoneKey][place-1];
	}

	private static TreeSet<String> generatePermutations(int[] telephoneNumber) {
		TreeSet<String> allPermutations = new TreeSet<String>();
		telephoneNumberSize = telephoneNumber.length;
		recursion(0, new String(), telephoneNumber, allPermutations);
		return allPermutations;
	}
	
	private static void recursion(int counter, String myNumber, int[] telephoneNumber, TreeSet<String> allPermutations){
		try{ 
				if(counter==telephoneNumberSize){
					allPermutations.add(myNumber);
					return;
				}
				for(int place=1; place<=3 && counter < telephoneNumberSize; place++){
					recursion(counter+1, myNumber + getCharKey(telephoneNumber[counter], place)+"", telephoneNumber, allPermutations);
				}
		}catch(Exception ex){
			System.out.println("Exception : " + ex);
		}
	}
	
	public static void main(String[] args) {
		int telephoneNumber[] =  {0,1,2,3,4,5,6};
		TreeSet<String> allPermutations = generatePermutations(telephoneNumber);
		System.out.println("TelephoneNumber : " + Arrays.toString(telephoneNumber));
		System.out.println("AllPermutations : " + allPermutations.size());
		PrintAllPermutations(allPermutations);
	}

	private static void PrintAllPermutations(TreeSet<String> allPermutations) {
		int i = 1;
		for (String permutation :  allPermutations){
			System.out.println( i + " : " + permutation);
			i++;
		}
	}
}