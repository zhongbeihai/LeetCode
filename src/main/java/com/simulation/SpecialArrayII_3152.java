package com.simulation;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;

public class SpecialArrayII_3152 {
    public boolean[] isArraySpecial(int[] nums, int[][] queries) {
        int n = nums.length;
        List<int[]> specialArr = new ArrayList<>();
        int start = 0;
        for (int i = 1; i < n; i++) {
            if (nums[i] % 2 == nums[i - 1] % 2){
                specialArr.add(new int[]{start, i - 1});
                start = i;
            }
        }
        specialArr.add(new int[]{start, n - 1});

        specialArr.sort(Comparator.comparingInt(i -> i[0]));
        boolean[] res = new boolean[queries.length];
        for (int i = 0; i < queries.length; i++) {
            int[] q = queries[i];
            for (int[] s: specialArr){
                if (s[0] <= q[0] && s[1] >= q[1]) {
                    res[i] = true;
                    break;
                }
            }
        }

        return res;
    }

    public static void main(String[] args) {
        SpecialArrayII_3152 s = new SpecialArrayII_3152();
        s.isArraySpecial(new int[]{4,3,1,6}, new int[][]{{0,2},{2,3}});
    }
}
