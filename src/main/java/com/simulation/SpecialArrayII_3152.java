package com.simulation;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;

public class SpecialArrayII_3152 {
    public boolean[] isArraySpecial(int[] nums, int[][] queries) {
        int n = nums.length;
        int[] prefix = new int[n]; // prefix[i] -> 0 -> i, how many break points in this range
        // [j, i] -> prefix[i] - prefix[j]
        // == 0, it is a special array
        for (int i = 1; i < n; i++) {
            if (nums[i] % 2 == nums[i - 1] % 2) prefix[i] = prefix[i - 1] + 1;
            else prefix[i] = prefix[i - 1];
        }

        boolean[] res = new boolean[queries.length];
        int i = 0;
        for(int[] q: queries){
            int start = q[0], end = q[1];
            res[i++] = prefix[start] - prefix[end] == 0;
        }

        return res;
    }

    public static void main(String[] args) {
        SpecialArrayII_3152 s = new SpecialArrayII_3152();
        s.isArraySpecial(new int[]{4,3,1,6}, new int[][]{{0,2},{2,3}});
    }
}
