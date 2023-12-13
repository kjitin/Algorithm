package com.jitin.junit.educative;

public class ReverseWords {


  public static void main(String[] args) {
    String[] inputs = {
      "Hello World", "We love Python",
      "The quick brown fox jumped over the lazy dog.",
      "Hey", "To be or not to be", "AAAAA", " Hello     World "};

    for(int i=0; i<inputs.length; i++){
      System.out.print(i+1);
      System.out.println(".\tActual string:\t\t"+ inputs[i]);
      System.out.println("\tReversed String:\t"+ reverseWords(inputs[i]));
      System.out.println(new String(new char[100]).replace('\0', '-'));
    }
  }
  public static String reverseWords(String words) {
    String formattedString = cleanSpaces(words.toCharArray(), words.length());

    StringBuilder builder = new StringBuilder(formattedString);
    strReverse(builder, 0, builder.length() - 1);

    int n= builder.length();
    int start = 0, end = 0;
    while (start < n) {
      while (end < n && builder.charAt(end) != ' ')
        ++end;
      strReverse(builder, start, end -1);
      start = end + 1;
      ++end;
    }
    return builder.toString();
  }

  private static void strReverse(StringBuilder builder, int start, int end) {
    while (start < end) {
      char temp = builder.charAt(start);
      builder.setCharAt(start++, builder.charAt(end));
      builder.setCharAt(end--, temp);
    }
  }

  private static String cleanSpaces(char[] s1, int length) {
    String str = new String(s1,0,length);
    str = str.replaceAll("\\s+", " ").trim();
    return str;
  }
}
