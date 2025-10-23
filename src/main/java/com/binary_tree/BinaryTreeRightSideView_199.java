package com.binary_tree;

import structure.TreeNode;

import java.util.*;

public class BinaryTreeRightSideView_199 {
    public List<Integer> rightSideView(TreeNode root){
        if (root == null) return new ArrayList<>();

        List<Integer> res = new ArrayList<>();
        postOrder(root, 0, res);

        return res;
    }

    public void postOrder(TreeNode root, int level, List<Integer> res){
        if (root == null) return;

        if (level == res.size()) res.add(root.val);

        postOrder(root.right, level + 1, res);
        postOrder(root.left, level + 1, res);
    }
}
