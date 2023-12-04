package com.jitin.junit.udemy;

import java.util.ArrayList;
import java.util.List;
import java.util.Stack;
import java.util.Queue;
import java.util.LinkedList;

public class BinarySearchTree {

  Node root;
  boolean isRecursive;

  class Node {
    int value;
    Node left;
    Node right;

    private Node(int value) {
      this.value = value;
    }
  }

  public BinarySearchTree(boolean isRecursive) {
    this.isRecursive = isRecursive;
  }

  public boolean insert(int value) {
   if (isRecursive) {
     recursiveInsert(value);
     return true;
   } else {
     Node newNode = new Node(value);
     if (root == null) {
       root = newNode;
       return true;
     }
     Node temp = root;
     while (true) {
       if (newNode.value == temp.value) {
         return false;
       }

       if (newNode.value < temp.value) {
         if (temp.left == null) {
           temp.left = newNode;
           return true;
         }
         temp = temp.left;
       } else {
         if (temp.right == null) {
           temp.right = newNode;
           return true;
         }
         temp = temp.right;
       }
     }
   }
   }

  private void recursiveInsert(int value) {
    recursiveInsert(root, value);
  }

  private Node recursiveInsert(Node root, int value) {
    if (root == null) {
      return new Node(value);
    }
    if (value < root.value) {
      return root.left = recursiveInsert(root.left, value);
    } else if(value > root.value) {
      return root.right = recursiveInsert(root.right, value);
    }
    return root;
  }

  private void recursiveDelete(int value) {
    recursiveDelete(root, value);
  }

  private Node recursiveDelete(Node root, int value) {
    if (root == null) {
      return null;
    }

    if (value < root.value) {
      return root.left = recursiveDelete(root.left, value);
    } else if (value > root.value) {
      return root.right = recursiveDelete(root.right, value);
    } else {
      if (root.left == null && root.right == null) {
        return null;
      } else if (root.left == null) {
        root = root.right;
      } else if (root.right == null) {
        root = root.left;
      } else {
        int subTreeMin  = minValue(root.right);
        root.value = subTreeMin;
        root.right = recursiveDelete(root.right, subTreeMin);
      }
    }
    return root;
  }

  public int minValue(Node currentNode) {
    while (currentNode.left != null) {
      currentNode = currentNode.left;
    }
    return currentNode.value;
  }

  public boolean contains(int value){

    if (root == null) {
      return false;
    }
    Node temp =root;

    while (temp != null) {
      if (value < temp.value) {
        temp = temp.left;
      } else if(value > temp.value) {
        temp = temp.right;
      } else {
        return true;
      }
    }
    return false;
   }

   public List<Integer> BFS() {
    Node currentNode = root;
     List<Integer> results = new ArrayList<>();
     Queue<Node> queue = new LinkedList<>();
     queue.add(currentNode);

     while (!queue.isEmpty()) {
       currentNode = queue.remove();
       results.add(currentNode.value);
       if (currentNode.left != null) {
         queue.add(currentNode.left);
       }
       if (currentNode.right != null) {
         queue.add(currentNode.right);
       }
     }
     return results;
   }

   public List<Integer> preOrderDFS() {
    List<Integer> results = new ArrayList<>();

    class Traverse {
      Traverse(Node currentNode) {
        results.add(currentNode.value);
        if (currentNode.left != null) {
          new Traverse(currentNode.left);
        }
        if (currentNode.right != null) {
          new Traverse(currentNode.right);
        }
      }
    }
    new Traverse(root);
    return results;
   }

  public Integer kthSmallest(int k) {
    Stack<Node> stack = new Stack<>();
    Node node = this.root;

    while (!stack.isEmpty() || node != null) {
      while (node != null) {
        stack.push(node);
        node = node.left;
      }
      node = stack.pop();
      k -= 1;
      if (k == 0) {
        return node.value;
      }
      node = node.right;
    }
    return null;
  }

  public static void main(String[] args) {
    BinarySearchTree bst = new BinarySearchTree(false);

    bst.insert(5);
    bst.insert(3);
    bst.insert(7);
    bst.insert(2);
    bst.insert(4);
    bst.insert(6);
    bst.insert(8);

    System.out.println(bst.kthSmallest(3));
  }

  }
