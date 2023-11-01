package com.jitin.junit.leetcode;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

public class RightSideView {


  public static void main(String[] args) {
    RightSideView rightSideView = new RightSideView();
    TreeNode root = new TreeNode(1, new TreeNode(2), new TreeNode(3));
    root.right.left = new TreeNode(4);
    root.right.right = new TreeNode(5);
    List<Integer> rightSideView1 = rightSideView.getRightSideView(root);
    System.out.println(rightSideView1);
  }

  /*  root
         1
        / \
      2    3
          /  \
         4    5


   */
  private List<Integer> getRightSideView(TreeNode root) {

    if (root == null) {
      return new ArrayList<>();
    }
    List<Integer> ans = new ArrayList<>();
    Queue<TreeNode> queue = new LinkedList<>();
    queue.add(root);

    while (!queue.isEmpty()) {
      int currentLength = queue.size();
      int prev = 0;
      for (int i = 0; i < currentLength; i++) {
        TreeNode node = queue.remove();
        prev = node.val;
        if (node.left != null) {
          queue.add(node.left);
        }
        if (node.right != null) {
          queue.add(node.right);
        }
      }
     ans.add(prev);
    }
    return ans;
  }
}
