package com.prem.stringop;

import java.util.LinkedHashMap;
import java.util.Map;

/**
 * Given an integer 1642 -> MDCXLII
 * convert it into roman word
 *
 * Create a linkedHashMap from 1000 to 1 in descending order having different entity
 *
 * take a number
 *  start to check from first of linkedhashMap, check if current number(1642) is greater than key (1000).
 *  then Add M(1000) and send 1642-1000=642 to next recursion
 *
 */
public class IntToRoman {

  //1642
  Map<Integer, String> map = new LinkedHashMap<>();
  public IntToRoman(){
    map.put(1000, "M");
    map.put(900, "CM");
    map.put(500, "D");
    map.put(400, "CD");
    map.put(100, "C");
    map.put(90, "XC");
    map.put(50, "L");
    map.put(40, "XL");
    map.put(10, "X");
    map.put(5, "V");
    map.put(4, "IV");
    map.put(1, "I");
  }

  public String intToRoman(int num) {
    String result = "";
    for (Integer key : map.keySet()) {
      if(num>=key) {
        return map.get(key)+""+intToRoman(num-key);
      }
    }
    return result;
  }

  public static void main(String[] args) {
    IntToRoman itr= new IntToRoman();
    int num=1642;
    System.out.println(num+"->"+itr.intToRoman(num));
  }
}
