package com.prem.stack;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;
import java.util.Stack;

/**
 * You're given list of time interval might be overlapping.
 *
 * You've to merge the overlapping interval and result should contain all
 * non-overlapping intervals.
 *
 * 1. sort all intervals on base of start time.
 * 2. create a stack and push first interval
 * 3. start a loop from second interval to last interval
 * 4. get second interval from loop and peek interval from stack and check if they can merge
 * 5. if the can merge, merge them after popping interval from stack and push in stack the merged interval
 * 6. if they can't merge push into stack.
 */
public class OverlappingIntervals {

  public static void main(String[] args) {
    List<Interval> intervals = new ArrayList<>();
    intervals.add(new Interval(1,3));
    intervals.add(new Interval(2,6));
    intervals.add(new Interval(8,10));
    intervals.add(new Interval(15,18));

    Collections.sort(intervals,new IntervalComparator());
    Stack<Interval> stack= new Stack<>();
    stack.push(intervals.get(0));

    for(int i=1;i<intervals.size();i++){
      if(canMerge(stack.peek(),intervals.get(i))){
        Interval interval1=stack.pop();
        Interval interval2=intervals.get(i);
        Interval interval3= new Interval(interval1.start,interval2.end);
        stack.push(interval3);
      }
      else {
        stack.push(intervals.get(i));
      }
    }

    while(!stack.isEmpty()){
      System.out.print(stack.pop().toString()+" ");
    }
  }

  public static boolean canMerge(Interval a,Interval b){
    return a.start<=b.start && a.end>=b.start && a.end<=b.end;
  }
}

class Interval{
  int start;
  int end;

  public Interval(int start,int end){
    this.start=start;
    this.end=end;
  }

  @Override
  public String toString() {
    return "["+start+","+end+"]";
  }
}

class IntervalComparator implements Comparator<Interval> {
  @Override
  public int compare(Interval o1, Interval o2) {
    return o1.start-o2.start;
  }
}
