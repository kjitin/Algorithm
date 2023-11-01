package com.jitin.junit.leetcode;

import java.util.Stack;

public class BackSpaceCompare {

  public static void main(String[] args) {
    String first = "ab#c"; //ab#c ab## a#c bxj##tw[btw]
    String second = "ad#c"; //ad#c c#d# b bxj###tw[tw]

    System.out.println(backSpaceCompare(first, second));

  }

  private static boolean backSpaceCompare(String first, String second) {
   /* String transformedS = performBackSpace(first);
    String transformedT = performBackSpace(second);
    System.out.println("s =" + transformedS + " t = "+ transformedT);
    return transformedS.equals(transformedT);*/
    char[] firstArray = first.toCharArray();
    char[] secondArray = second.toCharArray();
    int pointer1 = first.length() -1;
    int pointer2 = second.length() -1 ;

    while (pointer1 >= 0 || pointer2 >= 0) {
      int backCount = 0;
      while (pointer1 >= 0 && (first.charAt(pointer1) == '#' || backCount > 0)) {
        if (first.charAt(pointer1) == '#') {
          backCount++;
        } else {
          backCount--;
        }
        pointer1--;
      }

      backCount = 0;
      while (pointer2 >= 0 && (second.charAt(pointer2) == '#' || backCount > 0)) {
        if (second.charAt(pointer2) == '#') {
          backCount++;
        } else {
          backCount--;
        }
        pointer2--;
      }

      if (pointer1 >= 0 && pointer2 >= 0 && first.charAt(pointer1) != second.charAt(pointer2)) {
        return false;
      }

      if ((pointer1 >= 0) != (pointer2 >= 0)) {
        return false;
      }

      pointer1--;
      pointer2--;
    }
    return true;

  }

  private static String performBackSpace(String text) {
    Stack<Character> stack = new Stack<>();
    for(Character ch: text.toCharArray()) {
      if(ch == '#') {
        if(!stack.isEmpty()) {
          stack.pop();
        }
      } else {
        stack.push(ch);
      }
    }
    return stack.toString();
  }
}
