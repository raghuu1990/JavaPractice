package com.prem.array;

public class ProductPair {

  /**
   * given sorted array and a product, find numbers forms product.
   *
   * O(n)
   *
   * put a pointer on start and end
   * multiply start and end
   *    if multiply exceeds product do end--
   *    else start++
   *    print when equals product
   */
  public void findProductPair(int[] nums,int product){
    if(nums.length>1){
      int i=0,j=nums.length-1;
      while(i<j){
        if(nums[i]*nums[j]==product){
          System.out.println(nums[i]+","+nums[j]);
          i++;
          //break; if want only one pair
        }
        else if(nums[i]*nums[j]>product){
          j--;
        }
        else if(nums[i]*nums[j]<product){
          i++;
        }
      }
    }
  }

  public static void main(String[] args) {
    int[] nums={1,2,3,4,5,6,7,8};
    ProductPair pp = new ProductPair();
    for(int i=2;i<57;i++){
      System.out.println(i+":");
      pp.findProductPair(nums,i);
    }

  }


}
