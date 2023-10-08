package com.jitin.junit;

public class JitinLinkedList<E> {

    JitinNode<E> head;


    public void insert(E data) {

        JitinNode<E> node = new JitinNode<>();
        node.setElement(data);
        node.setNext(null);
        if (head == null) {            head = node;


        } else {
            JitinNode<E> tmp = head;

            while (tmp.getNext() != null) {
                tmp = tmp.getNext();
            }
            tmp.setNext(node);
        }

    }

    public void show() {

        int count =1 ;
        JitinNode<E> tmp = head;
        while (tmp.getNext() !=null) {
            System.out.print(tmp);
            tmp = tmp.getNext();
            count++;
        }
        System.out.println(tmp);
        System.out.println(count);
    }


    public static void main(String[] args) {
        JitinLinkedList<String> linkedList = new JitinLinkedList<>();

        linkedList.insert("Jitin");
        linkedList.insert("Swetha");
        linkedList.insert("Samiksh");
        linkedList.show();
    }


}


