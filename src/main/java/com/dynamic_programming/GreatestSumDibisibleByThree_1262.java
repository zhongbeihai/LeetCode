package com.dynamic_programming;

public class GreatestSumDibisibleByThree_1262 {
    public int maxSumDivThree(int[] nums) {
        int n = nums.length;
        if (n == 0) return 0;

        int[] dp = new int[3];
        dp[1] = dp[2] = -1;

        for (int x: nums){
            int[] next = dp.clone();
            int mod = x % 3;
            for (int r = 0; r < 3; r++) {
                if (dp[r] == -1) continue; // 不可达状态跳过
                int nr = (r + mod) % 3;
                next[nr] = Math.max(next[nr], dp[r] + x);
            }
            dp = next;
        }

        return dp[0];
    }

    public static void main(String[] args) {
        GreatestSumDibisibleByThree_1262 g= new GreatestSumDibisibleByThree_1262();
        g.maxSumDivThree(new int[]{3,6,5,1,8});
    }
}
