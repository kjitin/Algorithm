package com.jitin.junit.educative;

import java.util.List;

public class LinkedList {

  public LinkedListNode head;

  public LinkedList() {
    this.head = null;
  }

  public void insertNodeAtHead(LinkedListNode node) {
    if (this.head == null) {
      this.head = node;
    } else {
      node.next = this.head;
      this.head = node;
    }
  }

  public void createLinkedList(List<Integer> lst) {
    for (int i = lst.size() - 1; i >= 0; i--) {
      LinkedListNode newNode = new LinkedListNode(lst.get(i));
      insertNodeAtHead(newNode);
    }
  }
}
