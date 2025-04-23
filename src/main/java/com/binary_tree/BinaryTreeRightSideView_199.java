package com.binary_tree;

import structure.TreeNode;

import java.util.*;

public class BinaryTreeRightSideView_199 {
    public List<Integer> rightSideView(TreeNode root){
        if(root == null) return new ArrayList<>();

        ArrayDeque<TreeNode> q = new ArrayDeque<TreeNode>();
        ArrayList<Integer> list = new ArrayList<>();
        q.addLast(root);

        while (!q.isEmpty()){
            TreeNode lastNode = null;
            // To store the number of nodes of each layer
            int levelSize = q.size();

            for(int i = 0; i < levelSize; i++){
                TreeNode cur = q.poll();
                lastNode = cur;
                if(cur.left != null){
                    q.addLast(cur.left);
                }
                if(cur.right != null){
                    q.addLast(cur.right);
                }
            }
            list.add(lastNode.val);
        }
        return list;
    }
}
