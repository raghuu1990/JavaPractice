package com.string;

public class NameCamelCase {

	public static String toCamelCase(String name) {
		StringBuffer str = new StringBuffer(name);
		if(str.length()>0){
			str.setCharAt(0, Character.toUpperCase(str.charAt(0)));
		}
		for(int index=1;index<str.length();index++){
			if(str.charAt(index-1) == ' ' || str.charAt(index-1) == '.' || str.charAt(index-1) == ','
					|| str.charAt(index-1) == '&'){
				str.setCharAt(index, Character.toUpperCase(str.charAt(index)));
			}else{
				str.setCharAt(index, Character.toLowerCase(str.charAt(index)));
			}
		}
		return str.toString();
	}

	public static void main(String[] args) {
		String name = "m.k. a a , a, a ,c singh & RK kUMAR";
		//String name = "aMA Ra";
		System.out.println(toCamelCase(name));
	}
}
