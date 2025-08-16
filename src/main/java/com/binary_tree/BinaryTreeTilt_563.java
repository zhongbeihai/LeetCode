package com.binary_tree;

import structure.TreeNode;

public class BinaryTreeTilt_563 {
    private int sum = 0;
    public int findTilt(TreeNode root) {
        dfs(root);
        return sum;
    }

    public int dfs(TreeNode root){
        if (root == null) return 0;

        int left = dfs(root.left);
        int right = dfs(root.right);
        int nVal = Math.abs(left - right);
        this.sum += nVal;
        return root.val + left + right;
    }

    public static void main(String[] args) {
        BinaryTreeTilt_563 b = new BinaryTreeTilt_563();
        TreeNode root = new TreeNode(1);
        TreeNode n1 = new TreeNode(2);
        TreeNode n3 = new TreeNode(3);
        root.left = n1;
        root.right = n3;
        b.findTilt(root);
    }
}
