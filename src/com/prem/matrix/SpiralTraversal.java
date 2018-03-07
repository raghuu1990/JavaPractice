package com.prem.matrix;

/**
 * spiral traversal starting from start point
 *
 * O(n^2)
 *
 * Left/up------right
 *  |             |
 *  |             |
 *  Down----------
 *
 *  loop in condition until left<=right and up<=down
 *
 *    go left to right (print top)-> up++
 *    go up to down (print right) -> right--
 *    go right to left (print down) -> down--
 *    go down to up (print left) -> left++
 *
 */
public class SpiralTraversal {

  public int[][] getMatrix(){
    int[][] matrix=
        {
            {1,2,3,4},
            {12,13,14,5},
            {11,16,15,6},
            {10,9,8,7},
        };
    return matrix;
  }

  public void spiralTraverse(int[][] matrix){
    if(matrix.length==0) return;

    int left=0;
    int right=matrix[0].length-1;
    int up=0;
    int down=matrix.length-1;

    while(left<=right && up<=down){
      for(int i=left;i<=right;i++){
        System.out.print(matrix[up][i]+", ");
      }
      up++;
      for(int i=up;i<=down;i++){
        System.out.print(matrix[i][right]+", ");
      }
      right--;
      for(int i=right;i>=left;i-- ){
        System.out.print(matrix[down][i]+", ");
      }
      down--;
      for(int i=down;i>=up;i--){
        System.out.print(matrix[i][left]+", ");
      }
      left++;
    }
  }

  public static void main(String[] args) {
    SpiralTraversal st = new SpiralTraversal();
    int[][] matrix=st.getMatrix();
    st.spiralTraverse(matrix);

  }
}
