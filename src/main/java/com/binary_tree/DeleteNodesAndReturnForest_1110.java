package com.binary_tree;

import structure.TreeNode;

import java.util.*;

public class DeleteNodesAndReturnForest_1110 {
    // post Order dfs -> I want to process the children first
    // 1. put the to_delete into HashSet
    // 2. post order dfs -> if it needs to be deleted, return null
    //  if left child is not null -> the left child will be the root node of left subtree; same as right child
    // ; if not, return this node
    List<TreeNode> res = new ArrayList<>();  // store all the root node
    public List<TreeNode> delNodes(TreeNode root, int[] to_delete) {
        HashSet<Integer> deleteSet = new HashSet<>();
        for(int num: to_delete) deleteSet.add(num);

        root = dfs(root, deleteSet);
        if (root != null) res.add(root);

        return res;
    }

    public TreeNode dfs(TreeNode root, HashSet<Integer> deleteSet){
        // return condition
        if (root == null) return null;

        root.left = dfs(root.left, deleteSet);
        root.right = dfs(root.right, deleteSet);

        // when this node is needed to be deleted
        if (deleteSet.contains(root.val)){
            // check whether left child is null -> not null , it will become a new root node
            if (root.left != null){
                res.add(root.left);
            }
            if (root.right != null){
                res.add(root.right);
            }
            return null; // this node is deleted;
        }

        return root;
    }
}
