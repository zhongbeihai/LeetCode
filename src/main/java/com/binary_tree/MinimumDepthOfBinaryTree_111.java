package com.binary_tree;

import structure.TreeNode;

public class MinimumDepthOfBinaryTree_111 {
    public int minDepth(TreeNode root) {
        if (root == null) return 0;
        return dfs(root, 1);
    }

    public int dfs(TreeNode root, int depth){
        if (root.left == null && root.right == null) return depth;

        int l = Integer.MAX_VALUE, r = Integer.MAX_VALUE;
        if (root.left != null) l =  dfs(root.left, depth + 1);
        if (root.right != null) r  = dfs(root.right, depth + 1);

        return Math.min(l, r);
    }
}
