package com.binary_tree;


import structure.TreeNode;

public class BinaryTreeMaximumPath_124 {
    private int globalMax = Integer.MIN_VALUE;
    public int maxPathSum(TreeNode root) {
        helper(root);
        return globalMax;
    }

    public int helper(TreeNode root){
        if (root == null) return 0;

        int l = Math.max(helper(root.left), 0);
        int r = Math.max(helper(root.right), 0);

        globalMax = Math.max(globalMax, l + r + root.val);

        return Math.max(l, r) + root.val;
    }
}
