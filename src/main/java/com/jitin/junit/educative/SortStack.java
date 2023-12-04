package com.jitin.junit.educative;

public class SortStack {


  public static void main(String[] args) {
    SortStack sortStack = new SortStack();
    Stack<Integer> stack = new Stack<>(7);
    stack.push(23);
    stack.push(60);
    stack.push(12);
    stack.push(42);
    stack.push(4);
    stack.push(97);
    stack.push(2);
    sortStack.sortStack(stack);
  }

  private void sortStack(Stack<Integer> stack) {

    Stack<Integer> newStack = new Stack<>(stack.getMaxSize());
    while (!stack.isEmpty()) {
      Integer value = stack.pop();
      if (!newStack.isEmpty() && value >= newStack.top()) {
        newStack.push(value);
      } else {
        while (!newStack.isEmpty() && newStack.top() > value)
          stack.push(newStack.pop());
        newStack.push(value);
      }
    }

    while (!newStack.isEmpty())
      stack.push(newStack.pop());
  }
}
