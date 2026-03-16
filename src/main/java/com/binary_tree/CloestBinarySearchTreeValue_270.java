package com.binary_tree;

import structure.TreeNode;

public class CloestBinarySearchTreeValue_270 {
    private double diff = Integer.MAX_VALUE;
    private int val = Integer.MAX_VALUE;
    public int closestValue(TreeNode root, double target) {
        dfs(root, target);

        return val;
    }

    public void dfs(TreeNode root, double target){
        // return condition
        if (root == null) return;

        if (Math.abs(root.val - target) < diff || (Math.abs(root.val - target) == diff && root.val < val)){
            diff = Math.abs(root.val - target);
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
