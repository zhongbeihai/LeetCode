package com.binary_tree;

import structure.TreeNode;

import java.util.ArrayList;
import java.util.Deque;
import java.util.List;

public class BalancedBinarySearchTree_1382 {
    public TreeNode balanceBST(TreeNode root) {
        if (root == null) return root;

        List<Integer> sortedNode = new ArrayList<>();
        inorder(root, sortedNode);

        return build(sortedNode, 0, sortedNode.size() - 1);
    }
    //3 1 2 4
    public void inorder(TreeNode root, List<Integer> list){
        if (root == null) return;

        inorder(root.left, list);
        list.add(root.val);
        inorder(root.right, list);
    }

    public TreeNode build(List<Integer> sortedNode, int start, int end){
        if (start > end) return null;
        int mid = start + (end - start) / 2;
        TreeNode root = new TreeNode(sortedNode.get(mid));

        root.left = build(sortedNode, start, mid - 1);
        root.right = build(sortedNode, mid + 1, end);

        return root;
    }
}
