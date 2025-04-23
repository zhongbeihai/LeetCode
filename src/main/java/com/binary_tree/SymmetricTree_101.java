package com.binary_tree;

import structure.TreeNode;

public class SymmetricTree_101 {
    public boolean isSymmetric(TreeNode root) {
        if (root == null) return true;

        return symmetric(root.left, root.right);

    }

    public boolean symmetric(TreeNode left, TreeNode right){
        if (left == null && right == null) return true;
        else if (left == null || right == null) return false;

        if (left.val != right.val) return false;

        return symmetric(left.left, right.right) && symmetric(left.right, right.left);
    }
}
