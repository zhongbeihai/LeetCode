package com.binary_tree;

import structure.TreeNode;

import java.util.ArrayList;
import java.util.List;

public class BinaryTreePath_257 {
    private List<String> res = new ArrayList<>();
    public List<String> binaryTreePaths(TreeNode root) {
        if (root == null) return new ArrayList<>();
        if (root.left == null && root.right == null) {
            res.add(String.valueOf(root.val));
            return res;
        }
        dfs(root.left, String.valueOf(root.val));
        dfs(root.right, String.valueOf(root.val));
        return res;
    }

    public void dfs(TreeNode root, String sb){
        if (root == null) return;
        String s = sb + "->" + root.val;
        if (root.left == null && root.right == null) {
            res.add(s);
            return;
        }
        dfs(root.left, s);
        dfs(root.right, s);
    }
}
