package com.sliding_windows;

public class MaximumFruitsHarvestedAfterKMove_2106 {
    public int maxTotalFruits(int[][] fruits, int startPos, int k) {
        int n = fruits.length;


        int left = 0, right = 0, ans = 0, cnt = 0;
        while (right < n){
            cnt += fruits[right][1];

            while (left <= right && !canReach(fruits[left][0], fruits[right][0], startPos, k)){
                cnt -= fruits[left][1];
                left++;
            }

            ans = Math.max(ans, cnt);
            right++;
        }

        return ans;
    }

    public boolean canReach(int L, int R, int startPos, int k){
        // go left first and turn right
        int step1 = Math.abs(startPos - L) + (R - L);

        // go right first and turn left
        int step2 = Math.abs(startPos - R) + (R - L);

        return Math.min(step2, step1) <= k;
    }
}
