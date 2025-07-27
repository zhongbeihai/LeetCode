package com.search;

import structure.TreeNode;

public class LargestBSTTree_333 {
    int maxSize = 0;

    public int largestBSTSubtree(TreeNode root) {
        dfs(root);
        return maxSize;
    }

    public int[] dfs(TreeNode root){
        // {isBST, size, minValue, maxValue}
        if (root == null) return new int[]{1, 0, Integer.MAX_VALUE, Integer.MIN_VALUE};

        int[] left = dfs(root.left);
        int[] right = dfs(root.right);

        if (left[0] == 1 && right[0] == 1 && root.val > left[3] && root.val < right[2]){
            int min = Math.min(left[2], root.val);
            int max = Math.max(right[3], root.val);
            int size = left[1] + right[1] + 1;
            maxSize = Math.max(maxSize, size);

            return new int[]{1, size, min, max};
        }

        return new int[]{0, 0, 0 , 0};
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
