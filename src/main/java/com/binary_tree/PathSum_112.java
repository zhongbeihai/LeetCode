package com.binary_tree;

import structure.TreeNode;
import sun.reflect.generics.tree.Tree;

public class PathSum_112 {
    public boolean hasPathSum(TreeNode root, int targetSum) {
        if(root == null) return false;
        return dfs(root, targetSum, 0);
    }

    public boolean dfs(TreeNode root, int targetSum, int curSum){
        boolean mark = false;
        if(curSum + root.val == targetSum && root.left == null && root.right == null){
            return true;
        }

        if(root.left != null) mark |= dfs(root.left, targetSum, curSum + root.val);
        if(root.right != null) mark |= dfs(root.right, targetSum, curSum + root.val);

        return mark;
    }
}
