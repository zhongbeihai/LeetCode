package com.binary_tree;


import structure.TreeNode;

public class BinaryTreeMaximumPath_124 {
    private int globalMax = Integer.MIN_VALUE;
    public int maxPathSum(TreeNode root) {
        globalMax = Math.max(globalMax, dfs(root));
        return globalMax;
    }

    public int dfs(TreeNode root){
        // return condition
        if (root == null) return 0;

        int left = Math.max(dfs(root.left), 0);
        int right = Math.max(dfs(root.right), 0);

        // compute the sum if the root is part of the path
        globalMax = Math.max(globalMax, left + right + root.val);
        return Math.max(left, right) + root.val;
    }
}
