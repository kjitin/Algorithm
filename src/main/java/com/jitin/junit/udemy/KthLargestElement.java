package com.jitin.junit.udemy;

import java.util.PriorityQueue;
import java.util.Queue;

public class KthLargestElement {


  public static void main(String[] args) {
    KthLargestElement kthLargestElement = new KthLargestElement();
    int[] nums = {8, 13, 6, 7, 21};
    System.out.println(kthLargestElement.findKthLargestElement(nums, 2));
  }

  private int findKthLargestElement(int[] nums, int k) {

    Queue<Integer> minHeap = new PriorityQueue<>();
    for (final int num: nums) {
      minHeap.offer(num);
      while (minHeap.size() > k) {
        minHeap.poll();
      }
    }
    return minHeap.peek();
  }
}
