package com.jitin.junit.udemy;

public class Main {

  public static void main(String[] args) {
    BinarySearchTree binarySearchTree = new BinarySearchTree(false);


    binarySearchTree.insert(47);
    binarySearchTree.insert(21);
    binarySearchTree.insert(76);
    binarySearchTree.insert(18);
    binarySearchTree.insert(52);
    binarySearchTree.insert(81);

    binarySearchTree.insert(27);

    System.out.println(binarySearchTree.root.left.right.value);

    System.out.println(binarySearchTree.contains(27));
    System.out.println(binarySearchTree.contains(15));
  }
}
