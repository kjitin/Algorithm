package com.jitin.junit.educative;

public class MinWindowSubsequence {


  public static void main(String[] args) {
    String[] str1 = {
      "azssstaszaztf", "fgrqsqsnodwmxzkzxwqegkndaa", "zxcvnhss", "alpha", "beta"
    };
    String[] str2 = {
      "saz", "kzed", "css", "la", "ab"
    };
    for (int i = 0; i < str1.length; i++) {
      System.out.println(i + 1 + ".\tInput String: " + "(" + str1[i] + ", " + str2[i] + ")");
      System.out.println("\tSubsequence string: " + minWindow(str1[i], str2[i]));
      System.out.println(new String(new char[100]).replace('\0', '-'));
    }
  }
  public static String minWindow(String s, String t) {
    int sizeStr1 = s.length();
    int sizeStr2 = t.length();

    int indexS1 = 0;
    int indexS2 = 0;
    int start,end = 0;
    float minSubSequenceLength = Float.POSITIVE_INFINITY;
    String minSubsequence = "";

    while(indexS1 < sizeStr1) {

      if(s.charAt(indexS1) == t.charAt(indexS2)) {
        indexS2 = indexS2 + 1;

        if(indexS2 == sizeStr2) {
          start = indexS1;
          end = indexS1;

          indexS2 = indexS2 -1;
          while(indexS2 >=0) {
            if(s.charAt(start) == t.charAt(indexS2)) {
              indexS2 = indexS2 -1 ;
            }
            start = start -1;
          }
          start = start+1;
          if((end - start +1) < minSubSequenceLength) {
            minSubSequenceLength = (end -start +1);
            minSubsequence = s.substring(start, end+1);
          }
          indexS1 = start;
          indexS2 = 0;

        }
      }
      indexS1 = indexS1 + 1;
    }

    return minSubsequence;
  }

}
