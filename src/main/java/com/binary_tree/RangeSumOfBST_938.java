package com.binary_tree;

import structure.TreeNode;

public class RangeSumOfBST_938 {
    public int rangeSumBST(TreeNode root, int low, int high) {
        if (root == null) return 0;

        int left = rangeSumBST(root.left, low, high);
        int right = rangeSumBST(root.right, low, high);

        if (root.val >= low && root.val <= high) return left + right + root.val;
        else return left + right;
    }

}
