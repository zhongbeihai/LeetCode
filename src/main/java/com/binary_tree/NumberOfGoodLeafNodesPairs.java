package com.binary_tree;

import structure.TreeNode;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class NumberOfGoodLeafNodesPairs {
    private int cnt = 0;
    public int countPairs(TreeNode root, int distance) {
        DFS(root, distance, 0);
        return cnt;
    }

    public List<Integer> DFS(TreeNode root, int distance, int level) {
        if(root == null) {
            return new ArrayList<>();
        }
        if(root.left == null && root.right == null) {
            List<Integer> l = new ArrayList<>();
            l.add(level);
            return l;
        }

        List<Integer> left = new ArrayList<>(), right = new ArrayList<>();
        if(root.left != null) {
           left = DFS(root.left, distance, level+1);
        }
        if(root.right != null) {
            right = DFS(root.right, distance, level+1);
        }
        for(int l: left){
            for(int r: right){
                if(Math.abs((l - level) + (r - level)) <= distance) cnt++;
            }
        }

        left.addAll(right);
        return left;
    }

    public static void main(String[] args) {
        TreeNode n1 = new TreeNode(1);
        TreeNode n2 = new TreeNode(2);
        TreeNode n3 = new TreeNode(3);
        TreeNode n4 = new TreeNode(4);
        TreeNode n5 = new TreeNode(5);
        TreeNode n6 = new TreeNode(6);
        TreeNode n7 = new TreeNode(7);

        n1.left = n2;
        n1.right = n3;
        n2.left = n4;
        n2.right = n5;
        n3.left = n6;
        n3.right = n7;
        NumberOfGoodLeafNodesPairs n = new NumberOfGoodLeafNodesPairs();
        n.countPairs(n1, 3);
    }
}
