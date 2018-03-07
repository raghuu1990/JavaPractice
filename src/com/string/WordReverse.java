package com.string;

public class WordReverse {

	static String wordReverse(String str){
		String outPut="";
		char[] strArray= str.toCharArray();
		int length = str.length();
		for(int i=length-1; i>=0;){
			if(strArray[i]==' '){
				while(i>=0 && strArray[i]==' '){
					outPut+=strArray[i];
					i--;
				}
				if(i<0)
					break;
			}else{
				int l=i;
				while(l>=0 && strArray[l]!=' '){
					l--;
					i--;
				}

				l++;
				while(l<length && strArray[l]!=' '){
					outPut+=strArray[l];
					l++;
				}
				if(i<0)
					break;
			}
		}
		return outPut;
	}

	public static void main(String[] args){
		String str1 = "";
		String str2 = "a";
		String str3 = " a ";
		String str4 = "  a   ";
		String str5 = " ";
		String str6 = "  ";
		String str7 = "  a";
		String str8 = "a  ";
		String str9 = "a  a";
		String str10 = " What is Java ";
		String str11 = "  What  is  Java   ";
	    String str12 = " WhatisJava ";
	    String str13 = "WhatisJava";
	    
	    print(str1);
	    print(str2);
	    print(str3);
	    print(str4);
	    print(str5);
	    print(str6);
	    print(str7);
	    print(str8);
	    print(str9);
	    print(str10);
	    print(str11);
	    print(str12);
	    print(str13);
	}
	
	public static void print(String str){
		System.out.println("|"+str + "|"+ "\n"+ "|"+ wordReverse(str)+"|"+"\n");
	}
}
