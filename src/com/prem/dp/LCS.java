package com.prem.dp;

 /**
 *        p |r |e |m |b |h |a |r |t |i |
 *     0 |0 |0 |0 |0 |0 |0 |0 |0 |0 |0 |
 *   p 0 |1 |1 |1 |1 |1 |1 |1 |1 |1 |1 |
 *   r 0 |1 |2 |2 |2 |2 |2 |2 |2 |2 |2 |
 *   a 0 |1 |2 |2 |2 |2 |2 |3 |3 |3 |3 |
 *   k 0 |1 |2 |2 |2 |2 |2 |3 |3 |3 |3 |
 *   h 0 |1 |2 |2 |2 |2 |3 |3 |3 |3 |3 |
 *   a 0 |1 |2 |2 |2 |2 |3 |4 |4 |4 |4 |
 *   r 0 |1 |2 |2 |2 |2 |3 |4 |5 |5 |5 |
 *
 *   start from j=1 and i=1
 *   if str[i-1] matches with str2[j-1]
 *      add 1 from diagonally above on left
 *   else
 *      take max (one left or one up)
 */

public class LCS {

  private char[] str1= "prembharti".toCharArray();
  private char[] str2= "prakhar".toCharArray();

  public static void main(String[] args) {
    LCS lcs= new LCS();
    int[][] resultMatrix=lcs.createMatrix(lcs.str1,lcs.str2);
    lcs.display(resultMatrix);
    System.out.println("Maximum lcs is:"+resultMatrix[lcs.str2.length][lcs.str1.length]);
    lcs.bottomUp(resultMatrix,lcs.str1,lcs.str2);
  }

  /**
   *        p |r |e |m |b |h |a |r |t |i |
   *     0 |0 |0 |0 |0 |0 |0 |0 |0 |0 |0 |
   *   p 0 |1 |1 |1 |1 |1 |1 |1 |1 |1 |1 |
   *   r 0 |1 |2 |2 |2 |2 |2 |2 |2 |2 |2 |
   *   a 0 |1 |2 |2 |2 |2 |2 |3 |3 |3 |3 |
   *   k 0 |1 |2 |2 |2 |2 |2 |3 |3 |3 |3 |
   *   h 0 |1 |2 |2 |2 |2 |3 |3 |3 |3 |3 |
   *   a 0 |1 |2 |2 |2 |2 |3 |4 |4 |4 |4 |
   *   r 0 |1 |2 |2 |2 |2 |3 |4 |5 |5 |5 |
   *
   *   start from j=1 and i=1
   *   if str[i-1] matches with str2[j-1]
   *      add 1 from diagonally above on left
   *   else
   *      take max (one left or one up)
   */

  public int[][] createMatrix(char[] str1, char[] str2){

    int[][] matrix= new int[str2.length+1][str1.length+1];
          for(int j=1;j<=str2.length;j++){
            for(int i=1;i<=str1.length;i++){

              if(str1[i-1]==str2[j-1]){
                matrix[j][i]=matrix[j-1][i-1]+1;
              }
              else{
                matrix[j][i]=Math.max(matrix[j][i-1],matrix[j-1][i]);
              }
            }
          }
    return matrix;
  }

  public void bottomUp(int[][] resultMatrix,char[] str1, char[] str2){
    int i=str1.length;
    int j=str2.length;
    while(i!=0){
      if(resultMatrix[j][i]==resultMatrix[j][i-1]){
        i--;
      }
      else{
        System.out.print(str1[i-1]+",");
        j--;i--;
      }
    }
  }

  public void display(int[][] matrix){
      for(int i=0;i<matrix.length;i++){
        for(int j=0;j<matrix[0].length;j++){
          System.out.print(matrix[i][j]+" |");
      }
      System.out.println();
    }
  }
}
