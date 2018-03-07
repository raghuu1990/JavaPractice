package com.prem.graph;

/**
 *  1 in matrix represents island in existence
 *
 *  find no. of island present in matrix
 *
 *         {{1, 1, 0, 0, 0},
 *          {0, 1, 0, 0, 1},
 *          {1, 0, 0, 1, 1},
 *          {0, 0, 0, 0, 0},
 *          {1, 0, 1, 0, 1}};
 *  answer -> 5
 *
 *  create a boolean[][] matrix of nxn
 *  start to traverse matrix simply
 *  if found 1 and not visited increment no. of island count
 *      and pass to dfs method
 *  where it's going to traverse 3 up, 1 left, 1 right and 3 down recursively
 *  when you find not visited and traverse it set it visited, it will set all
 *  adjacent visited
 *
 *  every time pass to valid method which will check boundary and having 1 in matrix
 *  condition
 *
 *
 */
public class NoOfIslands {
  private int[][] matrix;
  private boolean[][] visited;


  public NoOfIslands(){
    this.matrix= new int[][]
        {{1, 1, 0, 0, 0},
         {0, 1, 0, 0, 1},
         {1, 0, 0, 1, 1},
         {0, 0, 0, 0, 0},
         {1, 0, 1, 0, 1}};
    this.visited= new boolean[matrix.length][matrix[0].length];
  }

  public static void main(String[] args) {
    NoOfIslands ni= new NoOfIslands();
    System.out.println(ni.findNoOfIsland(ni.matrix,ni.visited));
    System.out.println(ni.getLargestIsland(ni.matrix));
  }

  /**
   * island visited condition:
   * 1. in boundary
   * 2. there's an island
   * 3. not visited
   */
  public boolean isValid(int[][] matrix,int row,int col, boolean[][] visited){
    return (row>=0 && row<matrix.length && col>=0 && col<matrix[0].length &&
        matrix[row][col]==1 &&
        !visited[row][col]);
  }

  public void DFS(int[][] matrix, int row, int col, boolean[][] visited){
    int colm[]= {-1,0,1,-1,1,-1,0,1};
    int rowm[]= {-1,-1,-1,0,0,1,1,1};
    visited[row][col]=true;

    for(int k=0;k<colm.length;k++){
      if(isValid(matrix,row+rowm[k],col+colm[k],visited)){
        DFS(matrix,row+rowm[k],col+colm[k],visited);
      }
    }
  }

  public int findNoOfIsland(int [][]matrix,boolean[][] visited){
    int count=0;
    for(int j=0;j<matrix.length;j++){
      for(int i=0;i<matrix[0].length;i++){
        if(matrix[j][i]==1 && !visited[j][i]){ //there's island and not visited.
          count++;
          DFS(matrix,j,i,visited);
        }
      }
    }
    return count;
  }

  public int getLargestIsland(int[][] matrix){
    boolean [][] visited= new boolean[matrix.length][matrix[0].length];
    int largestRegion=0;
    for(int j=0;j<matrix.length;j++) {
      for (int i = 0; i < matrix[0].length; i++) {
        if (matrix[j][i] == 1 && !visited[j][i]) {
          if(isValid(matrix,j,i,visited)){
            visited[j][i]=true;
            largestRegion = Math.max(largestRegion, dfsForLargestIsland(matrix, visited, j, i, 1));
          }
        }
      }
    }

    return largestRegion;
  }

  public int dfsForLargestIsland(int[][] matrix, boolean[][] visited, int j, int i,int count){
    int rows[]={-1,-1,-1,0,0,1,1,1};
    int cols[]={-1,0,1,-1,1,-1,0,1};

    for(int k=0;k<rows.length;k++){
      if(isValid(matrix,j+rows[k],i+cols[k],visited) && matrix[j+rows[k]][i+cols[k]]==1 && !visited[j+rows[k]][i+cols[k]]){

        visited[j+rows[k]][i+cols[k]]=true;
        count++;
        count=dfsForLargestIsland(matrix,visited,j+rows[k],i+cols[k],count);
      }
    }
    return count;
  }


}