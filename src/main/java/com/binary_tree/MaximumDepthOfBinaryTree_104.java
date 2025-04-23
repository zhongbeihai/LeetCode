package com.binary_tree;

import structure.TreeNode;

public class MaximumDepthOfBinaryTree_104 {
    public int maxDepth(TreeNode root) {
        if (root == null) return 0;
        return dfs(root, 1);
    }

    public int dfs(TreeNode root, int count){
        int left = count, right = count;
        if (root.left != null) left = dfs(root.left, count + 1);
        if (root.right != null) right = dfs(root.right, count + 1);

        return Math.max(left, right);
    }
}
