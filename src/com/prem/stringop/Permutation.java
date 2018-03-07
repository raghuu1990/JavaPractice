package com.prem.stringop;

import java.util.ArrayList;
import java.util.List;

public class Permutation {

  public static char[] word= "abc".toCharArray();

  /**
   *
   * @param word
   * @param low
   */
  public void permutation(char[] word,int low){ //abc,0|abc,1|abc,2
    for(int i=low;i<word.length;i++){           //0->2|1->2|2->2
      if(low==word.length-1){                   //0==2|1==2|2==2|
        System.out.println(word);                           //abc
      }
      swap(word,i,low);                         //abc,0,0|abc,1,1|abc,2,2
      permutation(word, low + 1);         //abc,1|abc,2
      swap(word,i,low); //second swap to rearrange, it maintains order
    }
  }
  public void permutation(char[] word,int low,List<String> words){ //abc,0|abc,1|abc,2
    for(int i=low;i<word.length;i++){           //0->2|1->2|2->2
      swap(word,i,low);                         //abc,0,0|abc,1,1|abc,2,2
      if(low==word.length-1){                   //0==2|1==2|2==2|
        words.add(String.valueOf(word));
      }
      else {
        permutation(word, low + 1,words);         //abc,1|abc,2
      }
      swap(word,i,low); //second swap to rearrange, it maintains order
    }
  }

  public void swap(char[] word,int i,int j){
    char temp = word[i];
    word[i]=word[j];
    word[j]=temp;
  }


  public static void main(String[] args) {
    Permutation p = new Permutation();
    //p.permutation(Permutation.word,0);
    List<String> words= new ArrayList<>();
    //p.permutation(Permutation.word,0,words);
    p.permutation(Permutation.word,0);

    for(String w:words){
      System.out.println(w);
    }
  }
}