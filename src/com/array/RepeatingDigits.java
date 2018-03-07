package com.array;

import java.util.HashSet;
import java.util.Scanner;
import java.util.Set;

// How many no having repeting digits in range of nos

public class RepeatingDigits{
    public static void main(String[] args)  {
        Scanner in = new Scanner(System.in);
        int arr_rows = 0;
        int arr_cols = 0;
        arr_rows = Integer.parseInt(in.nextLine().trim());
        arr_cols = Integer.parseInt(in.nextLine().trim());

        int[][] arr = new int[arr_rows][arr_cols];
        for(int arr_i = 0; arr_i < arr_rows; arr_i++) {
            for(int arr_j = 0; arr_j < arr_cols; arr_j++) {
                arr[arr_i][arr_j] = in.nextInt();
            }
        }

        if(in.hasNextLine()) {
          in.nextLine();
        }

        countNumbers(arr);
        in.close();
    }
    static void countNumbers(int[][] arr) {
        for(int i=0; i<arr.length; i++){
            int a = arr[i][0];
            int b = arr[i][01];
            System.out.println(find(a, b));
        }
    }

    static int find(int a, int b) {
        int size = 0;
        for(int i=a; i<=b; i++){
            if(!isRepeat(i)){
                size++;
            }
        }
        return size;
    }

    static boolean isRepeat(int a) {
        Set<Integer> s = new HashSet<Integer>();
            while(a>0){
                int r = a%10;
                a/=10;
                if(s.contains(r)){
                    return true;
                }else{
                    s.add(r);
                }
        }
        return false;
    }    
}