package com.dynamic_programming;

import structure.TreeNode;

import java.util.Arrays;

public class HouseRobberIII_337 {
    public int rob(TreeNode root) {
        int[] res = new int[2];
        res = dfs(root);
        return Math.max(res[0], res[1]);
    }

    public int[] dfs(TreeNode root){
        //r[0] -> max value include left child and right child - cur.val
        //r[1] -> max value doesn't include left child and right child + cur.val
        int[] r = new int[2], rl = new int[2], rr = new int[2];
        if(root.left != null) {
            rl = dfs(root.left);
        }
        if(root.right != null){
            rr = dfs(root.right);
        }

        r[0] = Arrays.stream(rr).max().getAsInt() + Arrays.stream(rl).max().getAsInt();
        r[1] = rl[0] + rr[0] + root.val;

        return r;
    }
}
