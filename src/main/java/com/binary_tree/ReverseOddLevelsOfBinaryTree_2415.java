package com.binary_tree;

import structure.TreeNode;

public class ReverseOddLevelsOfBinaryTree_2415 {
    public TreeNode reverseOddLevels(TreeNode root) {
        if (root == null) return root;
        reverse(root.left, root.right, 0);
        return root;
    }

    public void reverse(TreeNode left, TreeNode right, int depth){
        if (left == null) return;

        if (depth % 2 == 1){
            int tem = left.val;
            left.val = right.val;
            right.val = tem;
        }

        reverse(left.left, right.right, depth + 1);
        reverse(left.right, right.left, depth + 1);
    }
}
