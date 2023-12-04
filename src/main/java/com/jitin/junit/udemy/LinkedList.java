package com.jitin.junit.udemy;

public class LinkedList<T> {

  private Node<T> head;
  private Node<T> tail;
  private int length;

  public LinkedList(T data) {
    Node<T> newNode = new Node<T>(data);
    head = newNode;
    tail = newNode;
    length = 1;
  }

  public Node<T> getHead() {
    return head;
  }

  public Node<T> getTail() {
    return tail;
  }

  public int getLength() {
    return length;
  }


  public void append(T data) {
    Node<T> newNode = new Node<T>(data);

    if (head == null && tail == null) {
      head = newNode;
      tail = newNode;
    } else {
      tail.next = newNode;
      tail = newNode;
      newNode.next = null;
    }
    length++;
  }

  public Node<T> removeLast() {

    if (head == null && tail == null)
      return null;
    else {
      Node<T> prev = head;
      Node<T> temp = head;

      while (temp.next !=null) {
        prev = temp;
        temp = temp.next;
      }
      tail = prev;
      tail.next = null;
      length --;
      if (length == 0) {
        head = null;
        tail  = null;
      }
      return temp;
    }
  }

  public void prepend(T data) {
    Node<T> newNode = new Node<T>(data);
    if (head == null && tail == null) {
      head = newNode;
      tail = newNode;
    } else {
      newNode.next = head;
      head = newNode;
    }
  }

  public Node<T> removeFirst() {
    if (head == null && tail == null) {
      return null;
    } else {
      Node<T> temp =head;
      head = head.next;
      temp.next = null;
      length--;
      if (length ==0) {
        tail = null;
      }
      return temp;
    }
  }

  public Node<T> remove(int index) {
    if (index < 0 || index > length) return null;

    if (index == 0) {
      return removeFirst();
    }
    if (index == length -1) {
      return removeLast();
    }

    Node<T> prev = get(index -1);
    Node<T> temp = prev.next;
    prev.next = temp.next;
    temp.next = null;
    length--;
    return temp;

  }

  public Node<T> get(int index) {
    if (index < 0 || index > length) {
      return null;
    } else {
      Node<T> temp = head;
      for (int i = 0; i < index; i++) {
        temp = temp.next;
      }
      return temp;
    }
  }

  public boolean set(int index, T data) {
    Node<T> temp = get(index);
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

    Node<T> newNode = new Node<T>(data);
    Node<T> temp = get(index -1);
    if (temp != null) {
      newNode.next = temp.next;
      temp.next = newNode;
    }
    length++;
    return true;
  }

  public void reverse() {


    Node<T> temp = head;
    head = tail;
    tail = temp;

    Node<T> after;
    Node<T> before = null;
    for (int i = 0; i < length; i++) {
      after = temp.next;
      temp.next = before;
      before = temp;
      temp = after;
    }
  }

  public void printList() {
    Node temp = head;

    while (temp != null) {
      System.out.println(temp.data);
      temp = temp.next;
    }
  }
}
