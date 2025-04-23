package com.binary_tree;

import structure.TreeNode;

import java.util.ArrayList;
import java.util.List;

public class PathSumII_113 {
    private List<List<Integer>> ans = new ArrayList<>();
    public List<List<Integer>> pathSum(TreeNode root, int targetSum) {
        if (root == null) return new ArrayList<>();
        dfs(root, targetSum, new ArrayList<>());

        return ans;
    }

    public void dfs(TreeNode root, int targetSum, List<Integer> tem){
        tem.add(root.val);
        int curSum = tem.stream().mapToInt(Integer::intValue).sum();
        if(root.left == null && root.right == null && curSum == targetSum){
            ans.add(new ArrayList<>(tem));
        }

        if(root.left != null) {
            dfs(root.left, targetSum, tem);
        }
        if(root.right != null){
            dfs(root.right, targetSum, tem);
        }

        tem.remove(tem.size() - 1);
    }

    public static void main(String[] args) {
        PathSumII_113 p = new PathSumII_113();

        TreeNode root = new TreeNode(5);

        root.left = new TreeNode(4);
        root.right = new TreeNode(8);

        root.left.left = new TreeNode(11);
        root.right.left = new TreeNode(13);
        root.right.right = new TreeNode(4);

        root.left.left.left = new TreeNode(7);
        root.left.left.right = new TreeNode(2);

        root.right.right.left = new TreeNode(5);
        root.right.right.right = new TreeNode(1);
        p.pathSum(root, 22);
    }
}
