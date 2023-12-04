package com.jitin.junit.educative;

public class QueueWithStack2<V> {

  Stack<V> stack1;
  Stack<V> stack2;

  public QueueWithStack2(int maxSize) {
    stack1 = new Stack<>(maxSize);
    stack2 = new Stack<>(maxSize);
  }

  public boolean isEmpty() {
    return stack1.isEmpty() && stack2.isEmpty();
  }

  public void enqueue(V data) {
    stack1.push(data);
  }

  public V dequeue() {
    if (isEmpty()) {
      return null;
    } else if (stack2.isEmpty()) {
      while (!stack1.isEmpty()) {
        stack2.push(stack1.pop());
      }
      return stack2.pop();
    } else {
      return stack2.pop();
    }
  }

  public static void main(String[] args) {
    QueueWithStack2<Integer> queue = new QueueWithStack2<>(5);
    queue.enqueue(1);
    queue.enqueue(2);
    queue.enqueue(3);
    System.out.println(queue.dequeue());
    queue.enqueue(4);
    System.out.println(queue.dequeue());
  }
}
