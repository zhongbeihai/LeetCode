package com.binary_tree;

import structure.TreeNode;

public class SumRootToLeafNumbers_129 {
    private int sum = 0;
    public int sumNumbers(TreeNode root) {
        dfs(root, new StringBuilder());

        return sum;
    }

    public void dfs(TreeNode root, StringBuilder cur){
        cur.append(root.val);
        if (root.left == null && root.right == null){
            sum += Integer.parseInt(cur.toString());
            return;
        }

        if (root.left != null) dfs(root.left, new StringBuilder(cur));
        if (root.right != null) dfs(root.right, new StringBuilder(cur));
    }

    public static void main(String[] args) {
        SumRootToLeafNumbers_129 s = new SumRootToLeafNumbers_129();
        TreeNode t1 = new TreeNode(1);
        t1.left = new TreeNode(2);
        t1.right = new TreeNode(3);

        s.sumNumbers(t1);
    }

}
