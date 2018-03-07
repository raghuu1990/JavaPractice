package com.utils;

public class StringUtils extends ArrayUtils{

	public static boolean isNull(String str){
		if(null==str){
			return true;
		}else{
			return false;
		}
	}

	public static boolean isNullOrEmpty(String str){
		if(isNull(str) && "".equalsIgnoreCase(str)){
			return true;
		}
		return false;
	}

	public static boolean isEmpty(String str){
		if(isNull(str)  || "".equalsIgnoreCase(str)){
			return true;
		}
		return false;
	}
	
	public static boolean isBlank(String str){
		if(isNull(str)  || "".equalsIgnoreCase(str)){
			return true;
		}
		return false;
	}

	public static boolean isNotEmpty(String str) {
		return !isEmpty(str);
	}
}
