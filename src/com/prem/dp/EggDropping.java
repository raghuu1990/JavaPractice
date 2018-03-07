package com.prem.dp;

import com.prem.util.CodeUtil;

/**
 * We are given f floors and n eggs
 * We need find how many attempts we need to find
 * maximum floor from which egg will not be broken if thrown
 *
 */
public class EggDropping {

 /**
  *      1 egg 1 floor  -> min attempt 1 ( if broke attempted 1, if not you got answer)
  *      2 egg 1 floor  -> min attempt 1 ( 1 egg 1 floor will give you answer)
  *      1 egg 2 floor  -> min 1 attempt  ( 1 attempt ( if broke in 1 attempt) -> 1 egg and 1 floor left (already solved)
  *
  *
  *                            floors
  *                  0 | 1 | 2 | 3 | 4 | 5 | 6
  *             0    0 | 0 | 0 | 0 | 0 | 0 | 0 |
  *     eggs    1    0 | 1 | 2 | 3 | 4 | 5 | 6 |
  *             2    0 | 1 | 2 | 2 | 3 | 3 | 3 |
  *
  *
  *
  **/
  public int getMinAttemptToBreakEgg(int floor, int egg) {
    int[][] matrix = new int[egg+1][floor+1];
    for(int i=1;i<floor+1;i++) {
      matrix[1][i]=i;
    }
    int attempts=0;

    for(int j=2;j<egg+1;j++) {
      for(int i=1;i<floor+1;i++) {
        if (i < j) {
          matrix[j][i] = matrix[j - 1][i];
        } else {
          matrix[j][i] = Integer.MAX_VALUE;
          for (int k = 1; k <= i; k++) {
            // 1<- 2 3 = if broken at this stage(1 egg, 1 floor) -> you don't need any attempt (0)
            //           if not broken here then still we have 2 egg but two more floors to cover ( 2 eggs, 2 floor) (3-1 -> i - k)

            //a) matrix[j - 1][k - 1] -> if broken now then answer was one less egg and one less floor
            //b) matrix[j][i - k] -> if not broken then we got same no. of eggs but floors left i-k
            attempts = 1 + Math.max(matrix[j - 1][k - 1], matrix[j][i - k]);
            if (attempts < matrix[j][i]) matrix[j][i] = attempts; // take minimum of all attempts
          }
        }
      }
    }
    CodeUtil.display2dMatrix(matrix);
    return matrix[egg][floor];
  }

  public static void main(String[] args) {
    EggDropping ed= new EggDropping();
    System.out.println(ed.getMinAttemptToBreakEgg(100, 2));
  }
}