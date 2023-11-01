package com.jitin.junit.leetcode;

public class SubPalindrome {


  public static void main(String[] args) {
    String s = "abca";
    System.out.println(validPalindrome(s));
  }

  private static boolean validPalindrome(String s) {
    int start = 0;
    int end = s.length() -1;

    while(start < end) {
      if(s.charAt(start) != s.charAt(end)) {
        return validSubPalindrome(s, start+1, end) || validSubPalindrome(s, start, end-1);
      }
      start++;
      end--;
    }
    return true;
  }

  private static boolean validSubPalindrome(String s, int start, int end) {
    while(start < end) {
      if(s.charAt(start) != s.charAt(end)) {
        return false;
      }
      start++;
      end--;
    }
    return true;
  }
}
