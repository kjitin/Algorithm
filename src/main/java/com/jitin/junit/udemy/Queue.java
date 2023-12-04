package com.jitin.junit.udemy;

public class Queue<T> {

  private Node first;
  private Node last;

  private int length;

  public Queue(T data) {
    Node newNode = new Node(data);
    first = newNode;
    last = newNode;
    length = 1;
  }

  public void enqueue(T data) {
    Node newNode = new Node(data);
    if (first == null) {
      first = newNode;
      last = newNode;
    } else {
      last.next = newNode;
      last = newNode;
    }
    length++;
  }

  public Node dequeue() {
    if (length == 0) return null;

    Node temp = first;
    if (length == 1) {
      first = null;
      last = null;
    } else {
      first = first.next;
      temp.next = null;
      length--;
    }
    return temp;

  }
  public void printQueue() {
    Node temp = first;
    while (temp !=null) {
      System.out.println(temp.data);
      temp = temp.next;
    }
  }

  public static void main(String[] args) {
    Queue<Integer> queue = new Queue<>(1);
    queue.enqueue(2);
    queue.printQueue();
    queue.dequeue();
    queue.printQueue();
  }
}
