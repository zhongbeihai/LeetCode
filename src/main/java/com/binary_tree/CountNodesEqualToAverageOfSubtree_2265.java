package com.binary_tree;

import structure.TreeNode;

public class CountNodesEqualToAverageOfSubtree_2265 {
    private int res = 0;
    public int averageOfSubtree(TreeNode root) {
        helper(root);

        return res;
    }

    public int[] helper(TreeNode root){
        if (root == null) return new int[]{0, 0}; // {sum, cnt}

        int[] leftSum = helper(root.left);
        int[] rightSum = helper(root.right);

        int sum = leftSum[0] + rightSum[0] + root.val;
        int cnt = leftSum[1] + rightSum[1] + 1;

        if (sum / cnt == root.val) res++;

        return new int[]{sum, cnt};
    }

    public static void main(String[] args) {
        CountNodesEqualToAverageOfSubtree_2265 c = new CountNodesEqualToAverageOfSubtree_2265();
        TreeNode root = new TreeNode(1);
        c.averageOfSubtree(root);
    }
}
