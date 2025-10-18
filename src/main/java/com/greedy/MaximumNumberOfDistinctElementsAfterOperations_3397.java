package com.greedy;

import com.search.Search2DMatrixII_240;

import java.util.*;

public class MaximumNumberOfDistinctElementsAfterOperations_3397 {
    public int maxDistinctElements(int[] nums, int k) {
        int n = nums.length;
        if (k == 0){
            Set<Integer> set = new HashSet<>();
            for (int num: nums) set.add(num);
            return set.size();
        }

        int[][] segs = new int[n][2];
        int minLeft = Integer.MAX_VALUE;
        for (int i = 0; i < nums.length; i++) {
            int L = nums[i] - k, R = nums[i] + k;
            segs[i][0] = L; segs[i][1] = R;
            minLeft = Math.min(minLeft, L);
        }

        Arrays.sort(segs, Comparator.comparingInt(i -> i[1]));
        int cur = minLeft;
        int ans = 0;
        for (int[] s: segs){
            int L = s[0], R = s[1];
            int pick = Math.max(cur, L);
            if (pick <= R){
                ans++;
                cur = pick + 1;
            }
        }

        return ans;
    }
}
