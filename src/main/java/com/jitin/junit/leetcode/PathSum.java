package com.jitin.junit.leetcode;

public class PathSum {

  static int target;
  public static void main(String[] args) {
    TreeNode five = new TreeNode(5);
    TreeNode four = new TreeNode(4);
    TreeNode eleven = new TreeNode(11);
    TreeNode seven = new TreeNode(7);
    TreeNode two = new TreeNode(2);
    TreeNode eight = new TreeNode(8);

    five.left = four;
    five.right = eight;
    four.left = eleven;
    eleven.left = seven;
    eleven.right = two;

    hasPathSum(five, 22);
  }

  private static boolean hasPathSum(TreeNode root, int targetSum) {
    target = targetSum;
    return dfs(root,0);
  }

  private static boolean dfs(TreeNode node, int curr) {
    if (node == null) {
      return false;
    }

    if (node.left == null && node.right == null) {
      return (curr + node.val) == target;
    }

    curr += node.val;
    boolean left = dfs(node.left, curr);
    boolean right = dfs(node.right, curr);
    return left || right;
  }
}
