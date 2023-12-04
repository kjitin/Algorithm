package com.jitin.junit.leetcode;

public class GoodNodes {


  public static void main(String[] args) {
    TreeNode root = new TreeNode(5);
    root.left = new TreeNode(4);
    root.right = new TreeNode(8);

    TreeNode eleven = new TreeNode(11);
    TreeNode seven = new TreeNode(7);
    TreeNode two = new TreeNode(2);
    eleven.left = seven;
    eleven.right = two;
    root.left.left = eleven;
    System.out.println(goodNodes(root));
  }

  private static int goodNodes(TreeNode root) {

    return dfs(root, Integer.MIN_VALUE);
  }

  private static int dfs(TreeNode root, int maxSoFar) {
    if (root == null)
      return 0;

    int left = dfs(root.left, Math.max(maxSoFar, root.val));
    int right = dfs(root.right, Math.max(maxSoFar, root.val));
    int ans = left+right;
    if (root.val >= maxSoFar) {
      ans+=1;
    }
    return ans;
  }
}
