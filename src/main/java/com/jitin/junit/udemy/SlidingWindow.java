package com.jitin.junit.udemy;

import java.util.*;
import java.util.stream.Stream;

public class SlidingWindow {

  public static int[] findMaxSlidingWindow(int[] nums, int w) {

    if (w > nums.length) {
      w = nums.length;
    }
    Deque<Integer> deque = new ArrayDeque<>();
    int[] answers = new int[nums.length -w +1];
    deque.offer(0);

    for(int i=1; i< w; i++) {
      while(deque.size() > 0 && nums[deque.peekLast()] < nums[i]) {
        deque.removeLast();
      }
      deque.offerLast(i);
    }
   answers[0] = nums[deque.getFirst()];

    for(int j = w; j< nums.length; j++) {
      int startingPoint = j -w +1;
      while(deque.size() > 0 && deque.peek() < startingPoint) {
        deque.removeFirst();
      }
      while(deque.size() > 0 && nums[deque.peekLast()] < nums[j]) {
        deque.removeLast();
      }
      deque.offerLast(j);
      answers[startingPoint] = nums[deque.getFirst()];
    }

    return answers;
  }

  public static void main(String args[]) {
    int windowSizes [] = {3, 3, 3, 3, 2, 4, 3, 2, 3, 18};
    int [][] numLists = {
      //{1, 2, 3, 4, 5, 6, 7, 8, 9, 10},
      //{10, 9, 8, 7, 6, 5, 4, 3, 2, 1},
      //{10, 10, 10, 10, 10, 10, 10, 10, 10, 10},
      //{1, 5, 8, 10, 10, 10, 12, 14, 15, 19, 19, 19, 17, 14, 13, 12, 12, 12, 14, 18, 22, 26, 26, 26, 28, 29, 30},
      //{10, 6, 9, -3, 23, -1, 34, 56, 67, -1, -4, -8, -2, 9, 10, 34, 67},
      {4, 5, 6, 1, 2, 3},
      //{9, 5, 3, 1, 6, 3},
      //{2, 4, 6, 8, 10, 12, 14, 16},
      //{-1, -1, -2, -4, -6, -7},
      {4, 4, 4, 4, 4, 4}
    };

    for (int i = 0; i < numLists.length; i++) {
      System.out.println(i + 1 + ".\tInput array:\t" + Arrays.toString(numLists[i]));
      System.out.println("\tWindow size:\t" + windowSizes[i]);
      System.out.println("\n\tMaximum in each sliding window:\t" + Arrays.toString(findMaxSlidingWindow(numLists[i], windowSizes[i])));
      Stream.generate(() -> "-").limit(100).forEach(System.out::print);
      System.out.println();
    }
  }
}
