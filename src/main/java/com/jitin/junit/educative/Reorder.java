package com.jitin.junit.educative;

import java.util.Arrays;
import java.util.List;

public class Reorder {

  public static LinkedListNode reorderList(LinkedListNode head)
  {
    if(head == null)
      return head;
    // find the middle of linked list
    // in 1->2->3->4->5->6 find 4
    LinkedListNode slow = head;
    LinkedListNode fast = head;

    while(fast!= null && fast.next != null)
    {
      slow = slow.next;
      fast = fast.next.next;
    }
    // reverse the second part of the list
    // convert 1->2->3->4->5->6 into 1->2->3 and 6->5->4
    // reverse the second half in-place
    LinkedListNode prev = null;
    LinkedListNode curr = slow;
    LinkedListNode next = null;

    while(curr != null)
    {
      next = curr.next;
      curr.next = prev;
      prev = curr;
      curr = next;
    }
    // merge two sorted linked lists
    // merge 1->2->3 and 6->5->4 into 1->6->2->5->3->4
    LinkedListNode first = head;
    LinkedListNode second = prev;
    LinkedListNode temp = head;

    while(second.next != null)
    {
      temp = temp.next;
      first.next = second;
      second = second.next;
      first.next.next = temp;
      first = first.next.next;
    }

    return head;
  }

  public static void main(String[] args) {
    // Declaring and creating a linked list
    LinkedList obj1 = new LinkedList();
    List<Integer> inputList = Arrays.asList(1,2,3,4,5,6);
    // Creating Linked Lists
    obj1.createLinkedList(inputList);
    // Displaying original linked list
    System.out.print("1.\tOrignal list: ");
    PrintList.printListWithForwardArrow(obj1.head);
    // Calling the reorder_list function
    reorderList(obj1.head);
    // Displaying modified linked list
    System.out.print("\tAfter folding: ");
    PrintList.printListWithForwardArrow(obj1.head);

    // Declaring and creating a linked list
    LinkedList obj2 = new LinkedList();
    List<Integer> inputList1 = Arrays.asList(10, 20, -22, 21, -12);
    // Creating Linked Lists
    obj2.createLinkedList(inputList1);
    // Displaying original linked list
    System.out.print("2.\tOrignal list: ");
    PrintList.printListWithForwardArrow(obj2.head);
    // Calling the reorder_list function
    reorderList(obj2.head);
    // Displaying modified linked list
    System.out.print("\tAfter folding: ");
    PrintList.printListWithForwardArrow(obj2.head);

    // Declaring and creating a linked list
    LinkedList obj3 = new LinkedList();
    List<Integer> inputList2 = Arrays.asList(1, 1, 1);
    // Creating Linked Lists
    obj3.createLinkedList(inputList2);
    // Displaying original linked list
    System.out.print("3.\tOrignal list: ");
    PrintList.printListWithForwardArrow(obj3.head);
    // Calling the reorder_list function
    reorderList(obj3.head);
    // Displaying modified linked list
    System.out.print("\tAfter folding: ");
    PrintList.printListWithForwardArrow(obj3.head);


    // Declaring and creating a linked list
    LinkedList obj4 = new LinkedList();
    List<Integer> inputList3 = Arrays.asList(-2, -5, -6, 0, -1, -4);
    // Creating Linked Lists
    obj4.createLinkedList(inputList3);
    // Displaying original linked list
    System.out.print("4.\tOrignal list: ");
    PrintList.printListWithForwardArrow(obj4.head);
    // Calling the reorder_list function
    reorderList(obj4.head);
    // Displaying modified linked list
    System.out.print("\tAfter folding: ");
    PrintList.printListWithForwardArrow(obj4.head);

    // Declaring and creating a linked list
    LinkedList obj5 = new LinkedList();
    List<Integer> inputList4 = Arrays.asList(3, 1, 5, 7, -4, -2, -1, -6);
    // Creating Linked Lists
    obj5.createLinkedList(inputList4);
    // Displaying original linked list
    System.out.print("5.\tOrignal list: ");
    PrintList.printListWithForwardArrow(obj5.head);
    // Calling the reorder_list function
    reorderList(obj5.head);
    // Displaying modified linked list
    System.out.print("\tAfter folding: ");
    PrintList.printListWithForwardArrow(obj5.head);
  }
}
