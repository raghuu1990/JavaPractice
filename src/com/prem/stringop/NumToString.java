package com.prem.stringop;

import java.util.HashMap;
import java.util.Map;

public class NumToString {


  Map<Integer,String> numMap= new HashMap<>();

/*
  public NumToString(){
    numMap.put(1,"One");
    numMap.put(2, "Two");
    numMap.put(3, "Three");
    numMap.put(4, "Four");
    numMap.put(5, "Five");
    numMap.put();
    numMap.put();
    numMap.put();
    numMap.put();
    numMap.put();
    numMap.put();
    numMap.put();
    numMap.put();
    numMap.put();
    numMap.put();
  }
*/

  public String number(int num){
    String str="";
    if(num>999){
      str+=number(num/1000);
      num=num%1000;
    }
    return str;
  }

  public static void main(String[] args) {
    NumToString num= new NumToString();
    System.out.println(num.number(1100));
  }
}
