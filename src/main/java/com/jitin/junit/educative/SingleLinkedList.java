package com.jitin.junit.educative;

public class SingleLinkedList<T> {

  public class Node {

    T data;
    Node next;
  }

  public Node headNode;
  public int size;

  public SingleLinkedList() {
    headNode = null;
    size =0;
  }

  public boolean isEmpty() {
    return headNode == null;
  }

  public void insertAtHead(T data) {
    Node newNode = new Node();
    newNode.data = data;
    newNode.next = headNode;
    headNode = newNode;
    size++;
  }

  public void insertAtEnd(T data) {
    if (isEmpty()) {
      insertAtHead(data);
      return;
    }
    Node newNode = new Node();
    newNode.data = data;
    newNode.next = null;
    Node last = headNode;
    while (last.next != null) {
      last = last.next;
    }
    last.next = newNode;
  }

  public void insertAfter(T data, T previous) {

    Node currentNode = headNode;
    Node newNode = new Node();
    newNode.data = data;

    while (currentNode != null && !(currentNode.data.equals(previous))) {
      currentNode = currentNode.next;
    }
    if (currentNode != null) {
      newNode.next = currentNode.next;
      currentNode.next = newNode;
      size++;
    }
  }

  public boolean searchNode(T data) {
    Node searchNode = headNode;

    while (searchNode.next != null) {
      if(searchNode.data == data) {
        return true;
      }
      searchNode = searchNode.next;
    }
    return false;
  }

  public void deleteAtHead() {
    if (isEmpty()) return;

    headNode = headNode.next;
    size-- ;

  }

  public void deleteByValue(T data) {

    Node currentNode = this.headNode;
    Node previousNode = null;

    if(currentNode.data.equals(data)) {
      deleteAtHead();
      return;
    }

    while (currentNode != null) {

      if (currentNode.data.equals(data) && previousNode != null) {
        previousNode.next = currentNode.next;
        size-- ;
        return;
      }
      previousNode =  currentNode;
      currentNode = currentNode.next;

    }

  }

  public void printList() {
    if (isEmpty()) {
      System.out.println("List is Empty!");
      return;
    }

    Node temp = headNode;
    System.out.print("List : ");
    while (temp.next != null) {
      System.out.print(temp.data.toString() + " -> ");
      temp = temp.next;
    }
    System.out.println(temp.data.toString() + " -> null");
  }

  public static void main(String[] args) {
    SingleLinkedList<Integer> sll = new SingleLinkedList<Integer>();
    sll.printList();
    for (int i = 1; i <= 10; i++) {
      sll.insertAtHead(i);
      sll.printList();
    }
    sll.insertAtEnd(11);
    sll.printList();
    sll.insertAfter(15,5);
    sll.printList();
    System.out.println("Node found " +sll.searchNode(10));
    sll.deleteByValue(7);
    sll.printList();
  }
}
