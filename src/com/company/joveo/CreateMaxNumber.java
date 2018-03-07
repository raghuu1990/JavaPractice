package com.company.joveo;

import java.util.*;

// TODO :
// max number using concatenating all set of numbers
class CreateMaxNumber {
    public static void main(String args[] ) throws Exception {
        Scanner s = new Scanner(System.in);
        int N = s.nextInt();
        String[] arr = new String[N];
        for (int i = 0; i < N; i++) {
            arr[i] = s.next();
        }
        System.out.println(getMaxNumber(arr));
        s.close();
    }
    
    public static String getMaxNumber(String[] arr){
        int k=0;
        String result = "";
        while(k<arr.length){
            int max = Integer.MIN_VALUE;
            int max_index = 0;
            for (int i = 0; i < arr.length; i++) {
                /*if(arr[i]>0){
                    if(max == arr[i]){
                      continue;
                    }
                    int max_ = findMax(max, arr[i]);
                    if(max_==arr[i]){
                    	max=arr[i];
                        max_index = i;
                    }
                }*/
            }
            result+=max;
            arr[max_index] = 0+"";
            k++;
        }
        return result;
    }
    
    public static int findMax(int aa, int bb){
    	if(aa<-1) {
    		return bb;
    	}
        int a_ = 0;
        int b_ = 0;
        int a = aa;
        int b = bb;
        while(a/10>0){
            a_++;
            a = a/10;
        }
        
        while(b/10>0){
            b_++;
            b = b/10;
        }
            
        if(a_==b_){
            return Math.max(aa,bb);
        }else{
        	while(a>0 && b>0) {
        		if(a/Math.pow(10, a_)==b/Math.pow(10, b_)) {
        			a_--;
        			b_--;
        			continue;
        		}
        		if(a/Math.pow(10, a_)>b/Math.pow(10, b_)){
        			return aa;
        		}else {
        			return bb;
        		}
        	}
        }
        return Math.max(aa, bb);
    }
}