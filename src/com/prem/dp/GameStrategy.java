package com.prem.dp;

/**
 * coins = {6,7,1,4}
 *
 * Two players are playing game, one pick one coin from either left or right side
 *
 * how will first player pick coins from left or right in way
 * he can get maximum coins in game.
 *
 *  A -> 6 4      -> 10
 *  B ->   7 1    -> 8
 *
 *  A -> 4 7      -> 11    this strategy will give first player maximum 11
 *  B ->  6 1     -> 7
 *
 */
public class GameStrategy {

  /**
   *      6     7     1      4
   * 6 | 6,0 | 7,6 | 7,7 | 11,7 |
   * 7 | ___ | 7,0 | 7,1 |  8,4 |
   * 1 | ___ | ___ | 1,0 |  4,1 |
   * 4 | ___ | ___ | ___ |  4,0 |
   *
   *  for one coin -> fill diagonally [i][i] -> x,0
   *  for more than one coin -> @ matrix[i][i+j]
   *  down -> pick first -> coin[i] + down -> matrix[i+1][i+j].second
   *  left -> pick last  -> coin[i+j] + left -> matrix[i][i+j-1].second
   *
   *  check which has more profit
   *    set first profit to that.
   *    and take same down/left 's  first value for second player.
   *
   * First:11
   * Second:7
   *
   */
  public Profit getMaxProfit(int[] coins) {

    Profit[][] matrix = new Profit[coins.length][coins.length];

    //i goes to down and i+j goes to right of matrix
    // i+1 down and i+j-1 for left
    for(int j=0;j<coins.length;j++) {
      for(int i=0;i+j<coins.length;i++) {
        if (j == 0) {
          matrix[i][i]= new Profit(coins[i],0);
        }
        else{
          int firstProfit=0;
          int secondProfit=0;
          int leftProfit=coins[i+j]+matrix[i][i+j-1].second;
          int downProfit=coins[i]+matrix[i+1][i+j].second;
          if(leftProfit>downProfit) {
            firstProfit=leftProfit;
            secondProfit=matrix[i][i+j-1].first;
          }
          else {
            firstProfit=downProfit;
            secondProfit=matrix[i+1][i+j].first;
          }
          matrix[i][i+j]= new Profit(firstProfit,secondProfit);
        }
      }
    }
    display(matrix);
    return matrix[0][coins.length-1];
  }

  public static void main(String[] args) {
    //int[] coins= new int[]{2,9,3,1};
    //int[] coins= new int[]{6,7,1,4};
    int[] coins= new int[]{2,9,3};
    GameStrategy gs= new GameStrategy();
    Profit profit=gs.getMaxProfit(coins);
    System.out.println("First:" + profit.first);
    System.out.println("Second:" + profit.second);
  }

  public static void display(Profit[][] matrix) {
      for(int j=0;j<matrix.length;j++){
        for(int i=0;i<matrix[0].length;i++){
          if(matrix[j][i]==null){
            System.out.print("___ |");
          }
          else{
            System.out.print(matrix[j][i].first+","+matrix[j][i].second+" | ");
          }
        }
        System.out.println();
      }
    }

}

class Profit{
  int first;
  int second;

  Profit(int first, int second) {
    this.first=first;
    this.second=second;
  }
}