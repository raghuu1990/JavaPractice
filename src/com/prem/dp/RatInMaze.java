package com.prem.dp;

import java.util.ArrayList;
import java.util.List;

import com.prem.util.CodeUtil;

/**
 * Rat is at (0,0) top left end and rat has to reach at bottom right end.
 *
 * 0 is path in matrix and -1 is blockage
 *  1. print no. of ways rat can reach target
 *  2. Need to print all path through which rat can reach to bottom right end.
 */
public class RatInMaze {

  public static void main(String[] args) {
    int[][] maze= {
        {0,0,0,0},
        {0,-1,0,0},
        {-1,0,0,0},
        {0,0,0,0}
    };

    RatInMaze rim= new RatInMaze();
//    System.out.println(rim.countWays(maze));

    List<String> results=rim.printAllMaze(maze);
    System.out.println(results);

  }


  public int countWays(int[][] maze){

    boolean blockFound=false;
    for(int j=0;j<maze.length;j++){
      if(maze[j][0]==0 && !blockFound){
        maze[j][0]=1;
      }
      else {
        blockFound=true;
      }
    }

    blockFound=false;
    for(int i=1;i<maze[0].length;i++){
      if(maze[0][i]==0 && !blockFound){
        maze[0][i]=1;
      }
      else{
        blockFound=true;
      }
    }
    CodeUtil.display2dMatrix(maze);


    for(int j=1;j<maze.length;j++){
      for(int i=1;i<maze[0].length;i++){
        if(maze[j][i]>=0){
          if(maze[j][i-1]>0){
            maze[j][i]+=maze[j][i-1];
          }
          if(maze[j-1][i]>0){
            maze[j][i]+=maze[j-1][i];
          }
        }
      }
    }
    System.out.println("-----------");
    CodeUtil.display2dMatrix(maze);

    return maze[maze.length-1][maze[0].length-1];


  }


  public List<String> printAllMaze(int[][] maze){
    String path="";
    List<String> results = new ArrayList<>();
    printAllMazeUtil(maze,0,0,path,results);
    return results;
  }

  public void printAllMazeUtil(int[][] maze, int j, int i,String path,List<String> results){

    if(j==maze.length-1 && i==maze[0].length-1){
      results.add(path);
      //System.out.println(path);
    }

    if(isValid(j+1,i,maze)){
      printAllMazeUtil(maze,j+1,i,path+"D",results);
    }
    if(isValid(j,i+1,maze)){
      printAllMazeUtil(maze,j,i+1,path+"R",results);
    }
  }

  public boolean isValid(int j,int i,int[][] maze){
    return j>=0 && j<maze.length && i>=0 && i<maze[0].length && maze[j][i]==0;
  }


}
