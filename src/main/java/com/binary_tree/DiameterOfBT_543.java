package com.binary_tree;

import structure.TreeNode;

public class DiameterOfBT_543 {
    private int maxDiameter = 0;
    public int diameterOfBinaryTree(TreeNode root) {
        dfs(root);
        return maxDiameter;
    }

    public int dfs(TreeNode root){
        if (root == null) return 0;

        int leftDepth = dfs(root.left);
        int rightDepth = dfs(root.right);
        maxDiameter = Math.max(maxDiameter, leftDepth + rightDepth);

        return Math.max(leftDepth, rightDepth) + 1;
    }
}
