package com.prem.matrix;

import java.util.Arrays;
import java.util.List;

import com.prem.trie.Trie;

/**
 * Given a matrix
 * {'a','b','c','d'},
 * {'o','c','a','k'},
 * {'b','o','t','t'},
 * {'p','o','k','s'}
 *
 *  check if given words can be made: "cat", "cook", "book","cats"
 *  using matrix.
 */
public class BoggleSearch {

  char[][] board=null;
  List<String> dictionary=null;

  public BoggleSearch(char[][] board,List<String> dict){
    this.board=board;
    this.dictionary=dict;
  }

  public void searchWords() {
    Trie trie =  new Trie();
    dictionary.forEach(word -> trie.insert(word));

    for(int j=0;j<board.length;j++){
      for(int i=0;i<board[0].length;i++) {
        boolean[][] visited = new boolean[board.length][board[0].length];
        visited[j][i]=true;
        searchWordUtil(visited,i,j,"",trie);
      }
    }
  }

  public void searchWordUtil(boolean[][] visited,int i,int j, String sb,Trie dict){
    int row[]={-1,-1,-1,0,0,1,1,1};
    int col[]={-1,0,1,-1,1,-1,0,1};
    for(int k=0;k<row.length;k++){
      int rowPos = j + row[k];
      int colPos = i + col[k];
        if(isValid(visited,rowPos,colPos)){
          String newWord=sb+board[rowPos][colPos];
          if(dict.wordExist(newWord)){
            visited[j][i]=true;
            System.out.println(newWord);
          }
          if(dict.startsWith(newWord)){
            visited[j][i]=true;
            searchWordUtil(visited,colPos,rowPos,newWord,dict);
          }
        }
    }
  }

  public boolean isValid(boolean[][] visited, int j,int i){
    return j>=0 && j<visited.length && i>=0 && i<visited[0].length && !visited[j][i];
  }


  public static void main(String[] args) {
    List<String> dict = Arrays.asList("cat", "cook", "book","cats");
    char[][] board={
        {'a','b','c','d'},
        {'o','c','a','k'},
        {'b','o','t','t'},
        {'p','o','k','s'}
    };

    BoggleSearch bs= new BoggleSearch(board,dict);
    bs.searchWords();
  }


}
