package com.prem.stringop;

/**
 * show not repeated characters in word.
 * naina -> i
 */
public class UniqueCharacters {

  static int[] countStorage= new int[256];

  public void countStorage(char[] word){
    for(int i=0;i<word.length;i++){
      int charNum=word[i];
      if(countStorage[charNum]==0){
       countStorage[charNum]=1;
      }
      else {
        countStorage[charNum]=-1;
      }
    }
  }

  public void printUniqueCharacters(char[] word){
    countStorage(word);
    for(int i=0;i<countStorage.length;i++){
      if(countStorage[i]>0){
        System.out.print((char)i+", ");
      }
    }
  }

  public static void main(String[] args) {
    UniqueCharacters uc= new UniqueCharacters();
    char[] word="whatareyoudoing".toCharArray();
    char[] word1="naina".toCharArray();
    char[] word2="deepikachauhan".toCharArray();
//    uc.printUniqueCharacters(word);
    System.out.println();
    //uc.printUniqueCharacters(word1);
    System.out.println();
    uc.printUniqueCharacters(word2);

  }
}
