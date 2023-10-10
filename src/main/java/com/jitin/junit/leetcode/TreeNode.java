package com.jitin.junit.leetcode;

public class TreeNode {

  int val;
  TreeNode left;
  TreeNode right;

  int target;
  TreeNode(){}

  TreeNode(int val) {
    this.val = val;
  }

  TreeNode(int val, TreeNode left, TreeNode right) {
    this.val = val;
    this.left = left;
    this.right = right;
  }

  public void setTarget(int target) {
    this.target = target;
  }

  public int maxDepth(TreeNode root) {

    if (root == null) {
      return 0;
    }

    int left = maxDepth(root.left);
    int right = maxDepth(root.right);

    return Math.max(left, right) + 1;

  }

  public boolean hasSum(TreeNode root, int targetSum) {
    target = targetSum;
    return dfs(root, 0);
  }

  private boolean dfs(TreeNode root, int current) {

    if (root == null) {
      return false;
    }
    if(root.left == null && root.right == null) {
      return current+root.val == target;
    }

    current = current+ root.val;
    boolean left = dfs(root.left, current);
    boolean right = dfs(root.right, current);

    return left || right;

  }

  public static void main(String[] args) {
    /*
         0
        / \
       1    2
             \
              3
             /
            4
     */
    TreeNode root = new TreeNode(0, new TreeNode(1), new TreeNode(2));
    TreeNode leftOf3 = new TreeNode(4);
    root.right.right = new TreeNode(3, leftOf3, null);
    System.out.println(root.left.val);
    System.out.println(root.right.val);
    System.out.println(root.right.right.val);
    System.out.println(root.maxDepth(root));
    System.out.println(root.hasSum(root, 9));
    System.out.println(root.hasSum(root, 3));
  }
}
