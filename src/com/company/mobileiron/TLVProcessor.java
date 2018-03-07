package com.company.mobileiron;

import java.util.Scanner;

enum TYPE {
	UPPRCS, REPLCE, LOWRCS;
	
	public static String process(String typeString, int length, String value) {
		TYPE type;
		try {
			type = TYPE.valueOf(typeString);
		}catch(Exception ex) {
			return "Type not valid";
		}
		if (TYPE.UPPRCS == type) {
			return TYPE.UPPRCS.toString()+"-"+value.toUpperCase();
		} else if (TYPE.LOWRCS == type) {
			return TYPE.LOWRCS.toString()+"-"+value.toLowerCase();
		} else if (TYPE.REPLCE == type) {
			return "REPLCE-THIS STRING";
		}
		return "Type not valid";
	}
}

public class TLVProcessor {
	public static void main(String[] args) {
		Scanner in = new Scanner(System.in);
		String input = "";
		while(in.hasNext()) {
			input += in.next();
			input = process(input);
		}
		in.close();
	}

	public static String process(String input) {
		while(!input.isEmpty()) {
			String type = input.substring(0, 6);
			int length = Integer.parseInt(input.substring(7, 11));
			String value = input.substring(12, 12+length);
			System.out.println(TYPE.process(type, length, value));
			input = input.substring(12+length);
		}
		return input;
	}
}