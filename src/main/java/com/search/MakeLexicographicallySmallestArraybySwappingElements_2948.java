package com.search;

import java.util.ArrayDeque;
import java.util.Arrays;
import java.util.Deque;
import java.util.HashMap;

public class MakeLexicographicallySmallestArraybySwappingElements_2948 {
    public int[] lexicographicallySmallestArray(int[] nums, int limit) {
        int n = nums.length;
        int[][] pairs = new int[n][2];
        for (int i = 0; i < n; i++){
            pairs[i] = new int[]{nums[i], i};
        }

        Arrays.sort(pairs, ((o1, o2) -> o1[0] - o2[0]));
        int grpNo = 0;
        HashMap<Integer, Deque<Integer>> grp = new HashMap<>();
        int[] idxToGrp = new int[n];

        idxToGrp[pairs[0][1]] = grpNo;
        grp.put(grpNo, new ArrayDeque<>());
        grp.get(grpNo).addLast(pairs[0][0]);

        for (int i = 1; i < n; i++){
            int last = grp.get(grpNo).getLast();
            if (pairs[i][0] - last <= limit){
                grp.get(grpNo).addLast(pairs[i][0]);
                idxToGrp[pairs[i][1]] = grpNo;
            }else {
                grpNo++;
                grp.put(grpNo, new ArrayDeque<>());
                grp.get(grpNo).addLast(pairs[i][0]);
                idxToGrp[pairs[i][1]] = grpNo;
            }
        }

        int[] res=new int[n];
        for(int i=0; i<n; i++){
            // Assign the smallest available number from each group
            res[i]=grp.get(idxToGrp[i]).pollFirst();
        }

        return res;
    }

    public static void main(String[] args) {
        MakeLexicographicallySmallestArraybySwappingElements_2948 m = new MakeLexicographicallySmallestArraybySwappingElements_2948();
        m.lexicographicallySmallestArray(new int[]{1,7,6,18,2,1}, 2);
    }
}
