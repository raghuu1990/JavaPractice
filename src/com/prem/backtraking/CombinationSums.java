package com.prem.backtraking;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class CombinationSums {

  public static void main(String[] args) {
    CombinationSums sum= new CombinationSums();
    int[] candidates={2,4,6,8};
    //int[] candidates={1,2,3};
    int target=8;

//    List<List<Integer>> lists=sum.getCombinationSumRepeated(candidates,target);
    List<List<Integer>> lists=sum.getCombinationSumNonRepeated(candidates,target);
//    List<List<Integer>> lists=sum.getAllCombination(candidates,target);
    for(List<Integer> list:lists){
      System.out.println(list.toString());
    }
  }

  /**
   *
   * candidates={2,4,6,8}
   * target = 8
   *
   * 1. Sort array
   * 2. start to call dfs method by passing candidate, target, pos, path, results
   * 3. in each dfs method start from pos to end of candidate array
   *    first add current pos element in path and
   *    send target-current[pos] to next dfs
   *
   *    if target is -ve just return
   *    if target is 0 -> means we found sum add path in results
   *
   *    when it'll comes back from recursion method,
   *      remove last element
   *    and loop continues with next element as pos increments.
   *
   * find all possible combinations sums up to 8, same can be repeated
   * [2, 2, 2, 2]
   * [2, 2, 4]
   * [2, 6]
   * [4, 4]
   * [8]
   */
  public List<List<Integer>> getCombinationSumRepeated(int[] candidates, int targetSum){
    List<Integer> path = new ArrayList<>();
    List<List<Integer>> result = new ArrayList<>();

    if(candidates!=null && candidates.length>0){
      Arrays.sort(candidates);
      dfsRepeeatUniqueCombination(0,targetSum,path,result,candidates);
    }
    return result;
  }

  public List<List<Integer>> getCombinationSumNonRepeated(int[] candidates, int targetSum){
    List<Integer> path = new ArrayList<>();
    List<List<Integer>> result = new ArrayList<>();

    if(candidates!=null && candidates.length>0){
      Arrays.sort(candidates);
      dfsNonRepeeatUniqueCombination(0,targetSum,path,result,candidates);
    }
    return result;
  }

  /**
   * candidates={2,4,6,8}
   * target = 8
   *
   * same as getCombinationSumRepeated
   *
   * but we don't pass incremented position
   *
   * each position starts from 0
   *
   * find all possible combinations sums up to 8
   * [2, 2, 2, 2]
   * [2, 2, 4]
   * [2, 4, 2]
   * [2, 6]
   * [4, 2, 2]
   * [4, 4]
   * [6, 2]
   * [8]
   *
   */
  public List<List<Integer>> getAllCombination(int[] candidates, int targetSum){
    List<Integer> path = new ArrayList<>();
    List<List<Integer>> result = new ArrayList<>();

    if(candidates!=null && candidates.length>0){
      Arrays.sort(candidates);
      dfsAllCombination(0,targetSum,path,result,candidates);
    }
    return result;
  }


  public void dfsRepeeatUniqueCombination(int pos, int target, List<Integer> path, List<List<Integer>> result,int[] candidates){
    if(target<0){
      return;
    }
    if(target==0){
      result.add(new ArrayList<>(path));
      return;
    }

    for(int i=pos;i<candidates.length;i++){
      path.add(candidates[i]);
      dfsRepeeatUniqueCombination(i,target-candidates[i],path,result,candidates);
      path.remove(path.size()-1);
    }
  }

  public void dfsAllCombination(int pos, int target, List<Integer> path, List<List<Integer>> result,int[] candidates){
    if(target<0){
      return;
    }
    if(target==0){
      result.add(new ArrayList<>(path));
      return;
    }

    for(int i=pos;i<candidates.length;i++){
      path.add(candidates[i]);
      dfsAllCombination(pos,target-candidates[i],path,result,candidates);
      path.remove(path.size()-1);
    }
  }

  /**
   * same as getCombinationSumRepeated
   *
   * just we send pos+1 to next dfs, so it doesnt' start from same position
   * so same element is not repeated.
   */
  public void dfsNonRepeeatUniqueCombination(int pos, int target, List<Integer> path, List<List<Integer>> result,int[] candidates){
    if(target<0){
      return;
    }
    if(target==0){
      result.add(new ArrayList<>(path));
      return;
    }

    for(int i=pos;i<candidates.length;i++){
      path.add(candidates[i]);
      dfsRepeeatUniqueCombination(i+1,target-candidates[i],path,result,candidates);
      path.remove(path.size()-1);
    }
  }

}