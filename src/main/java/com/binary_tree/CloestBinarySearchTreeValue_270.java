package com.binary_tree;

import structure.TreeNode;

public class CloestBinarySearchTreeValue_270 {
    private double diff;
    private int val;
    public int closestValue(TreeNode root, double target) {
        val = root.val;
        diff = Math.abs(root.val - target);

        dfs(root, target);
        return val;
    }

    public void dfs(TreeNode root, double target){
        if (root == null) return;

        double d = Math.abs(root.val - target);
        if (d < diff){
            diff = d;
            val = root.val;
        }

        dfs(root.left, target);
        dfs(root.right, target);
    }

    public static void main(String[] args) {
        CloestBinarySearchTreeValue_270 c = new CloestBinarySearchTreeValue_270();
        TreeNode root = new TreeNode(4);
        root.left = new TreeNode(3);

        c.closestValue(root, 3.428);
    }
}
