package com.jitin.junit.leetcode;

import java.util.Stack;

public class SimplifyPath {


  public static void main(String[] args) {
    String[] paths = {"/home/", "/a//b/c/d"};
    System.out.println(simplifyPath(paths[1]));
  }

  private static String simplifyPath(String path) {
    Stack<String> stack = new Stack<String>();

    for(String dir: path.split("/")) {

      if(dir.isEmpty() || dir.equals(".")) {
        continue;
      }

      if(dir.equals("..")) {
        if(!stack.isEmpty()) {
          stack.pop();
        }
      } else {
        stack.push(dir);
      }
    }

    return "/" + String.join("/", stack);
  }
}
