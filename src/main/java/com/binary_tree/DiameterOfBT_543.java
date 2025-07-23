package com.binary_tree;

import structure.TreeNode;

public class DiameterOfBT_543 {
    private int maxx = Integer.MIN_VALUE;

    public int diameterOfBinaryTree(TreeNode root) {
        dfs(root);
        return maxx;
    }

    public int dfs(TreeNode root){
        if (root == null) return 0;

        int left = dfs(root.left);
        int right = dfs(root.right);

        maxx = Math.max(maxx, left + right + 1);

        return Math.max(left + 1, right + 1);
    }
}
