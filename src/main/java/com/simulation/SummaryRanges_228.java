package com.simulation;

import java.util.ArrayList;
import java.util.List;

public class SummaryRanges_228 {
    public List<String> summaryRanges(int[] nums) {
        int n = nums.length, startIdx = 0;

        List<String> res = new ArrayList<>();
        for (int i = 1; i <= n; i++) {
            if (i == n || nums[i] - nums[i - 1] != 1){
                if (i - startIdx == 1) res.add(String.valueOf(nums[startIdx]));
                else res.add(nums[startIdx] + "->" + nums[i - 1]);

                startIdx = i;
            }
        }


        return res;
    }
}
