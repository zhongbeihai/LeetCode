package com.binary_tree;

import structure.TreeNode;

public class ValidateBinarySearchTree_98 {
    public boolean isValidBST(TreeNode root) {
        return preOrder(root, Integer.MIN_VALUE, Integer.MAX_VALUE);
    }

    public boolean preOrder(TreeNode root, int min, int max){
        // return condition
        if (root == null) return true;

        if (root.val <= min || root.val >= max) return false;
        boolean left = preOrder(root.left, min, root.val);
        boolean right = preOrder(root.right, root.val, max);

        return left && right;
    }
}
