package com.jitin.junit.educative;

public class Queue<T> {

  private int front;
  private int back;
  private int maxSize;

  public int getCurrentSize() {
    return currentSize;
  }

  private int currentSize;

  private T[] array;

  @SuppressWarnings("unchecked")
  public Queue(int maxSize) {
    this.maxSize = maxSize;
    front =0;
    back = 0;
    currentSize =0;
    array = (T[])new Object[maxSize];
  }

  public boolean isEmpty(){
    return currentSize == 0;
  }

  public boolean isFull() {
    return currentSize == maxSize;
  }

  public T top() {
    return array[front];
  }

  public void enqueue(T data) {
    if (isFull()) return;
    array[back] = data;
    back = (back+1) % maxSize;
    currentSize++;
  }

  public T dequeue() {
    if (isEmpty()) return null;

    T data = array[front];
    front = (front+1)%maxSize;
    currentSize--;
    return data;
  }

  public T peek() {
    T data = array[front];
    front = (front+1)%maxSize;
    return data;
  }
}
