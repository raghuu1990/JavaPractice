package com.basics;

import java.util.Scanner;

public class CaesarCipher {

	
	public static void main(String[] args) {
		Scanner in = new Scanner(System.in);
        int t  = in.nextInt();
        in.nextLine();
        String str = in.nextLine();
        str = str.substring(0, t);
        
        int r = in.nextInt();
        r = r%26;
        
        char cArray[] = str.toCharArray();
        for (int i=0;i<t;i++) {
        	char c = cArray[i];
        	if(c<='Z' && c >= 'A'){
        		if((c-(26-r))>='A'){
            		c = (char) (c-(26-r));
            	}else if((c+r)<='Z'){
            		c = (char) (c+r);
            	}
        	}else if(c<='z' && c >= 'a'){
        		if((c-(26-r))>='a'){
            		c = (char) (c-(26-r));
            	}else if((c+r)<='z'){
            		c = (char) (c+r);
            	}
        	}
        	cArray[i] = c;
        }
        System.out.println(cArray);
	}
}
