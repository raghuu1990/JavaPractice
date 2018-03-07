package com.string;

import java.util.Scanner;

public class CommonChild {

	public static int Hash[][];
	public static int l1;
	public static int l2;
	public static void main(String[] args) {
		/* Enter your code here. Read input from STDIN. Print output to STDOUT. Your class should be named Solution. */
		Scanner in = new Scanner(System.in);
		String str1 =in.nextLine();
		String str2 =in.nextLine();
		Hash = new int[str1.length()][str2.length()];
		str1 = str1.toUpperCase();
		str2 = str2.toUpperCase();
		l1 = str1.length();
		l2 = str2.length();
		for (int i = 0; i < l1; i++) {
			for (int j = 0; j < l2; j++) {
				Hash[i][j]=-1;
			}
		}
		int answer = recursion(str1, str2);
		in.close();
		System.out.println(answer);
	}

	public static int recursion(String str1, String str2){
		//System.out.println(str1 + " : " + str2);
		if(Hash[l1-str1.length()][l2-str2.length()]!=-1){
			//System.out.println("from hash : " + Hash[l1-str1.length()][l2-str2.length()]);
			return Hash[l1-str1.length()][l2-str2.length()];
		}
		
		if(str1.charAt(0) == str2.charAt(0)){
			//System.out.println(str1.charAt(0) +" = "+str2.charAt(0));
			if(str1.length()>1 && str2.length()>1){
				Hash[l1-str1.length()+1][l2-str2.length()+1] = 1+recursion(str1.substring(1, str1.length()), str2.substring(1, str2.length()));
				return Hash[l1-str1.length()+1][l2-str2.length()+1];
			}
			return 1;
		}else if(str1.length()>1 && str2.length()>1){
			//System.out.println("CASE 1 " + str1 + " : CASE 2 "+str2);
			int t1 = recursion(str1.substring(0, str1.length()), str2.substring(1, str2.length()));
			//Hash[l1-str1.length()][l2-str2.length()+1]=t1;
			int t2 = recursion(str1.substring(1, str1.length()), str2.substring(0, str2.length()));
			//Hash[l1-str1.length()+1][l2-str2.length()]=t2;
			Hash[l1-str1.length()][l2-str2.length()]=(t1>t2?t1:t2);
			return (t1>t2?t1:t2); 
		}else if(str1.length()>1 && str2.length()==1){
			Hash[l1-str1.length()+1][l2-str2.length()] = recursion(str1.substring(1, str1.length()), str2.substring(0, str2.length()));
			return Hash[l1-str1.length()+1][l2-str2.length()];
		}else if(str1.length()==1 && str2.length()>1){
			Hash[l1-str1.length()][l2-str2.length()+1] = recursion(str1.substring(0, str1.length()), str2.substring(1, str2.length()));
			return Hash[l1-str1.length()][l2-str2.length()+1];
		}
		return 0;
	}
}