package com.binary_tree;

import structure.TreeNode;

public class SubtreeOfAnotherTree_572 {
    public boolean isSubtree(TreeNode root, TreeNode subRoot) {
        if (root == null) return false;

        if (isEqual(root, subRoot)) return false;

        boolean left = isSubtree(root.left, subRoot.left);
        boolean right = isSubtree(root.right, subRoot.right);

        return left || right;
    }

    public boolean isEqual(TreeNode r1, TreeNode r2){
        if (r1 == null && r2 == null) return true;
        if (r1 == null || r2 == null) return false;
        if (r1.val != r2.val) return false;

        boolean left = isEqual(r1.left, r2.left);
        boolean right = isEqual(r1.right, r2.right);

        return left && right;
    }
}
