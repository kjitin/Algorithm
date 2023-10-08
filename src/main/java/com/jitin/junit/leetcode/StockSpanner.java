package com.jitin.junit.leetcode;

import java.util.Stack;

public class StockSpanner {
  Stack<int []> stack = new Stack<>();

  public static void main(String[] args) {
    StockSpanner stockSpanner = new StockSpanner();
    System.out.println(stockSpanner.next(100));
    System.out.println(stockSpanner.next(80));
    System.out.println(stockSpanner.next(60));
    System.out.println(stockSpanner.next(70));
    System.out.println(stockSpanner.next(60));
    System.out.println(stockSpanner.next(75));
  }

  public int next(int price) {
    int ans = 1;
    while (!stack.isEmpty() && stack.peek()[0] <= price) {
      ans += stack.pop()[1];
    }

    stack.push(new int[] {price, ans});
    return ans;
  }
}
