package com.jitin.junit;


class Node {
    long value;
    Node left;
    Node right;

    Node(long value) {
        this.value = value;
        left = null;
        right = null;
    }
}

class BinaryTree {
    public Node root;

    public void add(long value) {
        root = addRecursively(root,value);
    }

    private Node addRecursively(Node current, long value) {

        if(current == null) {
            return new Node(value);
        }
        if(value < current.value) {
            current.left = addRecursively(current.left,value);
        } else if (value > current.value) {
            current.right = addRecursively(current.right, value);
        } else {
            return current;
        }
        return current;
    }

   public long calculateSumLeft(Node temp) {

        long mySum, sumLeft = 0;
        if (temp == null) {
            return 0;
        } else {
            sumLeft = calculateSumLeft(temp.left);
            mySum = temp.value + sumLeft;
        }

        return sumLeft;

   }
    public long calculateSumRight(Node temp) {

        long mySum,sumRight = 0;
        if (temp == null) {
            return 0;
        } else {
            sumRight = calculateSumRight(temp.right);
        }

        return sumRight;

    }
}

class Solution1 {

    public static void main(String[] args) {
        Solution1 solution = new Solution1();
        long[] intArray = new long[] {3,6,2,9,-1, 10};
        solution(intArray);
    }
    public static String solution(long[] arr) {
        BinaryTree bt = new BinaryTree();

        for(int i=0; i< arr.length; i++) {
            bt.add(arr[i]);
        }
        if(bt.calculateSumLeft(bt.root) > bt.calculateSumRight(bt.root)) {
            return "Left";
        } else if (bt.calculateSumLeft(bt.root) < bt.calculateSumRight(bt.root)) {
            return "Right";
        }
        return "";
    }
}

