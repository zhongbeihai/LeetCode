package com.binary_tree;

import structure.TreeNode;

import java.util.ArrayList;
import java.util.List;
import java.util.Stack;

public class BinaryTreeInorderTraversal_94 {
    public List<Integer> inorderTraversal(TreeNode root) {
        List<Integer> res = new ArrayList<>();
        stack(res, root);
        return res;
    }

    public void dfs(List<Integer> res, TreeNode root){
        if (root == null) return;

        dfs(res, root.left);
        res.add(root.val);
        dfs(res, root.right);
    }

    public void stack(List<Integer> res, TreeNode root){
        if (root == null) return;

        Stack<TreeNode> stack = new Stack<>();
        while (root != null || !stack.isEmpty()){
            while (root != null){
                stack.push(root);
                root = root.left;
            }
            root = stack.pop();
            res.add(root.val);

            root = root.right;
        }
    }
}
