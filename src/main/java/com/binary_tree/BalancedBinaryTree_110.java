package com.binary_tree;

import structure.TreeNode;

public class BalancedBinaryTree_110 {
    private int maxDepthDiff = 0;
    public boolean isBalanced(TreeNode root) {
        subtreeDepthDiffs(root, 0);
        return maxDepthDiff <= 1;
    }

    public int subtreeDepthDiffs(TreeNode root, int depth){
        if (root == null) return 0;

        int left = subtreeDepthDiffs(root.left, depth + 1);
        int right = subtreeDepthDiffs(root.right, depth + 1);
        int diff = Math.abs(left - right);
        maxDepthDiff = Math.max(diff, maxDepthDiff);

        return Math.max(left, right) + 1;
    }


}
