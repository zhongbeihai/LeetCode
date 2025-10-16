package com.search;

import java.util.Arrays;
import java.util.HashMap;

public class FindRightInterval_436 {
    public int[] findRightInterval(int[][] intervals) {
        int n = intervals.length;
        int[] starts = new int[n];
        HashMap<Integer, Integer> startToIdx = new HashMap<>();
        for (int i = 0; i < n; i++) {
            int s = intervals[i][0];
            starts[i] = s;
            startToIdx.put(s, i);
        }
        Arrays.sort(starts);

        int[] res = new int[n];
        for (int i = 0; i < n; i++){
            int end = intervals[i][1];
            int l = 0, h = n;
            while (l < h){
                int mid = (l + h) >>> 1;
                if (starts[mid] >= end){
                    h = mid;
                }else {
                    l = mid + 1;
                }
            }

            if (l == n) res[i] = -1;
            else res[i] = startToIdx.get(starts[l]);
         }

        return res;
    }

    public static void main(String[] args) {
        FindRightInterval_436 f = new FindRightInterval_436();
        f.findRightInterval(new int[][]{{3,4},{2,3},{1,2}});
    }
}
