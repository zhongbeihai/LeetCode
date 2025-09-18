package com.binary_tree;

import structure.TreeNode;
import sun.reflect.generics.tree.Tree;

public class BinaryTreeMaximumPath_124 {
    private int maximum = Integer.MIN_VALUE;
    public int maxPathSum(TreeNode root) {
        helper(root);
        return maximum;
    }

    public int helper(TreeNode root){
        if (root == null) return 0;

        int left = Math.max(helper(root.left), 0);
        int right = Math.max(helper(root.right), 0);

        maximum = Math.max(maximum, left + right + root.val);

        return Math.max(left, right) + root.val;
    }
}
