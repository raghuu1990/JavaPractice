package com.prem.graph;

public class FriendCircle {

  public static void main(String[] args) {
    int[][] circle= {
        {1,1,0,0},
        {1,1,1,0},
        {0,1,1,0},
        {0,0,0,1},
    };

    FriendCircle fc= new FriendCircle();
    System.out.println(fc.noOfFriendCircle(circle));


  }

  public boolean isValid(int[][] circle,boolean[][] visited,int j, int i){
    return j<circle.length && j>=0 && i<circle[0].length && i>=0 && circle[j][i]==1 && !visited[j][i];
  }

  public int noOfFriendCircle(int[][] circle){
    boolean visited[][] = new boolean[circle.length][circle[0].length];
    int count=0;
    for(int j=0;j<circle.length;j++){
      for(int i=0;i<circle[0].length;i++) {
        if (isValid(circle, visited, j, i)) {
          visited[j][i] = true;
          count++;
          dfs(circle, visited, j);
        }
      }
    }
    return count;
  }

  public void dfs(int[][] circle,boolean[][] visited,int j){
      for(int i=0;i<circle[0].length;i++){
        if(isValid(circle,visited,j,i)){
          visited[j][i]=true;
          if(i!=j && !visited[i][j]){
            dfs(circle,visited,i);
          }
        }
      }
  }




}
