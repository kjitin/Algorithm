package com.jitin.junit.udemy;

import java.util.Stack;

public class DoublyLinkedList<T> {

  class Node {
    T data;

    Node prev;
    Node next;

    public Node(T data) {
      this.data = data;
    }
  }

  private Node head;
  private Node tail;
  private int length;

  public DoublyLinkedList(T data) {
    Node newNode = new Node(data);
    head = newNode;
    tail = newNode;
    length = 1;
  }


  public Node getHead() {
    return head;
  }

  public Node getTail() {
    return tail;
  }

  public int getLength() {
    return length;
  }

  public void printList() {
    Node temp = head;
    while(temp != null) {
      System.out.println(temp.data);
      temp = temp.next;
    }
  }

  public void append(T data) {
    Node newNode = new Node(data);

    if (head == null && tail == null) {
      head = newNode;
      tail = newNode;
    } else {
      tail.next = newNode;
      newNode.prev = tail;
      newNode.next = null;
      tail = newNode;
    }
    length++;
  }

  public Node removeLast() {

    if (head == null && tail == null)
      return null;

    Node temp = tail;
    if (length == 1) {
      head = null;
      tail = null;
    } else {
      tail = tail.prev;
      tail.next = null;
      temp.prev = null;
    }
    length--;
    return temp;
  }

  public void prepend(T data) {
    Node newNode = new Node(data);
    if (head == null && tail == null) {
      head = newNode;
      tail = newNode;
    } else {
      newNode.next = head;
      head.prev = newNode;
      head = newNode;
    }
    length++;
  }

  public Node removeFirst() {
    if (head == null  && tail == null) return null;

    Node temp = head;
    if (length == 1) {
      head = null;
      tail = null;
    } else {
      head = head.next;
      head.prev = null;
      temp.next = null;
    }
    length--;
    return temp;
  }

  public Node get(int index) {
    if (index <0 || index > length) return null;

    Node temp = head;
    if (index < length/2) {
      for (int i = 0; i < index; i++) {
        temp = temp.next;
      }
    } else {
      temp = tail;
      for (int i = length -1; i > index ; i--) {
        temp = temp.prev;
      }
    }
    return temp;
  }

  public boolean set(int index, T data) {
    Node temp = get(index);
    if (temp != null) {
      temp.data = data;
      return true;
    }
    return false;
  }

  public boolean insert(int index, T data) {
    if (index < 0 || index > length) {
      return false;
    }
    if (index == 0) {
      prepend(data);
      return true;
    }
    if (index == length) {
      append(data);
      return true;
    }
    Node newNode = new Node(data);
    Node before = get(index -1);
    Node after = before.next;

    before.next = newNode;
    newNode.prev = before;
    newNode.next = after;
    after.prev = newNode;
    length++;
    return true;
  }

  public Node remove(int index) {
    if (index <0 || index >= length) return null;

    if (index ==0) return removeFirst();
    if (index == length -1) return removeLast();

    Node temp = get(index);
    Node before = temp.prev;
    Node after = temp.next;
    before.next = after;
    after.prev = before;
    temp.prev = null;
    temp.next = null;
    return temp;
  }

  public static void main(String[] args) {
    DoublyLinkedList<Integer> doublyLinkedList = new DoublyLinkedList(1);
    doublyLinkedList.append(3);
    doublyLinkedList.insert(1, 2);
    doublyLinkedList.printList();
    doublyLinkedList.remove(1);
    doublyLinkedList.printList();

  }
}
