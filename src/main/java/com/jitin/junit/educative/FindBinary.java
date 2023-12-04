package com.jitin.junit.educative;

public class FindBinary {

  public static void main(String[] args) {
    int number = 1;
    String[] result = findBinary(number);

    for (String res: result) {
      System.out.println(res);
    }

  }

  private static String[] findBinary(int number) {

    String[] result = new String[number];
    Queue<String> binaries = new Queue<>(number);
    binaries.enqueue("1");

    for (int i = 0; i < number; i++) {
      result[i] = binaries.dequeue();
      String s1 = result[i]+ "0";
      String s2 = result[i]+ "1";
      binaries.enqueue(s1);
      binaries.enqueue(s2);
    }

    return result;
  }
}
