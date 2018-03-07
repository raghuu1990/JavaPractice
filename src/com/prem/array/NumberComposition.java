package com.prem.array;

/**
 * Created by lovebharti on 30/12/16.
 */
public class NumberComposition {

  static int arrSize=100;

//  public void printArray(int arr[], int arr_size);

  /* The function prints all combinations of numbers 1, 2, ...MAX_POINT
     that sum up to n.
     i is used in recursion keep track of index in arr[] where next
     element is to be added. Initital value of i must be passed as 0 */
  public static void printCompositions(int n, int i)
  {

  /* array must be static as we want to keep track
   of values stored in arr[] using current calls of
   printCompositions() in function call stack*/
    int arr[]=new int[arrSize];

    if (n == 0)
    {
      printArray(arr, i);
    }
    else if(n > 0)
    {
      int k;
      for (k = 1; k <= 3; k++)
      {
        arr[i]= k;
        printCompositions(n-k, i+1);
      }
    }
  }

  /* UTILITY FUNCTIONS */
/* Utility function to print array arr[] */
  public static void printArray(int arr[], int arr_size)
  {
    int i;
    for (i = 0; i < arr_size; i++)
      System.out.println(arr[i]+" ");
  }

  public static void main(String[] args) {
    printCompositions(5,0);
  }

/*  *//* Driver function to test above functions *//*
  int main()
  {
    int n = 5;
//    printf("Differnt compositions formed by 1, 2 and 3 of %d are\n", n);
    printCompositions(n, 0);
    //getchar();
    //return 0;
  }*/

}
