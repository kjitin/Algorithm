package com.jitin.junit.recursion;

public class ReverseString {

  public String reverseString(String str) {
//checks if the string is empty
    if (str.isEmpty()) {
      System.out.println("String is empty.");
//if the above condition is true returns the same string
      return str;
    } else {
      return reverseString(str.substring(1)) + str.charAt(0);
    }
  }

  public static void main(String[] args) {
    ReverseString rs = new ReverseString();
    String resultantSting3 = rs.reverseString("INDIA");
    System.out.println(resultantSting3);

  }
}
