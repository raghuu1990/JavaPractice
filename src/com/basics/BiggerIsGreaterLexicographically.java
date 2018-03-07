package com.basics;

import java.util.Scanner;

public class BiggerIsGreaterLexicographically {

	public static void main(String[] args){
		/* Enter your code here. Read input from STDIN. Print output to STDOUT. Your class should be named Solution. */
		Scanner in = new Scanner(System.in);
		int t = in.nextInt();
		in.nextLine();
		String [] str = new String [t];
		for(int i=0; i<t ;i++){
			str[i] = in.nextLine();
		}
		
		for(int i=0; i<t ;i++){
			String s = str[i];
			int l = s.length();
			if(l<2){
				System.out.println("no answer");
				continue;
			}
			
			int[] hash = new int[256];
			
			int j = l-1;
			while(j>0){
				int c = s.charAt(j);
				hash[c]= hash[c]+1;
				if(s.charAt(j)<=s.charAt(j-1)){
					if(j==1){
						System.out.println("no answer");
						break;
					}
					j--;
				}else{
					j--;
					int d = s.charAt(j);
					hash[d]= hash[d]+1;
					if(j>0){
						s = s.substring(0, j);
					}else{
						s="";
					}
					int p = d+1;
					while(p<='z'){
						if(hash[p]!=0){
							s+=(char) p+"";
							hash[p] = hash[p]-1;
							break;
						}
						p++;
					}
					
					int x = 'a';
					while(x<='z'){
						if(hash[x]!=0){
							s+=(char) x+"";
							hash[x] = hash[x]-1;
						}
						if(hash[x]==0){
							x++;
						}
					}
					System.out.println(s);
					break;
				}
			}
		}
	}
}
