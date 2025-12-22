package com.binary_tree;

import structure.TreeNode;

import java.util.ArrayDeque;
import java.util.Queue;

public class LowestCommonAncestorOfDeepestLeaves_1123 {
    public TreeNode lcaDeepestLeaves(TreeNode root) {
        int maxDepth = maxDepth(root);

        return dfs(root, 0, maxDepth);
    }

    public TreeNode dfs(TreeNode root, int cur, int maxDepth){
        if (root == null) return null;
        if (cur + 1 == maxDepth) return root;

        TreeNode left = dfs(root.left, cur + 1, maxDepth);
        TreeNode right = dfs(root.right, cur + 1, maxDepth);

        if (left != null && right != null) return root;
        return left == null ? right : left;
    }

    public int maxDepth(TreeNode root) {
        if (root == null) {
            return 0;
        }
        int leftDepth = maxDepth(root.left);
        int rightDepth = maxDepth(root.right);
        return Math.max(leftDepth, rightDepth) + 1;
    }

}
