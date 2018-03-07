package com.hackerrank.hiringtest;

import java.io.*;
import java.util.*;

public class Solution {
    
    /*
    LF = "hello world"
    SF =     "h w",      "hw",        "herld", "hello ", " world", "heowld", "ldhe", "brb"
    
    Return = "elloorld",  ello orld  ,  llo wo,    world   , hello,  ll or,    INVALID, INVALID           
    */

    /*
     * Complete the function below.
     */
    static String getRemovedChar(String shortform, String longform) {
        StringBuffer sb = new StringBuffer();
        int j = 0;
        int k = 0;
        int i = 0;
        for(; i < shortform.length(); i++){
            k = j;
            boolean flag = false;
            for(; k < longform.length(); k++){
                if(shortform.charAt(i)==longform.charAt(k)){
                    j = k+1;
                    k++;
                    flag = true;
                    break;
                }else{
                    sb.append(longform.charAt(k));
                }
            }
            if(!flag){
                return "INVALID";
            }
            
        }
        
        for(; k < longform.length(); k++){
             sb.append(longform.charAt(k));
        }
        return sb.toString();
    }
    
    public static void main(String[] args) throws IOException {
        Scanner in = new Scanner(System.in);
        final String fileName = System.getenv("OUTPUT_PATH");
        BufferedWriter bw = null;
        if (fileName != null) {
            bw = new BufferedWriter(new FileWriter(fileName));
        }
        else {
            bw = new BufferedWriter(new OutputStreamWriter(System.out));
        }

        String res;
        String shortform;
        try {
            shortform = in.nextLine();
        } catch (Exception e) {
            shortform = null;
        }

        String longform;
        try {
            longform = in.nextLine();
        } catch (Exception e) {
            longform = null;
        }

        res = getRemovedChar(shortform, longform);
        bw.write(res);
        bw.newLine();

        bw.close();
    }
}
