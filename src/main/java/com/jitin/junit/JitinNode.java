package com.jitin.junit;

public class JitinNode<E> {

    private E element;
    private JitinNode<E> next;

    public JitinNode(){
        this(null, null);
    }

    public JitinNode(E element, JitinNode next) {
        this.element = element;
        this.next = next;
    }

    public E getElement() {
        return element;
    }

    public JitinNode<E> getNext() {
        return next;
    }

    public void setElement(E element) {
        this.element = element;
    }

    public void setNext(JitinNode<E> next) {
        this.next = next;
    }

    @Override
    public String toString() {
        if (getNext() !=null) {
            return (String) "["+getElement()+ "][.next] -> ";
        }
        return (String)"["+getElement()+ "][.next] -> "+getNext();

    }
}
