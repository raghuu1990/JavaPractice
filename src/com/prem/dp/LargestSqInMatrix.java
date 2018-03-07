package com.prem.dp;

/**
 * Created by lovebharti on 2/1/17.
 */
public class LargestSqInMatrix {

  public static void main(String[] args) {
    int[][] matrix={
        {0,0,0,0,0,1},
        {0,1,0,1,1,1},
        {0,1,0,1,0,1},
        {0,1,1,1,1,1},
        {0,0,0,0,0,0},
    };
    LargestSqInMatrix lm= new LargestSqInMatrix();

    lm.display(lm.createMatrix(matrix));
    System.out.println(lm.findLargest(lm.createMatrix(matrix)));
  }


  public int findLargest(Cordinate[][] cMatrix){
    int largest=0;
    for(int j=cMatrix.length-1;j>=0;j--){
      for(int i=cMatrix[0].length-1;i>=0;i--){
        Cordinate current=cMatrix[j][i];
        int range=Math.min(current.h,current.v);
        int leftHorizontal=current.h-(range+1);
        int upVertical=current.v-(range+1);
        for(int pos=leftHorizontal;pos<=current.h;pos++){
          int currentLargeV=Math.min(cMatrix[j][pos].v,current.v);
          if(currentLargeV<largest) continue;
          int currentLargeH=Math.min(cMatrix[j-leftHorizontal][pos].h,current.h);
          int currentLarge=Math.min(currentLargeH,currentLargeV);
          largest=Math.max(currentLarge,largest);
        }
      }
    }

    return largest;

  }











 public Cordinate[][] createMatrix(int[][] matrix){
   Cordinate[][] cMatrix= new Cordinate[matrix.length][matrix[0].length];

   for(int j=0;j<matrix.length;j++){
     if(matrix[j][0]==1){
       cMatrix[j][0]= new Cordinate(1,1);
     }
     else{
       cMatrix[j][0]= new Cordinate(0,0);
     }
   }


   for(int i=0;i<matrix[0].length;i++){
     if(matrix[0][i]==1){
       cMatrix[0][i]= new Cordinate(1,1);
     }
     else{
       cMatrix[0][i]= new Cordinate(0,0);
     }
   }

   for(int j=1;j<matrix.length;j++){
     for(int i=1;i<matrix[0].length;i++){
       if(matrix[j][i]==1){
         cMatrix[j][i]=new Cordinate(cMatrix[j][i-1].h+1,cMatrix[j-1][i].v+1);
       }
       else{
         cMatrix[j][i]=new Cordinate(0,0);
       }
     }
   }

   return cMatrix;
 }


  public void display(Cordinate[][] cMatrix){
    for(int j=0;j<cMatrix.length;j++){
      for(int i=0;i<cMatrix[0].length;i++){
        System.out.print(cMatrix[j][i]+" ");
      }
      System.out.println();
    }


  }


}
class Cordinate{
  int h;
  int v;
  public Cordinate(int h,int v){
    this.h=h;
    this.v=v;
  }

  @Override
  public String toString() {
    return "["+h+","+v+"]";
  }
}
