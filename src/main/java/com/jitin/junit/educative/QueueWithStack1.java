package com.jitin.junit.educative;

public class QueueWithStack1<V> {
  Stack<V> stack1;
  Stack<V> stack2;

  public QueueWithStack1(int maxSize) {
    stack1 = new Stack<>(maxSize);
    stack2 = new Stack<>(maxSize);
  }

  public void enqueue(V value) {
    stack1.push(value);
  }

  public boolean isEmpty() {
    return stack1.isEmpty();
  }

  public V dequeue() {
    while (!stack1.isEmpty()) {
      stack2.push(stack1.pop());
    }
    V data = stack2.pop();

    while (!stack2.isEmpty()) {
      stack1.push(stack2.pop());
    }

    return data;
  }

  public static void main(String[] args) {
    QueueWithStack1<Integer> queue = new QueueWithStack1<>(5);
    queue.enqueue(1);
    queue.enqueue(2);
    queue.enqueue(3);
    System.out.println(queue.dequeue());
    queue.enqueue(4);
    System.out.println(queue.dequeue());

  }
}
