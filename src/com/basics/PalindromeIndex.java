package com.basics;

import java.util.Scanner;

public class PalindromeIndex {
	public static void main(String[] args){
		Scanner in = new Scanner(System.in);
		int t = in.nextInt();
		in.nextLine();
		String [] str = new String [(t)];
		for(int i=0; i<t ;i++){
			str[i] = in.nextLine();
		}
		
		for(int i=0; i<t ;i++){
			String tempStr = str[i];
			int l = tempStr.length();
			int index = -1;
			for(int j=0; j<l/2 ;j++){
				if(!(tempStr.charAt(j)==tempStr.charAt(l-1-j))){
					if((tempStr.charAt(j+1)==tempStr.charAt(l-1-j)) && (tempStr.charAt(j)==tempStr.charAt(l-1-j-1))){
						if(isAnagram(tempStr.substring(j, l-1-j))){
							index = l-1-j;
							break;
						}else if(isAnagram(tempStr.substring(j+1, l-1-j+1))){
							index = j;
							break;
						}
					}else if((tempStr.charAt(j+1)==tempStr.charAt(l-1-j))){
							index=j;
					}else if((tempStr.charAt(j)==tempStr.charAt(l-1-j-1))){
							index=l-1-j;
					}
					break;
				}
			}
			System.out.println(index);
		}
		in.close();
	}
	
	public static boolean isAnagram(String str){
		int l = str.length();
		for(int i =0; i<l/2; i++){
			if(!(str.charAt(i)==str.charAt(l-1-i))){
				return false;
			}
		}
		return true;
	}
}
