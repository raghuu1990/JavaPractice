package com.prem.dp;

/**
 * Created by lovebharti on 2/1/17.
 */
public class DecodeWays {

  public static void main(String[] args) {
    DecodeWays dw= new DecodeWays();
    System.out.println(dw.decodeWays("129".toCharArray()));
  }


  public int decodeWays(char[] word){
    int[] count= new int[word.length+1];
    count[0]=1;
    count[1]=1;

    if(word.length==1) {return 1;}
    if(word.length>1){
      for(int i=2;i<=word.length;i++){
        if((word[i-1]>'0' && word[i-1]<='6') && (word[i-2]=='1' || word[i-2]=='2')){
          count[i]=count[i-1]+count[i-2];
        }
        else{
          count[i]=count[i-1];
        }
      }
    }
    return  count[word.length];
  }
}
