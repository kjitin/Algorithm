package com.jitin.junit.educative;

public class Stack<T> {

  private int maxSize;
  private int top;

  private T array[];

  @SuppressWarnings("unchecked")
  public Stack(int maxSize) {
    this.maxSize = maxSize;
    this.top = -1;
    array = (T[]) new Object[maxSize];
  }

  public int getMaxSize() {
    return maxSize;
  }

  public boolean isEmpty() {
    return top == -1;
  }

  public boolean isFull(){
    return top == maxSize -1;
  }

  public T top(){
    if (isEmpty()) return null;
    return  array[top];
  }

  public void push(T data) {
    if (isFull()) {
      System.out.println("Stack is full");
      return;
    }
    array[++top] = data;
  }

  public T pop() {
    if (isEmpty()) {
      System.out.println("Stack is empty");
      return null;
    }
    return array[top--];
  }
}
