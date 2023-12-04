package com.jitin.junit.educative;

public class ReverseK {

  public static void main(String[] args) {
    Queue<Integer> queue = new Queue<>(10);
    for (int i = 0; i < 10; i++) {
      queue.enqueue(i+1);
    }

    reverseK(queue, 5);

    System.out.println("Final Result ");
    for (int i = 0; i < 10; i++) {
      System.out.print(queue.dequeue()+ " ");
    }
  }

  private static void reverseK(Queue<Integer> queue, int k) {
    if (queue.isEmpty() || k <=0) return;
    Stack<Integer> stack = new Stack<>(k);
    while (!stack.isFull()) {
      stack.push(queue.dequeue());
    }
    while (!stack.isEmpty()) {
      queue.enqueue(stack.pop());
    }

    System.out.print("Peeked Elements ");
    for (int i = 0; i < 10; i++) {
      System.out.print(queue.peek()+ " ");
    }

    for (int i = 0; i < queue.getCurrentSize() - k; i++) {
      queue.enqueue(queue.dequeue());
    }
  }
}
