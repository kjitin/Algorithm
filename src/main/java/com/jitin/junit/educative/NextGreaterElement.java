package com.jitin.junit.educative;

public class NextGreaterElement {

  public static void main(String[] args) {
    NextGreaterElement nge = new NextGreaterElement();
    int[] arr = {4,6,3,2,8,1};
    nge.nextGreaterElement(arr);
  }

  public int[] nextGreaterElement(int[] arr) {
    int[] result = new int[arr.length];
    Stack<Integer> stack = new Stack<>(arr.length);
    // iterate for rest of the elements
    for (int i = arr.length - 1; i >= 0; i--) {
      if (!stack.isEmpty()) {
        while (!stack.isEmpty() && stack.top() <= arr[i]) {
          stack.pop();
        }
      }
      if(stack.isEmpty()){
        result[i] = -1;
      }
      else
        result[i]  = stack.top();
      stack.push(arr[i]);
    }
    return result;
  }
}
