package com.jitin.junit.educative;

public class DoublyLinkedList<T> {

  public class Node {
    public T data;
    public Node nextNode;
    public Node prevNode;
  }

  public Node headNode;
  public Node tailNode;
  public int size;

  public DoublyLinkedList() {
    this.headNode = null;
  }

  public Node getHeadNode() {
    return headNode;
  }

  public void setHeadNode(Node headNode) {
    this.headNode = headNode;
  }

  public Node getTailNode() {
    return tailNode;
  }

  public void setTailNode(Node tailNode) {
    this.tailNode = tailNode;
  }

  public boolean isEmpty() {
    if (headNode == null && tailNode == null)
      return true;
    return false;
  }

  public void insertAtHead(T data) {
    Node newNode = new Node();
    newNode.data = data;
    newNode.prevNode = null;
    newNode.nextNode = headNode;

    if (!isEmpty())
      headNode.prevNode = newNode;
    else
      tailNode = newNode;
    headNode = newNode;
    size++;

  }

  public void printList() {
    if (isEmpty()) {
      System.out.println("List is Empty!");
      return;
    }

    Node temp = headNode;
    System.out.print("List : null <- ");

    while (temp.nextNode != null) {
      System.out.print(temp.data.toString() + " <-> ");
      temp = temp.nextNode;
    }

    System.out.println(temp.data.toString() + " -> null");
  }

  public void deleteAtHead() {
    if (isEmpty()) return;
    headNode = headNode.nextNode;
    if (headNode == null)
      tailNode = null;
    else
      headNode.prevNode =null;
    size--;
  }

  public void deleteAtTail() {
    if (isEmpty()) return;
    tailNode= tailNode.prevNode;
    if (tailNode == null)
      headNode = null;
    else
      tailNode.nextNode = null;
    size--;
  }

  public void insertAtEnd(T data) {
    if (isEmpty()) {
      insertAtHead(data);
      return;
    }
    Node newNode = new Node();
    newNode.data = data;
    newNode.nextNode = null;
    newNode.prevNode = tailNode;
    tailNode.nextNode = newNode;
    tailNode = newNode;
    size++;
  }

  public void deleteByValue(T data) {
    Node currentNode = this.headNode;

    if (currentNode.data.equals(data)) {
      deleteAtHead();
      return;
    }

    while (currentNode != null) {

      if (currentNode.data.equals(data)) {
        currentNode.prevNode.nextNode = currentNode.nextNode;
        if (currentNode.nextNode != null) {
          currentNode.nextNode.prevNode = currentNode.prevNode;
        }
        size--;
      }
      currentNode = currentNode.nextNode;
    }
  }

  public static void main(String[] args) {
    DoublyLinkedList<Integer> dll = new DoublyLinkedList<>();
    dll.insertAtHead(1);
    dll.insertAtEnd(2);
    dll.insertAtEnd(3);
    dll.printList();
  }
}
