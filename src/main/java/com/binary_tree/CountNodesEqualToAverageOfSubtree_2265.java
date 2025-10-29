package com.binary_tree;

import structure.TreeNode;

public class CountNodesEqualToAverageOfSubtree_2265 {
    private int res = 0;
    public int averageOfSubtree(TreeNode root) {
        dfs(root);

        return res;
    }

    public int[] dfs(TreeNode root){

        int[] left = new int[]{0, 0};
        int[] right = new int[]{0, 0};

        if (root.left != null) left = dfs(root.left);
        if (root.right != null) right = dfs(root.right);

        if ((left[0] + right[0] + root.val) / (left[1] + right[1] + 1) == root.val) res++;

        return new int[]{left[0] + right[0] + root.val, left[1] + right[1] + 1};
    }



    public static void main(String[] args) {
        CountNodesEqualToAverageOfSubtree_2265 c = new CountNodesEqualToAverageOfSubtree_2265();
        TreeNode root = new TreeNode(1);
        c.averageOfSubtree(root);
    }
}
