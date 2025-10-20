package com.greedy;

import com.search.Search2DMatrixII_240;

import java.util.*;

public class MaximumNumberOfDistinctElementsAfterOperations_3397 {
    public int maxDistinctElements(int[] nums, int k) {
        int n = nums.length;

        if (k == 0){
            Set<Integer> set = new HashSet<>();
            for (int num : nums) {
                set.add(num);
            }
            return set.size();
        }

        int[][] segs = new int[n][2];
        int minLeaf = Integer.MAX_VALUE;
        for (int i = 0; i < n; i++){
            int low = nums[i] - k, high = nums[i] + k;
            segs[i][0] = low; segs[i][1] = high;
            minLeaf = Math.min(minLeaf, low);
        }
        Arrays.sort(segs, Comparator.comparingInt(i -> i[1]));

        int ans = 0;
        int pick = minLeaf;
        for (int i = 0; i < n; i++) {
            int low = segs[i][0], high = segs[i][1];
            int choose = Math.max(pick, low);

            if (choose <= high){
                ans++;
                pick = choose + 1;
            }
        }

        return ans;
    }
}
