package com.search;

import structure.TreeNode;

public class LargestBSTTree_333 {
    int maxSize = 0;

    public int largestBSTSubtree(TreeNode root) {
        dfs(root);
        return maxSize;
    }

    public int[] dfs(TreeNode root){

    }

    public static void main(String[] args) {
        TreeNode root = new TreeNode(10);
        root.left = new TreeNode(5);
        root.right = new TreeNode(15);
        root.left.left = new TreeNode(1);
        root.left.right = new TreeNode(8);
        root.right.right = new TreeNode(7);

        LargestBSTTree_333 l = new LargestBSTTree_333();
        l.dfs(root);
    }
}
