//package com.binary_tree;
//
//
//import structure.TreeNode;
//
//import javax.naming.ldap.PagedResultsControl;
//import java.util.*;
//
//public class AverageOfLevelInBinaryTree_637 {
//    public List<Double> averageOfLevels(TreeNode root) {
//        HashMap<Integer, Integer> count = new HashMap<>();
//        HashMap<Integer, Long> total = new HashMap<>();
//        Queue<Pair<TreeNode, Integer>> q = new ArrayDeque<>();
//        q.add(new Pair<>(root, 0));
//
//        while (!q.isEmpty()){
//            Pair<TreeNode, Integer> cur = q.poll();
//            TreeNode node = cur.getKey();
//            if(node.left != null) q.add(new Pair<>(node.left, cur.getValue() + 1));
//            if(node.right != null) q.add(new Pair<>(node.right, cur.getValue() + 1));
//            count.put(cur.getValue(), count.getOrDefault(cur.getValue(), 0) + 1);
//            total.put(cur.getValue(), total.getOrDefault(cur.getValue(), 0L) + cur.getKey().val);
//        }
//
//        List<Double> ans =new ArrayList<>();
//        for(Integer countKey: count.keySet()){
//            ans.add(total.get(countKey) / (double)count.get(countKey));
//        }
//
//        return ans;
//    }
//}
