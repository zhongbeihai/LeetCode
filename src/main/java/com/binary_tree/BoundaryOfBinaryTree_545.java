package com.binary_tree;

import structure.TreeNode;

import java.util.ArrayList;
import java.util.List;

public class BoundaryOfBinaryTree_545 {
    public List<Integer> boundaryOfBinaryTree(TreeNode root) {
        List<Integer> list = new ArrayList<>();
        list.add(root.val);
        if (root.left == null && root.right == null) return list;

        if (root.left != null) leftBoundary(root.left, list);
        leaves(root, list);
        if (root.right != null) rightBoundary(root.right, list);

        return list;
    }

    public void leftBoundary(TreeNode root, List<Integer> list){
        if (root.left != null || root.right != null){
            list.add(root.val);
        }

        if (root.left != null) leftBoundary(root.left, list);
        else if (root.right != null) leftBoundary(root.right, list);
    }

    public void leaves(TreeNode root, List<Integer> list){
        if (root == null) return;
        if (root.left == null && root.right == null){
            list.add(root.val);
            return;
        }

        leaves(root.left, list);
        leaves(root.right, list);
    }

    public void rightBoundary(TreeNode root, List<Integer> list){
        if (root.right != null) rightBoundary(root.right, list);
        else if (root.left != null) rightBoundary(root.left, list);

        if (root.left != null || root.right != null){
            list.add(root.val);
        }
    }
}
