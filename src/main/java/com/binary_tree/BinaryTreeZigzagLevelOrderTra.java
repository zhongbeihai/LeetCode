package com.binary_tree;

import structure.Pair;
import org.omg.CORBA.OMGVMCID;
import structure.TreeNode;

import java.util.*;

public class BinaryTreeZigzagLevelOrderTra {

    public List<List<Integer>> zigzagLevelOrder(TreeNode root) {
        if( root == null) return new ArrayList<>();
        return levelOrder(root);
    }

    public List<List<Integer>> levelOrder(TreeNode root){
        ArrayDeque<Pair<TreeNode, Integer>> q = new ArrayDeque<>();
        q.addLast(new Pair<>(root, 0));
        ArrayList<List<Integer>> res = new ArrayList<>();

        while (!q.isEmpty()){
            ArrayList<Integer> tem = new ArrayList<>();
            Pair<TreeNode, Integer> cur = q.pollFirst();
            int curLevel = cur.getValue();
            TreeNode curNode = cur.getKey();

            while (res.size() <= curLevel){
                res.add(new ArrayList<>());
            }

            if(curLevel % 2 == 0){
                res.get(curLevel).add(curNode.val);
            }else {
                res.get(curLevel).add(0, curNode.val);
            }

            if(curNode.left != null){
                q.addLast(new Pair<>(curNode.left, curLevel + 1));
            }
            if(curNode.right != null){
                q.addLast(new Pair<>(curNode.right, curLevel + 1));
            }
        }

        return res;
    }
}
