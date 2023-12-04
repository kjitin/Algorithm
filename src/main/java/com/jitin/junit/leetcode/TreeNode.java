package com.jitin.junit.leetcode;

import java.util.Arrays;
import java.util.Collections;

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

  public int maxAncestorDiff(TreeNode root) {
    if (root == null) {
      return 0;
    }
    return helper(root, root.val, root.val);
  }

  public int helper(TreeNode node, int curMax, int curMin) {
    // if encounter leaves, return the max-min along the path
    if (node == null) {  // 1. node.val =3 | 2. node.val =8 | 3.null | 4. null | 5. node.val =5
      return curMax - curMin; // 1. 8-3 = 5 | 2. 8 -3 = 5 | 3. 8-3 =5 | 4. 8-3=5 | 5.
    }
    // else, update max and min
    // and return the max of left and right subtrees
    curMax = Math.max(curMax, node.val);  // 1. curMax=Math.max(3,3)= 3 | curMax=Math.max(3, 8)= 8| curMax = Math.max(3,5) = 5
    curMin = Math.min(curMin, node.val);  // 1. curMin=Math.min(3,3,)= 3 | curMin=Math.min(3,8) = 3| curMin=Math.min(3,5) = 3
    int left = helper(node.left, curMax, curMin); // 1.helper --> stack left | 2.helper --> stack left --> stack left| 3.helper -->stack left =5 pop X | 5. helper  reaches top node |
    int right = helper(node.right, curMax, curMin); // 1.helper --> stack left =5 --> stack -->right|2.helper --> stack left =5 --> stack -->right| 4. helper --> stack left =5 --> pop X right =5 | 6. helper --> stack right
    return Math.max(left, right); // 1. 5 |
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
    /*  root
         1
        / \
       3    2
             \
              5
             /
            4

        secondRoot
          3
         / \
        8   5
     */
    TreeNode root = new TreeNode(1, new TreeNode(3), new TreeNode(2));
    TreeNode leftOf5 = new TreeNode(4);
    root.right.right = new TreeNode(5, leftOf5, null);
    System.out.println(root.left.val);
    System.out.println(root.right.val);
    System.out.println(root.right.right.val);
    System.out.println(root.maxDepth(root));
    System.out.println(root.hasSum(root, 9));
    System.out.println(root.hasSum(root, 3));

    TreeNode secondRoot = new TreeNode(3, new TreeNode(8), new TreeNode(5));
    System.out.println(root.maxAncestorDiff(root));
    System.out.println(secondRoot.maxAncestorDiff(secondRoot));
    System.out.println("Max Depth "+secondRoot.maxDepth(secondRoot));
  }
}
