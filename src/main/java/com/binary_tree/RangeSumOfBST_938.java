package com.binary_tree;

import structure.TreeNode;

public class RangeSumOfBST_938 {
    public int rangeSumBST(TreeNode root, int low, int high) {
        if (root == null) return 0;

        int sum = 0;
        sum += rangeSumBST(root.left, low, high);
        sum += rangeSumBST(root.right, low, high);

        if (root.val >= low && root.val <= high) sum += root.val;

        return sum;
    }

}
